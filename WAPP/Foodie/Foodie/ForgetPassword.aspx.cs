using System;
using System.Collections.Generic;
using System.Configuration;
using System.Data;
using System.Data.SqlClient;
using System.Linq;
using System.Net;
using System.Net.Mail;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace Foodie
{
    public partial class ForgetPassword : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void btnReset_Click(object sender, EventArgs e)
        {
            txtEmail.Text = string.Empty;
        }

        protected void btnSubmit_Click(object sender, EventArgs e)
        {
            string username = "";
            string password = "";
            SqlConnection con = new SqlConnection(ConfigurationManager.ConnectionStrings["foodieConnectionString"].ConnectionString);
            SqlCommand cmd = new SqlCommand("select username,password from Users where email=@email", con);
            cmd.Parameters.AddWithValue("@email", txtEmail.Text);
            con.Open();
            using (SqlDataReader sdr = cmd.ExecuteReader())
            {
                if (sdr.Read())
                {
                    username = sdr["username"].ToString();
                    password = sdr["password"].ToString();

                    
                }


            }
            con.Close();

            if (!string.IsNullOrEmpty(password))
            {
                // need to  turn on the less secure app in gmail accont setting
                MailMessage msg = new MailMessage();
                msg.From = new MailAddress("nameweethebest@gmail.com");//dummy email added
                msg.To.Add(txtEmail.Text);
                msg.Subject = "Recover yoour password";
                msg.Body = ("Your username:" + username + "<br/><br/>" + "Your Password :" + password);
                msg.IsBodyHtml = true;

                SmtpClient smt = new SmtpClient();
                smt.Host = "smtp.gmail.com";
                System.Net.NetworkCredential ntwd = new NetworkCredential();
                ntwd.UserName = "nameweethebest@gmail.com";
                ntwd.Password = "ilovenamewee";
                smt.UseDefaultCredentials = true;
                smt.Credentials = ntwd;
                smt.Port = 587;
                smt.EnableSsl = true;
                smt.Send(msg);
                lblMessage.ForeColor = System.Drawing.Color.ForestGreen;
                lblMessage.Text = "Username and Password Sent Successfully";




            }

            else {

                lblMessage.ForeColor = System.Drawing.Color.Red;
                lblMessage.Text = "No fuck";
            }


        }
    }
}