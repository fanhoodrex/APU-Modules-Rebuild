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
    public partial class viewClubDetails : Form
    {
        int clubID,usrid;
        string role;
        public viewClubDetails()
        {
            InitializeComponent();
        }

        public viewClubDetails(int clubID)
        {
            this.clubID = clubID;
            InitializeComponent();
        }

        public viewClubDetails(int clubID,int usrid,string role)
        {
            this.usrid = usrid;
            this.role = role;
            this.clubID = clubID;
            InitializeComponent();
        }

        private void viewClubDetails_Load(object sender, EventArgs e)
        {
            loadMembership();
            loadActivity();
            loadAchievement();
        }

        void loadMembership()
        {
            dgvMembership.Rows.Clear();
            dgvMembership.ClearSelection();
            clubMembership cm = new clubMembership(this.clubID);
            List<clubMembership> memberships = cm.getClubMemberships();
            foreach (var membership in memberships)
            {
                int i = dgvMembership.Rows.Add();
                dgvMembership.Rows[i].Cells["mmbID"].Value = membership.studentid;
                dgvMembership.Rows[i].Cells["mmbName"].Value = student.getFullNameByID(membership.studentid);
            }
            dgvMembership.ClearSelection();
        }

        void loadActivity()
        {
            dgvActivity.Rows.Clear();
            dgvActivity.ClearSelection();
            List<clubActivity> activities = clubActivity.getClubActivities(this.clubID);
            foreach (var activity in activities)
            {
                int i = dgvActivity.Rows.Add();
                dgvActivity.Rows[i].Cells["actDate"].Value = activity.dt;
                dgvActivity.Rows[i].Cells["actActivity"].Value = activity.description;
            }
            dgvActivity.ClearSelection();
        }

        void loadAchievement()
        {
            dgvAchievement.Rows.Clear();
            dgvAchievement.ClearSelection();
            List<clubAchievement> achievements = clubAchievement.getClubAchievements(this.clubID);
            foreach (var achievement in achievements)
            {
                int i = dgvAchievement.Rows.Add();
                dgvAchievement.Rows[i].Cells["achDate"].Value = achievement.dt;
                dgvAchievement.Rows[i].Cells["achAchievement"].Value = achievement.description;
            }
            dgvAchievement.ClearSelection();
        }

        private void btnModifyAchievement_Click(object sender, EventArgs e)
        {
            this.Dispose();
            clubAchievementMaintenance ca = new clubAchievementMaintenance(this.clubID);
            ca.Show();
        }

        private void btnModifyActivity_Click(object sender, EventArgs e)
        {
            this.Dispose();
            clubActivityMaintenance ca = new clubActivityMaintenance(this.clubID);
            ca.Show();
        }

        private void viewClubDetails_FormClosing(object sender, FormClosingEventArgs e)
        {
            if (this.role == "student")
            {
                stdDashboard sd = new stdDashboard(this.usrid);
                sd.Show();
            }
            else
            {
                adminDashboard ad = new adminDashboard();
                ad.Show();
            }            
            this.Dispose();
        }
        
        private void btnModifyMembership_Click(object sender, EventArgs e)
        {
            this.Dispose();
            clubMembershipMaintenance cmm = new clubMembershipMaintenance(this.clubID);
            cmm.Show();
        }
    }
}
