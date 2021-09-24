using shoppingbsform.Model;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Dapper;
using Dapper.Contrib.Extensions;

namespace shoppingbsform.DAL
{
    public class UserDal : BaseDAL<User>
    {

        public User GetByUserName(string username)
        {
            username = username.ToLower();
            return FindByName("username", new { username }) ;
        }

        public User GetByEmail(string email)
        {
            email = email.ToLower();
            return FindByName("email", new { email });
        }
    }
}
