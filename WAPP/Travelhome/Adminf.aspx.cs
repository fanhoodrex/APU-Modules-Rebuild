using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class Adminf : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {
        if (Session["uType"] == null )  
            Response.Redirect("Alogin.aspx"); 
      
    }
    protected void btnaai_Click(object sender, EventArgs e)
    {
        Response.Redirect("addairi.aspx");
    }
    protected void btnati_Click(object sender, EventArgs e)
    {
        Response.Redirect("Addtrain.aspx");
    }
    protected void btnahi_Click(object sender, EventArgs e)
    {
        Response.Redirect("addhoteli.aspx");
    }
    protected void btnva_Click(object sender, EventArgs e)
    {
        Response.Redirect("adminviewair.aspx");
    }
    protected void btnvt_Click(object sender, EventArgs e)
    {
        Response.Redirect("adminviewtrain.aspx");
    }
    protected void btnvh_Click(object sender, EventArgs e)
    {
        Response.Redirect("adminviewhotel.aspx");
    }
    protected void btnr_Click(object sender, EventArgs e)
    {
        Response.Redirect("Aregist.aspx");
    }
}