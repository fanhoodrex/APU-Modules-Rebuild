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
    public partial class Login : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void btnLogin_Click(object sender, EventArgs e)
        {
            //connectionstring problem
            SqlConnection con = new SqlConnection(ConfigurationManager.ConnectionStrings["foodieConnectionString"].ConnectionString);
            con.Open();
            SqlCommand cmd = new SqlCommand("select count(*) from Users where Username='" + txtUsername.Text + "'and Password='" + txtPassword.Text + "'", con);
            int count = Convert.ToInt32(cmd.ExecuteScalar().ToString());

            if (count > 0)
            {
                SqlCommand cmdType = new SqlCommand("select usertype from Users where username='" + txtUsername.Text + "'", con);
                SqlCommand cmdUser = new SqlCommand("select username from Users where username='" + txtUsername.Text + "'", con);
                string uType = cmdType.ExecuteScalar().ToString().Replace(" ", "");
                string username = cmdUser.ExecuteScalar().ToString().Replace(" ", "");
                 Session["uType"] = uType;
                Session["uname"] = username;
               /* Session["uname"] = username;*/
                Response.Redirect("HOME.aspx");
                Response.Redirect("Site.Master.cs");
              
            }

            else
            {

                lblMessage.ForeColor = System.Drawing.Color.Red;
                lblMessage.Text = "Login Failed!";
            }
            con.Close();
        }

        protected void btnReset_Click(object sender, EventArgs e)
        {
            txtPassword.Text = string.Empty;
            txtUsername.Text = string.Empty;
        }

        protected void LinkButton1_Click(object sender, EventArgs e)
        {
            Response.Redirect("ForgetPassword.aspx");
        }
    }
}