using shoppingbsform.Model;
using shoppingbsform.ViewModels;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Services;

namespace shoppingbsform
{
    /// <summary>
    /// Summary description for WebService1
    /// </summary>
    
    [WebService(Namespace = "http://tempuri.org/")]
    [WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
    [System.ComponentModel.ToolboxItem(false)]
    // To allow this Web Service to be called from script, using ASP.NET AJAX, uncomment the following line. 
    [System.Web.Script.Services.ScriptService]
    
    public class WebService1 : System.Web.Services.WebService
    {
        [System.Web.Script.Services.ScriptMethod(ResponseFormat = System.Web.Script.Services.ResponseFormat.Json)]
        [WebMethod]
        public ResponseResult DeleteBook(string id)
        {
            return new ResponseResult() { Success = BooksViewModel.Instance.DeleteBook(id) };
        }


        [System.Web.Script.Services.ScriptMethod(ResponseFormat = System.Web.Script.Services.ResponseFormat.Json)]
        [WebMethod]
        public ResponseResult AddCart(string userid,string bookid)
        {
            return new ResponseResult() { Success = CartViewModel.Instance.AddCart(userid, bookid) };
        }

        [System.Web.Script.Services.ScriptMethod(ResponseFormat = System.Web.Script.Services.ResponseFormat.Json)]
        [WebMethod]
        public ResponseResult DeleteCart(string id)
        {
            return new ResponseResult() { Success = CartViewModel.Instance.DeleteCart(id) };
        }
    }
}
