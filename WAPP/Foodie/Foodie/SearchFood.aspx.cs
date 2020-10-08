using System;
using System.Collections.Generic;
using System.Configuration;
using System.Data;
using System.Data.SqlClient;
using System.IO;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
namespace Foodie
{
    public partial class SearchFood : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            Panel1.Visible = false;
        }

        protected void btnAdd_Click(object sender, EventArgs e)
        {
            try
            {



                SqlConnection con = new SqlConnection(ConfigurationManager.ConnectionStrings["foodieConnectionString"].ConnectionString);

                con.Open();


                SqlDataAdapter da = new SqlDataAdapter("select * from Products where productName='" + txtProductName.Text + "'", con);


                // SqlDataAdapter da = new SqlDataAdapter("select * from Products where productName Like'%" + txtProductName.Text + "%'", con);
                //the like is able to show the data as long as there is at least one letter match with the product name in the database



                DataTable dt = new DataTable();
                da.Fill(dt);

                if (dt.Rows.Count == 0)
                {
                    Response.Write("<script type=\"text/javascript\">alert('No such Item Exist.');</script>");


                }

                else
                {
                    Panel1.Visible = true;

                    string id = dt.Rows[0][0].ToString();
                    lblProdName.Text = dt.Rows[0][1].ToString();
                    lblProdDesc.Text = dt.Rows[0][2].ToString();
                    lblProdPrice.Text = dt.Rows[0][3].ToString();
                    imgProd.ImageUrl = "ImageHandler.ashx?ID=" + id;
                    /*Add generic handler for image handler*/
                }

                con.Close();



            }

            catch (Exception ex)
            {
                Response.Write(ex);

            }
        }

        protected void btnReset_Click(object sender, EventArgs e)
        {
            txtProductName.Text = string.Empty;
            lblMessage.Text = string.Empty;
            lblProdDesc.Text = string.Empty;
            lblProdName.Text = string.Empty;
            lblProdPrice.Text = string.Empty;
            imgProd.ImageUrl = string.Empty;
            // clear the check value
        }
    }
}