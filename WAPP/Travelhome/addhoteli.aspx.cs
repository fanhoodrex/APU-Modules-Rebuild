using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Configuration;
using System.Data.SqlClient;
using System.IO;
using System.Data;

public partial class addhoteli : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {
        if (Session["uType"] == null )
            Response.Redirect("Login.aspx");
    }
    protected void btnadd_Click(object sender, EventArgs e)
    {
         SqlConnection con = new SqlConnection(ConfigurationManager.ConnectionStrings["ConnectionString"].ConnectionString);
        try
        {
            con.Open();
            Stream fs = fuProdImage.PostedFile.InputStream;
            BinaryReader br = new BinaryReader(fs);
            byte[] content =br.ReadBytes((Int32)fs.Length);
            string query1="insert into hoteli (Hotelname,Priceperday,Location,Himage)values(@hotelname,@Priceperday,@Location,@Himage)";
            SqlCommand cmd1=new SqlCommand(query1,con);
            cmd1.Parameters.AddWithValue("@hotelname",txthotelname.Text);
            cmd1.Parameters.AddWithValue("@Priceperday",txtprice.Text);
            cmd1.Parameters.AddWithValue("@Location",txtlocation.Text);
            cmd1.Parameters.AddWithValue("@Himage",content);
            cmd1.ExecuteNonQuery();
            con.Close();
            Response.Write("<script>alert('Add successful!');window.location.href='Adminf.aspx';</script>");
        } catch(Exception ex){
    Response.Write("Error: "+ ex.ToString());
    }
    }
    }