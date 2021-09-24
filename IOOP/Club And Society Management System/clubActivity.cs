using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Club_And_Society_Management_System
{
    class clubActivity
    {
        public string description { set; get; }

        public int id { set; get; }

        public int clubid { set; get; }

        public string dt { set; get; }

        public clubActivity()
        {

        }

        public override string ToString()
        {
            return string.Format("{0} {1}", id, description, dt, clubid);
        }

        public clubActivity(int clubid)
        {
            this.clubid = clubid;
        }

        public static List<clubActivity> getClubActivities(int clubid)
        {
            List<clubActivity> activities = new List<clubActivity>();
            DataTable dt = dbConnection.selectData("SELECT * FROM clubActivity WHERE clubid = '" + clubid + "';");
            foreach (DataRow dr in dt.Rows)
            {
                activities.Add(new clubActivity() { id = dr.Field<int>("id"), description = dr.Field<String>("description"), dt = dr.Field<String>("dt"), clubid = dr.Field<int>("clubid") });
            }
            return activities;
        }

        public List<clubActivity> getAllClubActivities()
        {
            List<clubActivity> activities = new List<clubActivity>();
            DataTable dt = dbConnection.selectData("SELECT * FROM clubActivity;");
            foreach (DataRow dr in dt.Rows)
            {
                activities.Add(new clubActivity() { id = dr.Field<int>("id"), description = dr.Field<String>("description"), dt = dr.Field<String>("dt"), clubid = dr.Field<int>("clubid") });
            }
            return activities;
        }

        public bool create(string description, string dt)
        {
            return dbConnection.manipulateData("INSERT INTO clubActivity ([description],[clubid],[dt]) VALUES ('" + description + "','" + this.clubid + "','" + dt + "')");
        }

        public static bool update(int id, string description, string dt)
        {
            return dbConnection.manipulateData("UPDATE clubActivity SET description = '" + description + "', dt = '" + dt + "' WHERE id = '" + id + "'");
        }

        public static bool delete(int id)
        {
            return dbConnection.manipulateData("DELETE FROM clubActivity WHERE id = '" + id + "'");
        }
    }
}
