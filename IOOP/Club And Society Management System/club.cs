using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Club_And_Society_Management_System
{
    class club
    {
        public string name { get; set; }
        public string president { get; set; }
        public string vicePresident { get; set; }
        public int secretaryID { get; set; }

        public int id { get; set; }

        public int isActive { get; set; }

        public string description { get; set; }

        public DateTime dtCreated { get; set; }

        public club(){

        }

        public club(int id)
        {
            this.id = id;
        }

        public override string ToString()
        {
            return string.Format("{0} {1}", id, name);
        }

        public static bool create(string clubName,string president, string vicePresident, int secretaryID,string description)
        {
            return dbConnection.manipulateData("INSERT INTO club ([clubName],[president],[vicePresident],[secretary],[description],[dt]) VALUES ('" + clubName + "','" + president + "','" + vicePresident + "','" + secretaryID + "','" + description + "',GETDATE())");
        }

        public static List<club> GetActiveClubs()
        {
            List<club> clubs = new List<club>();
            //DataTable dat = dbConnection.selectData("SELECT * FROM club WHERE isActive =0;");
            DataTable dat = dbConnection.selectData("SELECT * FROM club WHERE isActive = 1;");
            if (dat.Rows.Count == 0) {
                return clubs;
            }
            foreach (DataRow dr in dat.Rows)
            {
                clubs.Add(new club() {
                    id = dr.Field<int>("id"),
                    name = dr.Field<String>("clubName"),
                    isActive = dr.Field<int>("isActive"),
                    president = dr.Field<string>("president"),
                    vicePresident = dr.Field<String>("vicePresident"),
                    secretaryID = dr.Field<int>("secretary"),
                    dtCreated = dr.Field<DateTime>("dt")
                });
            }
            return clubs;
        }

        public static List<club> GetArchivedClubs()
        {
            List<club> clubs = new List<club>();
            DataTable dat = dbConnection.selectData("SELECT * FROM club WHERE isActive = 0;");
            if (dat.Rows.Count == 0)
            {
                return clubs;
            }
            foreach (DataRow dr in dat.Rows)
            {
                clubs.Add(new club()
                {
                    id = dr.Field<int>("id"),
                    name = dr.Field<String>("clubName"),
                    isActive = dr.Field<int>("isActive"),
                    president = dr.Field<string>("president"),
                    vicePresident = dr.Field<String>("vicePresident"),
                    secretaryID = dr.Field<int>("secretary"),
                    dtCreated = dr.Field<DateTime>("dt")
                });
            }
            return clubs;
        }

        public bool update(String clubName, string president, string vicePresident, int secretaryID, string description, int status) {
            return dbConnection.manipulateData("UPDATE club SET [clubName] = '" + clubName + "',[president] = '" + president + "',[vicePresident] = '" + vicePresident + "',[secretary] = '" + secretaryID + "',[description] = '" + description + "',[isActive] = '" + status + "' WHERE id = '" + this.id + "'");
        }
        public static string getDescription(int id)
        {
            
            DataTable dt = dbConnection.selectData("SELECT description FROM club WHERE id = '" + id + "'");
            foreach (DataRow dr in dt.Rows)
            {
                return dr["description"].ToString();
            }
            return null;
        }

        public static string getClubName(int id)
        {

            DataTable dt = dbConnection.selectData("SELECT clubName FROM club WHERE id = '" + id + "'");
            foreach (DataRow dr in dt.Rows)
            {
                return dr["clubName"].ToString();
            }
            return null;
        }
    }
}
