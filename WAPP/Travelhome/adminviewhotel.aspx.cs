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


public partial class adminviewhotel : System.Web.UI.Page
{
    SqlConnection con = new SqlConnection(ConfigurationManager.ConnectionStrings["ConnectionString"].ConnectionString);
    public static int id = 0;
    protected void Page_Load(object sender, EventArgs e)
    {
        if (Session["uType"] == null )
            Response.Redirect("Login.aspx");
    }
    public string fetchData()
    {
        string htmlStr = "";
        SqlConnection con = new SqlConnection(ConfigurationManager.ConnectionStrings["ConnectionString"].ConnectionString);
        con.Open();
        string query = "select*from userbuyhotel ";
        SqlCommand cmd = new SqlCommand(query, con);
        SqlDataReader reader = cmd.ExecuteReader();
        while (reader.Read())
        {
            string idcard = reader.GetString(1);
            string hotelname = reader.GetString(2);
            string uname = reader.GetString(3);
            string price = reader.GetString(4);
            string status = reader.GetString(5);
            htmlStr += "<tr><td>" + idcard + "</td><td>" + hotelname + "</td><td>" + uname + "</td><td>" + price + "</td><td>" + status + "</td></tr>";
        }
        con.Close();
        return htmlStr;
    }
    protected void btnupdate_Click(object sender, EventArgs e)
    {
        con.Open();
        string query = "update userbuyhotel  set price ='" + txtprice.Text + "',status='" + txtstatus.Text + "'where id ='" + id + "'";
        SqlCommand cmd = new SqlCommand(query, con);
        cmd.ExecuteNonQuery();
        con.Close();
    }
    protected void btncheck_Click(object sender, EventArgs e)
    {
        SqlDataAdapter da = new SqlDataAdapter("select * from userbuyhotel where idcard='" + txtid.Text + "'", con);
        DataTable dt = new DataTable();
        da.Fill(dt);
        id = Convert.ToInt16(dt.Rows[0][0]);
        txtprice.Text = dt.Rows[0][4].ToString();
        txtstatus.Text = dt.Rows[0][5].ToString();
    }
    protected void btndelete_Click(object sender, EventArgs e)
    {
        con.Open();
        string query = "delete from userbuyhotel where Id='" + id + "'";
        SqlCommand cmd = new SqlCommand(query, con);
        cmd.ExecuteNonQuery();
        con.Close();
    }
}