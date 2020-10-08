using System;
using System.Collections.Generic;
using System.Configuration;
using System.Data;
using System.Data.SqlClient;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
namespace Foodie
{
    public partial class Food : System.Web.UI.Page
    {


        SqlConnection con = new SqlConnection(ConfigurationManager.ConnectionStrings["foodieConnectionString"].ConnectionString);
        protected void Page_Load(object sender, EventArgs e)
        {
         /*   if (Session["uType"] == null || !Session["uType"].Equals("Customer"))
                Response.Redirect("Login.aspx");*/


            string a;
            a = ConfigurationManager.ConnectionStrings["foodieConnectionString"].ToString();
            SqlConnection con = new SqlConnection(a);


            con.Open();
            SqlCommand cmd = con.CreateCommand();
            cmd.CommandType = CommandType.Text;
            cmd.CommandText = "select * from Products";
            DataTable dt = new DataTable();
            SqlDataAdapter da = new SqlDataAdapter(cmd);
            da.Fill(dt);
            DataList1.DataSource = dt;
            DataList1.DataBind();







            con.Close();





           
         
            SqlCommand cmd1 = new SqlCommand("select * from productImage", con);
            

            
        }


        public string fetchData()
        {
            string htmlStr = "";
            SqlConnection con = new SqlConnection(ConfigurationManager.ConnectionStrings["foodieConnectionString"].ConnectionString);
            con.Open();
            SqlCommand cmd = con.CreateCommand();
            cmd.CommandType = CommandType.Text;
            cmd.CommandText = "select * from Products";
            DataTable dt = new DataTable();
            SqlDataAdapter da = new SqlDataAdapter(cmd);

            DataList1.DataSource = dt;
            DataList1.DataBind();

            con.Close();
            return htmlStr;
        }

    }
}