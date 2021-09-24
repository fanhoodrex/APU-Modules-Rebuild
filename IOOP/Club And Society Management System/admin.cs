using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Club_And_Society_Management_System
{
    class admin
    {
        public int id { get; set; }
        public string name { get; set; }

        public admin()
        {

        }
        public admin(int id)
        {
            this.id = id;
        }
        public override string ToString()
        {
            return string.Format("ID:{0} | Name:{1}", id, name);
        }

        public static bool create(string name, string password)
        {
            return dbConnection.manipulateData("INSERT INTO admin (adminName,password) VALUES ('" + name + "','" + util.createMD5(password) + "')");
        }

        public List<admin> GetAdminProfile()
        {
            DataTable dt = dbConnection.selectData("SELECT * FROM admin WHERE id ='" + this.id + "';");
            List<admin> admins = new List<admin>();
            foreach (DataRow dr in dt.Rows)
            {
                admins.Add(new admin() { id = dr.Field<int>("id"), name = dr.Field<String>("adminName") });
            }
            return admins;
        }
        
        public static string getFullNameByID(int id)
        {
            DataTable dt = dbConnection.selectData("SELECT adminName FROM admin WHERE id = '" + id + "'");
            foreach (DataRow dr in dt.Rows)
            {
                return dr["adminName"].ToString();
            }
            return null;
        }

        public static bool auth(int id, string pass)
        {
            return dbConnection.getRowCount("SELECT count(id) FROM admin WHERE id = '" + id + "' AND password = '" + util.createMD5(pass) + "'") > 0 ? true : false;
        }
        //public static int getAdminID(int id, string pass)
        //{
        //    return int.Parse(dbConnection.getSingleColData("SELECT id FROM admin WHERE id = '" + id + "' AND password = '" + util.createMD5(pass) + "'", "id").ToString());
        //}
    }
}
