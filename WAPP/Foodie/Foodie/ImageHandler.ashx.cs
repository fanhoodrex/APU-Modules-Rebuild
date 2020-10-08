using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Configuration;
using System.Data.SqlClient;

namespace Foodie
{
    /// <summary>
    /// Summary description for ImageHandler
    /// </summary>
    public class ImageHandler : IHttpHandler
    {

        public void ProcessRequest(HttpContext context)
        {
            string constr = ConfigurationManager.ConnectionStrings["foodieConnectionString"].ConnectionString;
            string ImgID = context.Request.QueryString["id"].ToString();
            SqlConnection conn = new SqlConnection(constr);
            SqlCommand cmd = new SqlCommand("Select productImage from Products where productId=" + ImgID, conn);
            conn.Open();
            SqlDataReader dr = cmd.ExecuteReader();
            dr.Read();
            context.Response.BinaryWrite((byte[])dr["productImage"]);
            dr.Close();
            conn.Close();
        }

        public bool IsReusable
        {
            get
            {
                return false;
            }
        }
    }
}