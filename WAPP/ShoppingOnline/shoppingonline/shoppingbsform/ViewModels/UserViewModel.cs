using shoppingbsform.DAL;
using shoppingbsform.Model;
using shoppingbsform.Utils;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace shoppingbsform.ViewModels
{
    public class UserViewModel
    {
        public static UserViewModel Instance = new UserViewModel();

        private UserDal dal = new UserDal();
        public string Login(string username, string password, ref User getuser)
        {
            try
            {
                var getbyusername = dal.GetByUserName(username);
                var getbyemail = dal.GetByEmail(username);

                var user = getbyusername == null ? getbyemail : getbyusername;

                if (user != null)
                {
                    getuser = user;
                    var equals = user.password.Replace(EncryptionHelper.GetMd5Str(password).ToLower(), string.Empty) == string.Empty ? true : false;
                    if (equals)
                    {
                        return string.Empty;
                    }
                    else
                    {
                        return "username/email or password error.";
                    }
                }
                else
                {
                    return "The user not exist.";
                }
            }
            catch (Exception ex)
            {
                Log.Error(ex);
                return "System error";
            }

        }

        public bool SignUp(string username, string email, string password)
        {
            try
            {
                return dal.Insert(new Model.User { Id = Tool.GetNewGuid(), username = username, email = email, password = EncryptionHelper.GetMd5Str(password) });
            }
            catch (Exception ex)
            {
                Log.Error(ex);
            }

            return false;
        }

        public User GetUser(string username)
        {
            try
            {
                return dal.GetByUserName(username);
            }
            catch (Exception ex)
            {
                Log.Error(ex);
            }

            return new User();
        }

        public bool SaveUser(string username,string email, string password, string address, string telphone)
        {
            try
            {
                var user = dal.GetByUserName(username);
                user.email = email;
                user.password = EncryptionHelper.GetMd5Str(password);
                user.address = address;
                user.telphone = telphone;
                return dal.Update(user);
            }
            catch (Exception ex)
            {
                Log.Error(ex);
            }

            return false;
        }
    }
}