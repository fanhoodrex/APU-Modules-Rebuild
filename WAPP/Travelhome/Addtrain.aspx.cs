using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Configuration;
using System.Data.SqlClient;
using System.Threading;


public partial class Addtrain : System.Web.UI.Page
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
            string query = "select count(*)from traini where Trainnumber ='" + txttrainno.Text + "'";
            SqlCommand cmd = new SqlCommand(query, con);
            int check = Convert.ToInt32(cmd.ExecuteScalar().ToString());
            if (check > 0)
            {
                Response.Write("<script type=\"text/javascript\">alert('Train number already exist.');</script>");

            }
            else
            {
                string query1 = "insert into traini(Trainnumber,Date,Departurestation,Arrivalstation,Price) values (@Trainnumber,@Date,@Departurestation,@Arrivalstation,@Price)";
                SqlCommand cmd1 = new SqlCommand(query1, con);
                cmd1.Parameters.AddWithValue("@Trainnumber", txttrainno.Text);
                cmd1.Parameters.AddWithValue("@Date", txtdate.Text);
                cmd1.Parameters.AddWithValue("@Departurestation", txtdeparture.Text);
                cmd1.Parameters.AddWithValue("@Arrivalstation", txtdestination.Text);
                cmd1.Parameters.AddWithValue("@Price", txtprice.Text);
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