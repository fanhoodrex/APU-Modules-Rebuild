using System;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace shoppingbsform
{
    public partial class _Default : Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            if (Request.Cookies["user"] != null)
            {
                // get books infos 

                var type = Request.Cookies["type"].Value;
                var doscript = (Literal)this.Master.FindControl("doscript");

                if (type == "1") //admin
                {
                    //var content = @"<div class='layui-row'>
                    //                 <div class='layui-col-md3'>
                    //                    <div class='layui-card'>
                    //                        <div class='layui-card-header bookname'></div>
                    //                        <div class='layui-card-body bookbody'>
                    //                        </div>
                    //                    </div>
                    //                </div>
                    //               </div>".Replace("\r\n","").Trim();

                    //doscript.Text += "<script>$(document).ready(function(){LoadBooks(\""+ content + "\");" +"});" +"</script>";



                    // show admin menu
                    // doscript.Text += "<script>ShowAdmin(true)</script>";

                }
                else // normal users
                {
                    // doscript.Text += "<script>ShowAdmin(false)</script>";
                }
            }
        }
    }
}