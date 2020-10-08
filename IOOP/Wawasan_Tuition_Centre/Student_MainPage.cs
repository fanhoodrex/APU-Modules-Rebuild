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
    public partial class Student_MainPage : Form
    {
        public Student_MainPage()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            this.Hide();
            Class_Schedule f5 = new Class_Schedule();
            f5.ShowDialog();

        }

        private void Student_MainPage_Load(object sender, EventArgs e)
        {
            
        }

        private void dataGridView1_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {

        }

        private void button2_Click(object sender, EventArgs e)
        {
            this.Hide();
            Student_UpdateAndEditProfile SUP = new Student_UpdateAndEditProfile();
            SUP.ShowDialog();
        }

        private void button3_Click(object sender, EventArgs e)
        {

            this.Hide();
            Student_Check_Payment SCP = new Student_Check_Payment();
            SCP.ShowDialog();
        }

        private void button5_Click(object sender, EventArgs e)
        {

            this.Hide();
            Student_ResetPassword SRP = new Student_ResetPassword();
            SRP.ShowDialog();
        }

        private void button4_Click(object sender, EventArgs e)
        {
            this.Hide();
            Login L = new Login();
            L.ShowDialog();
        }
    }
}
