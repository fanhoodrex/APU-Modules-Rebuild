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
    public partial class Student_StudentRegister : Form

    {
        private OleDbConnection connection = new OleDbConnection("Provider=Microsoft.Jet.OLEDB.4.0;Data Source=Wawasan Tuition Centre.mdb");
        OleDbCommand command = new OleDbCommand();
        public Student_StudentRegister()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            connection.ConnectionString = "Provider=Microsoft.Jet.OLEDB.4.0;Data Source=Wawasan Tuition Centre.mdb";
            try
            {
                connection.Open();
                OleDbCommand command = connection.CreateCommand();
                command.CommandType = CommandType.Text;
                command.CommandText = "insert into [Users] (FirstName,LastName,ContactNumber,Email,UserID,Password) values ('" + txtFirstName.Text + "','" + txtLastName.Text + "','" + txtContactNumber.Text + "','" + txtEmail.Text + "','" + txtUserID.Text + "','" + txtPassword.Text + "')";
                command.ExecuteNonQuery();
                connection.Close();
                MessageBox.Show("Data Saved");



            }
            catch (Exception ex)
            {
                MessageBox.Show("Connection Failed\r\n\r\n" + ex.Message);
            }
        }

        private void Student_StudentRegister_Load(object sender, EventArgs e)
        {

        }

        private void button2_Click(object sender, EventArgs e)
        {
            this.Hide();
            Student_MainPage SMP = new Student_MainPage();
            SMP.ShowDialog();

        }
    }
}
