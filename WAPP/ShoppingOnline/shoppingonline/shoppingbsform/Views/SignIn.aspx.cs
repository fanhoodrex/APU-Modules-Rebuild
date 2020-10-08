using shoppingbsform.Model;
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
    public partial class SignIn : System.Web.UI.Page
    {
        public string HeaderName = "Sign In To Books Shopping Home";

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

        protected void signin_btn_Click(object sender, EventArgs e)
        {
            var doscript = (Literal)this.Master.FindControl("doscript");

            if (useranme.Text.IsNullOrEmpty() || password.Text.IsNullOrEmpty())
            {
                doscript.Text = $"<script>msg='Anyone of your information cant not be empty.'</script>";
                return;
            }

            var user = new User();
            var msg = UserViewModel.Instance.Login(useranme.Text, password.Text,ref user);

            
            if (msg.IsNullOrEmpty())
            {
                Response.Cookies["user"].Value = useranme.Text;
                Response.Cookies["userid"].Value = user.Id;
                Response.Cookies["type"].Value = user.type.ToString();
                //set cookies expire time
                Response.Cookies["user"].Expires = DateTime.Now.AddDays(1);
                Response.Cookies["userid"].Expires = DateTime.Now.AddDays(1);
                Response.Cookies["type"].Expires = DateTime.Now.AddDays(1);
                Response.Redirect("~/");
            }
            else
            {
                doscript.Text = $"<script>msg='{msg}'</script>";
            }

        }
    }
}