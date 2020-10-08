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
    public partial class Authentication : Form
    {
        public Authentication()
        {
            InitializeComponent();
        }

        private void btnLogin_Click(object sender, EventArgs e)
        {
            if (txtUserID.Text.Length == 0 || txtPassword.Text.Length == 0)
            {
                MessageBox.Show("Empty entries is not allowed!");
                return;
            }
            int id = 0;
            if (!int.TryParse(txtUserID.Text, out id)) {
                MessageBox.Show("Please re-enter your user id!");
                return;
            }
            if (cboUserRole.SelectedItem.ToString() == "Admin")
            {
                if (admin.auth(id, txtPassword.Text))
                {
                    adminDashboard ad = new adminDashboard();
                    ad.Show();
                    this.Hide();
                }
                else
                {
                    MessageBox.Show("Invalid credentials!");
                }
            }
            else
            {
                if (student.auth(id, txtPassword.Text))
                {
                    stdDashboard sd = new stdDashboard(id);
                    sd.Show();
                    this.Hide();
                }
                else
                {
                    MessageBox.Show("Invalid credentials!");
                }
            }
            
        }

        private void Authentication_Load(object sender, EventArgs e)
        {
            cboUserRole.SelectedIndex = 0;
        }

        private void Authentication_FormClosing(object sender, FormClosingEventArgs e)
        {
            this.Dispose();
        }
    }
}
