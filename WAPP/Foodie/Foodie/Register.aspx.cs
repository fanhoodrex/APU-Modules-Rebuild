using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Configuration;
using System.Data.SqlClient;


namespace Foodie
{
    public partial class Register : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void btnReset_Click(object sender, EventArgs e)
        {
            txtUsername.Text = string.Empty;
            txtPassword.Text = string.Empty;
            txtEmail.Text = string.Empty;
            rbGender.SelectedIndex = 0;
            ddlCountry.SelectedIndex = 0;
            ddlUserType.SelectedIndex = 0;
            
        }

        protected void btnSubmit_Click(object sender, EventArgs e)
        {
            SqlConnection con = new SqlConnection(ConfigurationManager.ConnectionStrings["foodieConnectionString"].ConnectionString);
            try
            { 
                con.Open();
                string query = "select count(*) from Users where email='" + txtEmail.Text + "'";
                string query2 = "select count(*) from Users where username='" + txtUsername.Text + "'";
                SqlCommand cmd = new SqlCommand(query, con);
                SqlCommand cmd2 = new SqlCommand(query2, con);
                int check = Convert.ToInt32(cmd.ExecuteScalar().ToString());
                int check2 = Convert.ToInt32(cmd2.ExecuteScalar().ToString());


                if (check2 > 0)
                {
                    Response.Write("<script type=\"text/javascript\">alert('Username already exist.');</script>");

                }
                else if (check2 == 0)
                {

                    if (check > 0)
                    {
                        Response.Write("<script type=\"text/javascript\">alert('Email already exist.');</script>");
                    }
                    else
                    {
                        string query1 = "insert into Users (username,password,email,gender,country,usertype,address)values(@uname,@pword,@email,@gender,@country,@usertype,@address)";
                        SqlCommand cmd1 = new SqlCommand(query1, con);
                        cmd1.Parameters.AddWithValue("@uname", txtUsername.Text);
                        cmd1.Parameters.AddWithValue("@pword", txtPassword.Text);
                        cmd1.Parameters.AddWithValue("@email", txtEmail.Text);
                        cmd1.Parameters.AddWithValue("@gender", rbGender.SelectedItem.ToString());
                        cmd1.Parameters.AddWithValue("@country", ddlCountry.SelectedItem.ToString());
                        cmd1.Parameters.AddWithValue("@usertype", ddlUserType.SelectedItem.ToString());
                        cmd1.Parameters.AddWithValue("@address", txtAddress.Text);
                        cmd1.ExecuteNonQuery();
                        Response.Write("<script type=\"text/javascript\">alert('Registration Successful.');</script>");

                    }
                }


                con.Close();


            }

            catch (Exception ex)
            {

                Response.Write("Error madafaka" + ex.ToString());
            }
        }

       
    }
}