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
    public partial class Login : Form
    {
         OleDbConnection connection = new OleDbConnection();
        public Login()
        {
            connection.ConnectionString = "Provider=Microsoft.Jet.OLEDB.4.0;Data Source=Wawasan Tuition Centre.mdb";
            InitializeComponent();
        }

        private void button2_Click(object sender, EventArgs e)
        {

        }

        private void button1_Click(object sender, EventArgs e)
        {
            connection.Open();
            OleDbCommand command = new OleDbCommand();
            command.Connection = connection;
            command.CommandText = "select * from Users where UserID = '" + txtUserID.Text +"' and Password = '" + txtPassword.Text + "' and Role = '" + comboBox1.Text +"'";
            command.ExecuteNonQuery();

           

            
            OleDbDataReader reader = command.ExecuteReader();
            int count = 0;
            while (reader.Read())
            {
                count = count + 1;
            }
            if ((count == 1) && (comboBox1.Text == "Staff"))
            {
                MessageBox.Show("Login Successful");
                connection.Close();
                connection.Dispose();
                this.Hide();
                Staff_MainPage f4 = new Staff_MainPage();
                f4.ShowDialog();
            }
            else if ((count == 1) && (comboBox1.Text == "Student"))
            {
                MessageBox.Show("Login Successful");
                connection.Close();
                connection.Dispose();
                this.Hide();
                Student_MainPage SMP = new Student_MainPage();
                SMP.ShowDialog();
            }
            else if ((count == 1) && (comboBox1.Text == "Tutor"))
            {
                MessageBox.Show("Login Successful");
                connection.Close();
                connection.Dispose();
                this.Hide();
                Tutor_Mainpage TMP = new Tutor_Mainpage();
                TMP.ShowDialog();
            }
            else if (count > 1)
            {
                MessageBox.Show("Duplicate Username and Password");
            }
            else
            {
                MessageBox.Show("Wrong UserID or Password or Role");
            }

            connection.Close();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            try
            {
               
                
            }
            catch (Exception ex)
            {
                MessageBox.Show("Error"+ ex);

            }
        }

        private void pictureBox1_Click(object sender, EventArgs e)
        {

        }

        private void label1_Click(object sender, EventArgs e)
        {
            label1.Width = 150;
        }

        private void checkConnection_Click(object sender, EventArgs e)
        {

        }

        private void Login_Load(object sender, EventArgs e)
        {

        }
    }
}
