using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace Foodie
{
    public partial class HOME : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            if (Session["uType"] != null)
            {
                Response.Write("<script>alert('HELLO' + '" + Session["uname"] + "')</script>");
                
            }
            else
            {
                Response.Write("<script> alert('PLEASE LOGIN FIRST') </script>");
            }

            



           
        }
    }
}