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
    public partial class adminDashboard : Form
    {
        public adminDashboard()
        {
            InitializeComponent();
        }

        private void pbxLogout_Click(object sender, EventArgs e)
        {
            if (DialogResult.Yes == MessageBox.Show("Do You Want Logout ?", "Confirmation", MessageBoxButtons.YesNo, MessageBoxIcon.Warning))
            {
                Authentication auth = new Authentication();
                auth.Show();
                this.Dispose();
            }
        }

        private void pbxAccount_Click(object sender, EventArgs e)
        {
            studentRegister sr = new studentRegister();
            sr.Show();
            this.Dispose();
        }

        private void pbxClub_Click(object sender, EventArgs e)
        {
            clubMaintenance cm = new clubMaintenance();
            cm.Show();
            this.Dispose();
        }

        private void adminDashboard_FormClosing(object sender, FormClosingEventArgs e)
        {
            Authentication auth = new Authentication();
            auth.Show();
            this.Dispose();
        }
    }
}
