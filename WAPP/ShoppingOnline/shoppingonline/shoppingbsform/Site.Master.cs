using shoppingbsform.Model;
using shoppingbsform.Utils;
using shoppingbsform.ViewModels;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text.RegularExpressions;
using System.Web;
using System.Web.Services;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace shoppingbsform
{

    public partial class SiteMaster : MasterPage
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            var username = Request.Cookies["user"];
            if (username != null)
            {
                doscript.Text += $"<script>ShowUserInfo(true);username='{username.Value}'</script>";

                // feed back
                var type = Request.Cookies["type"].Value;
                var userid = Request.Cookies["userid"].Value;
                if (type == "1") //admin
                {
                    var feedback = FeedBackViewModel.Instance.GetUnReplayFeedback();
                    if (feedback != null)
                    {
                        doscript.Text += $"<script>$('.feeedbackcount').html('1')</script>";
                    }
                    else
                    {
                        doscript.Text += $"<script>$('.feeedbackcount').html('0')</script>";
                    }

                    doscript.Text += $"<script>ShowAdmin(true);</script>";
                }
                else // normal users
                {
                    var feedback = FeedBackViewModel.Instance.GetReplaiedFeedBack(userid);
                    if (feedback != null)
                    {
                        doscript.Text += $"<script>$('.feeedbackcount').html('1');</script>";
                    }
                    else
                    {
                        doscript.Text += $"<script>$('.feeedbackcount').html('0');</script>";
                    }

                    doscript.Text += $"<script>ShowAdmin(false);</script>";

                    var carts = CartViewModel.Instance.GetCarts(userid);

                    doscript.Text += $"<script>$('.cartcount').html('{carts.Count}')</script>";
                }


            }
            else
            {
                doscript.Text = "<script>ShowUserInfo(false)</script>";
            }
        }

        protected void Signout_link_Click(object sender, EventArgs e)
        {
            Response.Cookies["user"].Expires = DateTime.Now.AddDays(-1);
            Response.Cookies["userid"].Expires = DateTime.Now.AddDays(-1);
            Response.Cookies["type"].Expires = DateTime.Now.AddDays(-1);
            Response.Redirect("~/");
        }

        protected void PersonalInfolink_Click(object sender, EventArgs e)
        {
            Response.Redirect("/Views/PersonalInfo");
        }

        protected void Feedbacklink_Click(object sender, EventArgs e)
        {
            var type = Request.Cookies["type"].Value;
            var userid = Request.Cookies["userid"].Value;
            if (type == "1") //admin
            {
                var feedback = FeedBackViewModel.Instance.GetUnReplayFeedback();
                if (feedback == null)
                {
                    doscript.Text += $"<script>msg='No feed back to replay.';ShowUserInfo(true);</script>";
                    return;
                }

                Response.Redirect("/Views/ReplayFeedback");

            }
            else // normal users
            {
                var feedback = FeedBackViewModel.Instance.GetReplaiedFeedBack(userid);
                if (feedback == null)
                {

                    //doscript.Text += "<script>layer.msg('Replay successfully.',{time:2000},function(){" +
                    //            "window.location = '/'" +
                    //            "})</script>";
                    doscript.Text = $"<script>msg='No feed back to review.';ShowUserInfo(true);</script>";
                    return;
                }

                Response.Redirect("/Views/ReviewFeedback");
            }

        }

        public String GetBooks()
        {
            //var list = new List<Book>();
            //for (var i = 0; i < 65; i++)
            //{
            //    var obj = new Book() { Name = "test book name"+ (i+1), Description = "qwqwqw", Price = (decimal)21.38 };
            //    list.Add(obj);
            //}

            return JsonHelper.Serializer(BooksViewModel.Instance.GetALlBooks());

        }

        [System.Web.Services.WebMethod()]
        [System.Web.Script.Services.ScriptMethod()]
        public static string HelloMethod(string name)
        {
            return "hello";
        }
        ///   <summary>



        ///   去除HTML标记

        ///   </summary>

        ///   <param   name="NoHTML">包括HTML的源码   </param>

        ///   <returns>已经去除后的文字</returns>  

        public string NoHTML(string Htmlstring)

        {

            //删除脚本  

            Htmlstring = Regex.Replace(Htmlstring, @"<script[^>]*?>.*?</script>", "", RegexOptions.IgnoreCase);

            //删除HTML  

            Htmlstring = Regex.Replace(Htmlstring, @"<(.[^>]*)>", "", RegexOptions.IgnoreCase);

            Htmlstring = Regex.Replace(Htmlstring, @"([\r\n])[\s]+", "", RegexOptions.IgnoreCase);

            Htmlstring = Regex.Replace(Htmlstring, @"-->", "", RegexOptions.IgnoreCase);

            Htmlstring = Regex.Replace(Htmlstring, @"<!--.*", "", RegexOptions.IgnoreCase);

            Htmlstring = Regex.Replace(Htmlstring, @"&(quot|#34);", "\"", RegexOptions.IgnoreCase);

            Htmlstring = Regex.Replace(Htmlstring, @"&(amp|#38);", "&", RegexOptions.IgnoreCase);

            Htmlstring = Regex.Replace(Htmlstring, @"&(lt|#60);", "<", RegexOptions.IgnoreCase);

            Htmlstring = Regex.Replace(Htmlstring, @"&(gt|#62);", ">", RegexOptions.IgnoreCase);

            Htmlstring = Regex.Replace(Htmlstring, @"&(nbsp|#160);", "   ", RegexOptions.IgnoreCase);

            Htmlstring = Regex.Replace(Htmlstring, @"&(iexcl|#161);", "\xa1", RegexOptions.IgnoreCase);

            Htmlstring = Regex.Replace(Htmlstring, @"&(cent|#162);", "\xa2", RegexOptions.IgnoreCase);

            Htmlstring = Regex.Replace(Htmlstring, @"&(pound|#163);", "\xa3", RegexOptions.IgnoreCase);

            Htmlstring = Regex.Replace(Htmlstring, @"&(copy|#169);", "\xa9", RegexOptions.IgnoreCase);

            Htmlstring = Regex.Replace(Htmlstring, @"&#(\d+);", "", RegexOptions.IgnoreCase);

            Htmlstring.Replace("<", "");

            Htmlstring.Replace(">", "");

            Htmlstring.Replace("\r\n", "");

            Htmlstring = HttpContext.Current.Server.HtmlEncode(Htmlstring).Trim();

            return Htmlstring;

        }
    }
}