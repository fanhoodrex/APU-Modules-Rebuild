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
    public partial class viewClub : Form
    {
        int usrID;
        public viewClub()
        {
            InitializeComponent();
        }

        public viewClub(int usrID)
        {
            this.usrID = usrID;
            InitializeComponent();
        }

        private void btnJoin_Click(object sender, EventArgs e)
        {
            if (clubMembership.validateJoined(this.usrID))
            {
                MessageBox.Show("Please unjoin your current club first!");
            }
            else
            {
                int index = dgvClub.CurrentRow.Index;
                clubMembership cm = new clubMembership(int.Parse(dgvClub.Rows[index].Cells[0].Value?.ToString()));
                if (cm.enroll(this.usrID))
                {
                    checkJoinStatus();
                    btnUnjoin.Enabled = true;
                    MessageBox.Show("You have successfully joined the club!");
                }
                else
                {
                    MessageBox.Show("Please try again later!");
                }
            }
        }

        private void btnUnjoin_Click(object sender, EventArgs e)
        {
            
            MessageBox.Show(clubMembership.unjoinAll(this.usrID) ? "Unjoin your current club successfully!" : "Please try again later!");
            checkJoinStatus();
        }

        private void dgvClub_SelectionChanged(object sender, EventArgs e)
        {
            int index = dgvClub.CurrentRow.Index;
            if (index != -1 && !(String.IsNullOrEmpty(dgvClub.Rows[index].Cells[0].Value?.ToString())))
            {
                btnJoin.Enabled = true;
                loadActivity(int.Parse(dgvClub.Rows[index].Cells[0].Value.ToString()));
                loadAchievement(int.Parse(dgvClub.Rows[index].Cells[0].Value.ToString()));
            }
        }
        private void viewClub_FormClosing(object sender, FormClosingEventArgs e)
        {
            stdDashboard sd = new stdDashboard(this.usrID);
            sd.Show();
            this.Dispose();
        }
        void checkJoinStatus()
        {
            if (!clubMembership.validateJoined(this.usrID))
            {
                btnUnjoin.Enabled = false;
                lblDisplay.Text = "Current Club: null";
            }
            else
            {
                lblDisplay.Text = "Current Club: " + club.getClubName(clubMembership.getClubID(this.usrID));
            }
        }
        private void viewClub_Load(object sender, EventArgs e)
        {
            reloadClubTable();
            //btnJoin.Enabled = false;
            checkJoinStatus();
            if (dgvClub.Rows.Count == 0)
            {
                dgvClub.ClearSelection();
            }
            else
            {
                int index = dgvClub.CurrentRow.Index;
                loadActivity(int.Parse(dgvClub.Rows[index].Cells[0].Value.ToString()));
                loadAchievement(int.Parse(dgvClub.Rows[index].Cells[0].Value.ToString()));
            }
        }

        void reloadClubTable()
        {
            dgvClub.ClearSelection();
            dgvClub.Rows.Clear();
            List<club> clubs = club.GetActiveClubs();
            
            foreach (var clubInfo in clubs)
            {
                int i = dgvClub.Rows.Add();
                dgvClub.Rows[i].Cells["id"].Value = clubInfo.id;
                dgvClub.Rows[i].Cells["name"].Value = clubInfo.name;
                dgvClub.Rows[i].Cells["president"].Value = clubInfo.president;
                dgvClub.Rows[i].Cells["vicePresident"].Value = clubInfo.vicePresident;
                dgvClub.Rows[i].Cells["secretary"].Value = student.getFullNameByID(clubInfo.secretaryID);
                dgvClub.Rows[i].Cells["status"].Value = clubInfo.isActive == 1 ? true : false;
                dgvClub.Rows[i].Cells["dtCreated"].Value = clubInfo.dtCreated;
            }
            dgvClub.SelectionChanged += new System.EventHandler(this.dgvClub_SelectionChanged);
        }

        void loadActivity(int clubID)
        {
            dgvActivity.Rows.Clear();
            dgvActivity.ClearSelection();
            List<clubActivity> activities = clubActivity.getClubActivities(clubID);
            foreach (var activity in activities)
            {
                int i = dgvActivity.Rows.Add();
                dgvActivity.Rows[i].Cells["actDate"].Value = activity.dt;
                dgvActivity.Rows[i].Cells["actActivity"].Value = activity.description;
            }
            dgvActivity.ClearSelection();
        }

        void loadAchievement(int clubID)
        {
            dgvAchievement.Rows.Clear();
            dgvAchievement.ClearSelection();
            List<clubAchievement> achievements = clubAchievement.getClubAchievements(clubID);
            foreach (var achievement in achievements)
            {
                int i = dgvAchievement.Rows.Add();
                dgvAchievement.Rows[i].Cells["achDate"].Value = achievement.dt;
                dgvAchievement.Rows[i].Cells["achAchievement"].Value = achievement.description;
            }
            dgvAchievement.ClearSelection();
        }
    }
}
