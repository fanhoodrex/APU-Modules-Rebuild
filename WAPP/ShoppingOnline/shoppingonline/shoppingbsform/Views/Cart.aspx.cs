using shoppingbsform.ViewModels;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace shoppingbsform.Views
{
    public partial class Cart : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            if (Request.Cookies["user"] != null && Request.Cookies["type"].Value == "0")
            {
                var carts = CartViewModel.Instance.GetCarts(Request.Cookies["userid"].Value);
                var content = "";
                foreach (var cart in carts)
                {
                    content += @"<li>
                        <div class='layui-row'>
                              <div class='layui-col-md3'>
                                <span class='bookdetail name'>" + cart.Bookname + @"</span>
                            </div>
                            <div class='layui-col-md3'>
                                <image style='height:50px' src=data:image/jpeg;base64," + cart.Image + @"></image>
                            </div>
                            <div class='layui-col-md3'>
                                <span class='bookdetail price'>$" + cart.BookPrice + @"</span>
                            </div>
                            <div class='layui-col-md3'>
                                <a class='layui-btn layui-btn-danger' id='" + cart.CartId + @"bookdetail' onclick='DeleteCart(this)'>Delete</a>
                            </div>
                        </div>
                        <hr>
                    </li>".Replace("\r\n", string.Empty);
                }


                cartdetailscript.Text = "<script>$('.cartdetails').html(`"+ content + "`)</script>";
            }
        }
    }
}