using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Data.OleDb;

namespace Wawasan_Tuition_Centre
{
    public partial class Staff_StudentEnrollment : Form
    {
        OleDbConnection connection = new OleDbConnection();
        OleDbCommand command = new OleDbCommand();
        public Staff_StudentEnrollment()
        {
            connection.ConnectionString = "Provider=Microsoft.Jet.OLEDB.4.0;Data Source=Wawasan Tuition Centre.mdb";

            InitializeComponent();
        }

        private void label3_Click(object sender, EventArgs e)
        {

        }

        private void textBox4_TextChanged(object sender, EventArgs e)
        {

        }

        private void label5_Click(object sender, EventArgs e)
        {

        }

        private void button1_Click(object sender, EventArgs e)
        {
            try
            {
                connection.Open();
                OleDbCommand command = connection.CreateCommand();
                command.CommandType = CommandType.Text;
                command.CommandText = "insert into [EnrollmentNumber] (StudentID,ClassID) values ('" + txtStudentID.Text + "','" + txtClassIDE.Text + "')";
                command.ExecuteNonQuery();
                connection.Close();
                MessageBox.Show("Student Enroll Successfully");



            }
            catch (Exception ex)
            {
                MessageBox.Show("Connection Failed\r\n\r\n" + ex.Message);
            }
        }

        private void button2_Click(object sender, EventArgs e)
        {
            try
            {
                command.CommandText = "select count(ClassID) from EnrollmentNumber having ClassID = '" + txtClassID.Text + "'";
                command.Connection = connection;
                
                OleDbDataReader reader = command.ExecuteReader();
                if (reader.Read() == true)
                {

                    txtnumberofstu.Text = reader[0].ToString();
                    connection.Close();
                }

                else
                {
                    MessageBox.Show("Your class ID does not exist in our database.Please contact our staff for more details");
                }

            }
            catch (Exception ex)
            {
                MessageBox.Show("Connection Failed\r\n\r\n" + ex.Message);
            }

        }

        private void button3_Click(object sender, EventArgs e)
        {
            this.Hide();
            Staff_MainPage f4 = new Staff_MainPage();
            f4.ShowDialog();

        }

        private void Staff_StudentEnrollment_Load(object sender, EventArgs e)
        {
            connection.Open();
        }
    }
}
