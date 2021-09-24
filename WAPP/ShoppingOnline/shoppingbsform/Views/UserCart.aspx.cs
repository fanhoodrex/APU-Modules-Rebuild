using shoppingbsform.ViewModels;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace shoppingbsform.Views
{
    public partial class UserCart : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            if (Request.Cookies["type"] != null)
            {
                if (Request.Cookies["type"].Value == "1")
                {
                    var content = "";

                    //content += @"<div class='layui-colla-item'>
                    //            <h2 class='layui-colla-title'>杜甫</h2>
                    //            <div class='layui-colla-content  layui-show'>内容区域</div>
                    //            </div>";

                    var allcarts = CartViewModel.Instance.GetAllCarts().GroupBy(m => m.Username);
                    foreach (var group in allcarts)
                    {
                        content += @"<div class='layui-colla-item'>";

                        content += @"<h2 class='layui-colla-title'>" + group.First().Username + "</h2>";


                        content += "<div class='layui-colla-content'><ul>";
                        foreach (var cart in group)
                        {
                            content += @"<li>
                        <div class='layui-row'>
                              <div class='layui-col-md4'>
                                <span class='bookdetail name'>" + cart.Bookname + @"</span>
                            </div>
                            <div class='layui-col-md4'>
                                <image style='height:50px' src=data:image/jpeg;base64," + cart.Image + @"></image>
                            </div>
                            <div class='layui-col-md4'>
                                <span class='bookdetail price'>$" + cart.BookPrice + @"</span>
                            </div>
                        </div>
                        <hr>
                    </li>".Replace("\r\n", string.Empty);

                        }
                        content += @"</ul></div></div>";

                    }


                    usercartjscripts.Text += "<script>$('.usercartitems').html(`" + content + "`)</script>";


                }
                else
                {
                    Response.Redirect("~/");
                }
            }
        }
    }
}