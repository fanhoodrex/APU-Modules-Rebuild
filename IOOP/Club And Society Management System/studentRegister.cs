using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Club_And_Society_Management_System
{
    public partial class studentRegister : Form
    {
        public studentRegister()
        {
            InitializeComponent();
        }

        private void btnRegister_Click(object sender, EventArgs e)
        {
            if (txtFullName.Text.Length == 0 || txtPassword.Text.Length == 0)
            {
                MessageBox.Show("Emptry entries is not allowed!");
                return;
            }
            MessageBox.Show(student.create(txtFullName.Text, txtPassword.Text) ? "Your account has been successfully created!" : "Please try again later!");
            txtFullName.Text = "";
            txtPassword.Text = "";
        }

        private void studentRegister_FormClosing(object sender, FormClosingEventArgs e)
        {
            adminDashboard ad = new adminDashboard();
            ad.Show();
            this.Dispose();
        }
    }
}
