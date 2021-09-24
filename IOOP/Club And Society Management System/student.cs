using System;
using System.Collections.Generic;
using System.Data;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Club_And_Society_Management_System
{
    class student
    {
        public int id { get; set; }
        public string name { get; set; }

        public student()
        {

        }
        public student(int id)
        {
            this.id = id;
        }
        public override string ToString()
        {
            return string.Format("ID:{0} | Name:{1}", id, name);
        }

        public static bool create(string name,string password)
        {
            return dbConnection.manipulateData("INSERT INTO student (studentName,password) VALUES ('" + name + "','" + util.createMD5(password) + "')");
        }

        public static List<student> GetStudentsProfile()
        {
            DataTable dt = dbConnection.selectData("SELECT * FROM student;");
            List<student> students = new List<student>();
            foreach (DataRow dr in dt.Rows)
            {
                students.Add(new student() { id = dr.Field<int>("id"), name = dr.Field<String>("studentName") });
            }
            return students;
        }

        public static List<student> GetStudentsProfileExcludeJoined()
        {
            DataTable dt = dbConnection.selectData("SELECT student.id,student.studentName FROM student LEFT JOIN club_membership ON student.id = club_membership.studentid WHERE club_membership.studentid IS NULL");
            List<student> students = new List<student>();
            foreach (DataRow dr in dt.Rows)
            {
                students.Add(new student() { id = dr.Field<int>("id"), name = dr.Field<String>("studentName") });
                
            }
            return students;
        }

        public static string getFullNameByID(int id)
        {
            DataTable dt = dbConnection.selectData("SELECT studentName FROM student WHERE id = '" + id + "'");
            foreach (DataRow dr in dt.Rows)
            {
                return dr["studentName"].ToString();
            }
            return null;
        }

        public static bool auth(int id,string pass)
        {
            return dbConnection.getRowCount("SELECT count(id) FROM student WHERE id = '" + id + "' AND password = '" + util.createMD5(pass) + "'") > 0 ? true : false;
        }
    }
}
