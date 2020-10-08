using System;
using System.Collections.Generic;
using System.Data;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;


namespace Club_And_Society_Management_System
{
    class dbConnection
    {
        static SqlConnection cnn;
        static string connetionString = @"data source=HYBRIDCORE;
                                  initial catalog=club_management_system;
                                  integrated security=SSPI;
                                  persist security info=False;
                                  Trusted_Connection=Yes";
        public static SqlConnection connect()
        {
            cnn = new SqlConnection(connetionString);
            cnn.Open();
            return cnn;
        }

        public static DataTable selectData(String query)
        {
            SqlCommand cmd = new SqlCommand(query, connect());
            DataTable dt = new DataTable();
            SqlDataAdapter da = new SqlDataAdapter(cmd);
            da.Fill(dt);
            cmd.Dispose();
            cnn.Close();
            return dt;
        }

        public static SqlDataReader getOneData(String query)
        {
            SqlCommand cmd = new SqlCommand(query, connect());
            SqlDataReader dr = cmd.ExecuteReader();
            cmd.Dispose();
            cnn.Close();
            return dr;
        }

        public static bool manipulateData(String query)
        {
            SqlCommand cmd = new SqlCommand(query, connect());
            bool res = cmd.ExecuteNonQuery() > 0 ? true : false;
            cnn.Close();
            return res;
        }

        public static int getRowCount(String query)
        {
            SqlCommand cmd = new SqlCommand(query, connect());
            return (int)cmd.ExecuteScalar();
        }

        public static Object getSingleColData(String query, string col)
        {
            SqlCommand cmd = new SqlCommand(query, connect());
            SqlDataReader dr = cmd.ExecuteReader();
            while (dr.Read())
            {
                return dr[col];
            }
            return null;
        }
    }
}
