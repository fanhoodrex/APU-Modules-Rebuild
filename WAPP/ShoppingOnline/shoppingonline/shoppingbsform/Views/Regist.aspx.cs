using shoppingbsform.Utils;
using shoppingbsform.ViewModels;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace shoppingbsform.Views
{
    public partial class Regist : System.Web.UI.Page
    {
        public string WebName
        {
            get => Appsettings.Instance.WebName;
        }
        protected void Page_Load(object sender, EventArgs e)
        {
            if (Request.Cookies["user"] != null)
            {
                Response.Redirect("~/");
            }
        }

        protected void signup_btn_Click(object sender, EventArgs e)
        {
            var doscript = (Literal)this.Master.FindControl("doscript");
            if (useranme.Text.IsNullOrEmpty() || password.Text.IsNullOrEmpty() || Email.Text.IsNullOrEmpty())
            {
                doscript.Text = $"<script>msg='Anyone of your information cant not be empty.'</script>";
                return;
            }

            var signupresult = UserViewModel.Instance.SignUp(useranme.Text, Email.Text, password.Text);

            
            if (signupresult)
            {
                doscript.Text = "<script>layer.msg('Sign up successfully,please sign in.',{time:2000},function(){" +
                    "window.location = '/Views/SignIn'" +
                    "})</script>";
            }
            else
            {
                doscript.Text = "<script>msg='Sign up failed,please check your information.'</script>";
            }
        }
    }
}