using shoppingbsform.Model;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Dapper;

namespace shoppingbsform.DAL
{
    public class CartDal : BaseDAL<Cart>
    {
        public List<Cart> GetAllCart(string userid)
        {
            var sql = $"select * from {TableName} where userid=@userid";
            return Connection.Query<Cart>(sql, new { userid }).ToList();
        }

        public List<UserCart> GetUserCarts(string userid)
        {


            var sql = @"select [book].image,[cart].id as cartid,[user].[username],[user].id as userid,[book].id as bookid,[book].price as bookprice,[book].name as bookname
from [cart]
left join [book] on [book].id=[cart].bookid 
left join [user] on [user].id=[cart].userid where cart.userid=@userid";
            return Connection.Query<UserCart>(sql, new { userid }).ToList();
        }

        public List<UserCart> GetAllUserCarts()
        {
            var sql = @"select [book].image,[cart].id as cartid,[user].[username],[user].id as userid,[book].id as bookid,[book].price as bookprice,[book].name as bookname
from [cart]
left join [book] on [book].id=[cart].bookid 
left join [user] on [user].id=[cart].userid";
            return Connection.Query<UserCart>(sql, new { }).ToList();
        }
    }
}
