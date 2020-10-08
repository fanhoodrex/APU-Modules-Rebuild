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
using System.Xml.XPath;
using System.Xml.Xsl;
using System.Text;
public partial class statustrian : System.Web.UI.Page
{
    public string strtrainstaDetails = string.Empty;
    protected void Page_Load(object sender, EventArgs e)
    {
        if (Session["uType"] == null )
            Response.Redirect("Login.aspx");

        SqlConnection con = new SqlConnection(ConfigurationManager.ConnectionStrings["ConnectionString"].ConnectionString);
        con.Open();
        string query = "select * from userbuytrain where idcard ='" + txtid.Text + "'";
        DataSet ds = new DataSet("Trainsta");
        SqlDataAdapter da = new SqlDataAdapter(query, con);
        da.Fill(ds);
        //Get the XML From DataSet
        string strXML = ds.GetXml();
        strtrainstaDetails = GetHtml(Server.MapPath("~/xsl/Trainstatus.xslt"), strXML);
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
    protected void btnadd_Click(object sender, EventArgs e)
    {
        
    }
}