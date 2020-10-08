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
    public partial class AddFood : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
          /*  if (Session["uType"] == null || !Session["uType"].Equals("Admin"))
                Response.Redirect("Login.aspx");*/
        }

        protected void btnAdd_Click(object sender, EventArgs e)
        {
            SqlConnection con = new SqlConnection(ConfigurationManager.ConnectionStrings["foodieConnectionString"].ConnectionString);

            try
            {
                con.Open();
                Stream fs = fuProductImg.PostedFile.InputStream;
                BinaryReader br = new BinaryReader(fs);
                byte[] content = br.ReadBytes((Int32)fs.Length);

                string query1 = "insert into Products (productName,productDescription,productPrice,productImage)values (@pName,@pDesc,@pPrice,@pImage) ";
                SqlCommand cmd1 = new SqlCommand(query1, con);
                cmd1.Parameters.AddWithValue("@pName", txtProductName.Text);
                cmd1.Parameters.AddWithValue("@pDesc", txtDescription.Text);
                cmd1.Parameters.AddWithValue("@pPrice", txtPrice.Text);
                cmd1.Parameters.AddWithValue("@pImage", content);
                cmd1.ExecuteNonQuery();

                lblMessage.ForeColor = System.Drawing.Color.ForestGreen;
                lblMessage.Text = "Product added successfully";
                con.Close();

            }


            catch (Exception ex)
            {
                Response.Write("Error" + ex.ToString());

            }
        }

        protected void btnReset_Click(object sender, EventArgs e)
        {
            txtDescription.Text = string.Empty;
            txtPrice.Text = string.Empty;
            txtProductName.Text = string.Empty;
        }
    }
}