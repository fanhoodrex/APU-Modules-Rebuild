using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Club_And_Society_Management_System
{
    public class clubMembership
    {
        public int id {set; get;}
        public int studentid { set; get; }
        public int clubid { set; get; }
        public string dt { set; get; }

        public clubMembership()
        {

        }

        public clubMembership(int clubid)
        {
            this.clubid = clubid;
        }

        public List<clubMembership> getClubMemberships()
        {
            List<clubMembership> memberships = new List<clubMembership>();
            DataTable dt = dbConnection.selectData("SELECT * FROM club_membership WHERE clubid = '" + this.clubid + "';");
            foreach (DataRow dr in dt.Rows)
            {
                memberships.Add(new clubMembership() { id = dr.Field<int>("id"), studentid = dr.Field<int>("studentid"), dt = dr.Field<String>("dt"), clubid = dr.Field<int>("clubid") });
            }
            return memberships;
        }

        public bool enroll(int studentid)
        {
            return dbConnection.manipulateData("INSERT INTO club_membership ([studentid],[clubid],[dt]) VALUES ('" + studentid + "','" + this.clubid + "','" + System.DateTime.Now.ToString("dd/MM/yyyy") + "')");
        }

        public bool checkUnique(int studentid)
        {
            int i = dbConnection.getRowCount("SELECT studentid FROM club_membership WHERE clubid = '" + this.clubid + "' AND studentid = '" + studentid + "'");
            return i > 0 ? false : true;
        }

        public bool remove(int studentid)
        {
            return dbConnection.manipulateData("DELETE FROM club_membership WHERE clubid = '" + this.clubid + "' AND studentid = '" + studentid + "'");
        }

        public static bool unjoinAll(int studentid)
        {
            return dbConnection.manipulateData("DELETE FROM club_membership WHERE studentid = '" + studentid + "'");
        }

        public static bool validateJoined(int studentID)
        {
            return dbConnection.getRowCount("SELECT count(id) FROM club_membership WHERE studentid = '" + studentID + "'") > 0 ? true : false;
        }
        public static bool checkIsSecretary(int studentID)
        {
            return dbConnection.getRowCount("SELECT count(id) FROM club_membership WHERE studentid = '" + studentID + "'") > 0 ? true : false;
        }

        public static int getClubID(int studentID)
        {
            int i = 0;
            DataTable dt = dbConnection.selectData("SELECT clubid FROM club_membership WHERE studentid = '" + studentID + "'");
            foreach (DataRow dr in dt.Rows)
            {
                if (int.TryParse(dr["clubid"].ToString(), out i))
                {
                    return i;
                }
                else
                {
                    return i;
                }
            }
            return i;
        }
    }
}
