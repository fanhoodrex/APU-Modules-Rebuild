using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class UserBudget : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {
        if (Session["uType"] == null)
            Response.Redirect("Login.aspx");
    }

    protected void btncheck_Click(object sender, EventArgs e)
    {
        Response.Redirect("placeRecommendation.aspx");
    }
}