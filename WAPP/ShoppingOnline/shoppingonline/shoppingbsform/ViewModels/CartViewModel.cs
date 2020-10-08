using shoppingbsform.DAL;
using shoppingbsform.Model;
using shoppingbsform.Utils;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace shoppingbsform.ViewModels
{
    public class CartViewModel
    {

        public static CartViewModel Instance = new CartViewModel();

        CartDal dal = new CartDal();

        public bool AddCart(string userid,string bookid)
        {
            try
            {

                return dal.Insert(new Model.Cart() { Id=Tool.GetNewGuid(),userid = userid,bookid=bookid});
            }
            catch (Exception ex)
            {
                Log.Error(ex);
            }
            return false;
        }

        public List<UserCart> GetCarts(string userid)
        {
            try
            {

                return dal.GetUserCarts(userid);
            }
            catch (Exception ex)
            {
                Log.Error(ex);
            }
            return new List<UserCart>();
        }

        public List<UserCart> GetAllCarts()
        {
            try
            {

                return dal.GetAllUserCarts();
            }
            catch (Exception ex)
            {
                Log.Error(ex);
            }
            return new List<UserCart>();
        }


        public bool DeleteCart(string id)
        {
            try
            {

                return dal.Delete(id);
            }
            catch (Exception ex)
            {
                Log.Error(ex);
            }
            return false;
        }
    }
}