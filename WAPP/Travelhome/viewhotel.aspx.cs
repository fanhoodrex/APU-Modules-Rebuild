using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Configuration;
using System.Data.SqlClient;
using System.Threading;
using System.Data;
using System.IO;
using System.Text;
using System.Xml.XPath;
using System.Xml.Xsl;


public partial class viewhotel : System.Web.UI.Page
{
    public string strhotelDetails = string.Empty;
    protected void Page_Load(object sender, EventArgs e)
    {
        if (Session["uType"] == null )
            Response.Redirect("Login.aspx");

        SqlConnection con = new SqlConnection(ConfigurationManager.ConnectionStrings["ConnectionString"].ConnectionString);
        con.Open();
        string query = "select * from hoteli";
        DataSet ds = new DataSet("Hoteldetail");
        SqlDataAdapter da = new SqlDataAdapter(query, con);
        da.Fill(ds);
        //Get the XML From DataSet
        string strXML = ds.GetXml();
        strhotelDetails = GetHtml(Server.MapPath("~/xsl/Hoteldetail.xslt"), strXML);
    }
    public static string GetHtml(string xsltPath, string xml)
    {
        MemoryStream stream = new MemoryStream(ASCIIEncoding.Default.GetBytes(xml));
        XPathDocument document = new XPathDocument(stream);
        StringWriter writer = new StringWriter();
        XslCompiledTransform transform = new XslCompiledTransform();
        transform.Load(xsltPath);
        transform.Transform(document, null, writer);
        return writer.ToString();
    }
  




    protected void btnorder_Click(object sender, EventArgs e)
    {
        SqlConnection con = new SqlConnection(ConfigurationManager.ConnectionStrings["ConnectionString"].ConnectionString);
        try
        {
            con.Open();
            string query = "select count(*)from userbuyhotel where idcard ='" + idnum.Text + "'";
            SqlCommand cmd = new SqlCommand(query, con);
            int check = Convert.ToInt32(cmd.ExecuteScalar().ToString());
            if (check > 15)
            {
                Response.Write("<script type=\"text/javascript\">alert('Your account has ordered too many times.');</script>");
            }
            else
            {
                string query1 = "insert into userbuyhotel(idcard,hotelname,uname,price,status) values (@idcard,@hotelname,@uname,@price,@status)";
                SqlCommand cmd1 = new SqlCommand(query1, con);
                cmd1.Parameters.AddWithValue("@idcard", idnum.Text);
                cmd1.Parameters.AddWithValue("@hotelname", txthotelname.Text);
                cmd1.Parameters.AddWithValue("@uname", txtrname.Text);
                this.txtprice.Text = "In progress waiting for admin update";
                cmd1.Parameters.AddWithValue("@price", txtprice.Text);
                this.txtstatus.Text = "In progress waiting for admin update";
                cmd1.Parameters.AddWithValue("@status", txtstatus.Text);
                cmd1.ExecuteNonQuery();
                con.Close();
                Response.Write("<script>alert('Order successful!');window.location.href='Home.aspx';</script>");
            }
        }
        catch (Exception ex)
        {
            Response.Write("Error: " + ex.ToString());
        }
    }
}