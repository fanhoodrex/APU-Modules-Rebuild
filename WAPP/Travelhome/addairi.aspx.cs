using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Configuration;
using System.Data.SqlClient;


public partial class addairi : System.Web.UI.Page
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
            string query = "select count(*)from airlinei where airnumber ='" + txtairlineno.Text + "'";
            SqlCommand cmd = new SqlCommand(query, con);
            int check = Convert.ToInt32(cmd.ExecuteScalar().ToString());
            if (check > 0)
            {
                Response.Write("<script type=\"text/javascript\">alert('Airline number already exist.');</script>");

            }
            else
            {
                string query1 = "insert into airlinei(airnumber,date,departure,destination,price) values (@airnumber,@date,@departure,@destination,@price)";
                SqlCommand cmd1 = new SqlCommand(query1, con);
                cmd1.Parameters.AddWithValue("@airnumber", txtairlineno.Text);
                cmd1.Parameters.AddWithValue("@date", txtdate.Text);
                cmd1.Parameters.AddWithValue("@departure", txtdeparture.Text);
                cmd1.Parameters.AddWithValue("@destination", txtdestination.Text);
                cmd1.Parameters.AddWithValue("@price", txtprice.Text);
                cmd1.ExecuteNonQuery();
                con.Close();
                Response.Write("<script>alert('Add successful!');window.location.href='Adminf.aspx';</script>");
            }
        }
        catch (Exception ex)
        {
            Response.Write("Errpr:" + ex.ToString());
        }
    }
}