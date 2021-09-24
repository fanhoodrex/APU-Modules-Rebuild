using shoppingbsform.Model;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Dapper;

namespace shoppingbsform.DAL
{
    public class BookDal : BaseDAL<Book>
    {

        public bool DeleteCartsByBook(string bookid)
        {
            var sql = "delete from [cart] where bookid=@bookid";
            Connection.Execute(sql, new { bookid });
            return true;
        }
    }
}
