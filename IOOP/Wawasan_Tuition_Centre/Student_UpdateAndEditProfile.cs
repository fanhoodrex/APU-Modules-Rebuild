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
    public partial class Student_UpdateAndEditProfile : Form
    {
        private OleDbConnection connection = new OleDbConnection("Provider=Microsoft.Jet.OLEDB.4.0;Data Source=Wawasan Tuition Centre.mdb");
        OleDbCommand command = new OleDbCommand();


        public Student_UpdateAndEditProfile()
        {
            InitializeComponent();
        }

        private void button2_Click(object sender, EventArgs e)
        {
            try
            {
                connection.Open();
                OleDbCommand command = connection.CreateCommand();
                command.CommandType = CommandType.Text;
                command.CommandText = "UPDATE [Users] SET (FirstName,LastName,ContactNumber,Email,Role) values ('" + txtFirstName.Text + "','" + txtLastName.Text + "','" + txtContactNumber.Text + "','" + txtEmail.Text + "',' + Student+ ') where StudentID = "+txtStudentID.Text+"";
                command.ExecuteNonQuery();
                connection.Close();
                MessageBox.Show("Data Update Successfully");



            }
            catch (Exception ex)
            {
                MessageBox.Show("Connection Failed\r\n\r\n" + ex.Message);
            }
        }

        private void button3_Click(object sender, EventArgs e)
        {
            this.Hide();
            Student_MainPage SMP = new Student_MainPage();
            SMP.ShowDialog();

        }
    }
}
