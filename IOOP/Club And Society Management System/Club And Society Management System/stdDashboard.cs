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
    public partial class stdDashboard : Form
    {
        int usrid;
        public stdDashboard()
        {
            InitializeComponent();
        }
        public stdDashboard(int usrid)
        {
            this.usrid = usrid;
            InitializeComponent();
        }

        private void pbxClub_Click(object sender, EventArgs e)
        {
            if (clubMembership.checkIsSecretary(this.usrid))
            {
                viewClubDetails vcd = new viewClubDetails(clubMembership.getClubID(this.usrid), this.usrid,"student");
                vcd.Show();
                this.Dispose();
            }
            else
            {
                viewClub vc = new viewClub(this.usrid);
                vc.Show();
                this.Dispose();
            }
            
        }

        private void pbxAchievement_Click(object sender, EventArgs e)
        {
            if (clubMembership.validateJoined(this.usrid))
            {
                clubAchievementMaintenance cam = new clubAchievementMaintenance(clubMembership.getClubID(this.usrid), this.usrid, "student");
                cam.Show();
                this.Dispose();
            }
            else
            {
                MessageBox.Show("Please join a club first!");
            }
        }

        private void pbxActivity_Click(object sender, EventArgs e)
        {
            if (clubMembership.validateJoined(this.usrid)) {
                clubActivityMaintenance cam = new clubActivityMaintenance(clubMembership.getClubID(this.usrid), this.usrid, "student");
                cam.Show();
                this.Dispose();
            }
            else
            {
                MessageBox.Show("Please join a club first!");
            }
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

        private void stdDashboard_Load(object sender, EventArgs e)
        {
            
        }

        private void stdDashboard_FormClosing(object sender, FormClosingEventArgs e)
        {
            Authentication auth = new Authentication();
            auth.Show();
            this.Dispose();
        }
    }
}
