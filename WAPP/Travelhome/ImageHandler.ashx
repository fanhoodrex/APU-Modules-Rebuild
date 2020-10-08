<%@ WebHandler Language="C#" Class="ImageHandler" %>

using System;
using System.Web;
using System.Configuration;
using System.Data.SqlClient;
public class ImageHandler : IHttpHandler {
    
    public void ProcessRequest (HttpContext context) {
        string constr = ConfigurationManager.ConnectionStrings["ConnectionString"].ConnectionString;
        string imgID = context.Request.QueryString["id"].ToString();
        SqlConnection conn = new SqlConnection(constr);
        SqlCommand cmd = new SqlCommand("Select Himage from hoteli where Id =" + imgID, conn);
        conn.Open();
        SqlDataReader dr = cmd.ExecuteReader();
        dr.Read();
        context.Response.BinaryWrite((byte[])dr["Himage"]);
        dr.Close();
        conn.Close();
        
    }
 
    public bool IsReusable {
        get {
            return false;
        }
    }

}