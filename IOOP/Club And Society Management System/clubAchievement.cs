using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Club_And_Society_Management_System
{
    class clubAchievement
    {
        public string description { set; get; }

        public int id { set; get; }

        public int clubid { set; get; }

        public string dt { set; get; }

        public clubAchievement()
        {

        }

        public override string ToString()
        {
            return string.Format("{0} {1}", id, description,dt,clubid);
        }

        public clubAchievement(int clubid)
        {
            this.clubid = clubid;
        }

        public static List<clubAchievement> getClubAchievements(int clubid)
        {
            List<clubAchievement> achievements = new List<clubAchievement>();
            DataTable dt = dbConnection.selectData("SELECT * FROM clubAchievement WHERE clubid = '" + clubid + "';");
            foreach (DataRow dr in dt.Rows)
            {
                achievements.Add(new clubAchievement() { id = dr.Field<int>("id"), description = dr.Field<String>("description"), dt = dr.Field<String>("dt"), clubid = dr.Field<int>("clubid") });
            }
            return achievements;
        }

        public List<clubAchievement> getAllClubAchievements()
        {
            List<clubAchievement> achievements = new List<clubAchievement>();
            DataTable dt = dbConnection.selectData("SELECT * FROM clubAchievement;");
            foreach (DataRow dr in dt.Rows)
            {
                achievements.Add(new clubAchievement() { id = dr.Field<int>("id"), description = dr.Field<String>("description"), dt = dr.Field<String>("dt"), clubid = dr.Field<int>("clubid") });
            }
            return achievements;
        }

        public bool create(string description, string dt)
        {
            return dbConnection.manipulateData("INSERT INTO clubAchievement ([description],[clubid],[dt]) VALUES ('" + description + "','" + this.clubid + "','" + dt + "')");
        }

        public static bool update(int id,string description, string dt)
        {
            return dbConnection.manipulateData("UPDATE clubAchievement SET description = '" + description+ "', dt = '" + dt + "' WHERE id = '" + id + "'");
        }

        public static bool delete(int id)
        {
            return dbConnection.manipulateData("DELETE FROM clubAchievement WHERE id = '" + id + "'");
        }
    }
}
