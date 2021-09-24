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
    public partial class clubAchievementMaintenance : Form
    {
        public int clubID,usrid;
        string role;
        clubAchievement ca;
        public clubAchievementMaintenance()
        {
            InitializeComponent();
        }

        public clubAchievementMaintenance(int clubID)
        {
            InitializeComponent();
            this.clubID = clubID;
            this.ca = new clubAchievement(clubID);
        }

        public clubAchievementMaintenance(int clubID,int usrid,string role)
        {
            this.usrid = usrid;
            this.role = role;
            InitializeComponent();
            this.clubID = clubID;
            this.ca = new clubAchievement(clubID);
            this.btnNewAchievement.Visible = false;
            this.Size = new Size(590, 275);
        }

        void loadAchievementTable()
        {
            dgvAchievement.Rows.Clear();
            dgvAchievement.ClearSelection();
            List<clubAchievement> achievements = clubAchievement.getClubAchievements(this.clubID);
            foreach(var achievement in achievements)
            {
                int i = dgvAchievement.Rows.Add();
                dgvAchievement.Rows[i].Cells["id"].Value = achievement.id;
                dgvAchievement.Rows[i].Cells["achDate"].Value = achievement.dt;
                dgvAchievement.Rows[i].Cells["achAchievement"].Value = achievement.description;
            }
            dgvAchievement.ClearSelection();
        }

        void enableController()
        {
            txtAchievement.Enabled = true;
            dtpDate.Enabled = true;
            btnSave.Enabled = true;
        }

        void disableController()
        {
            txtAchievement.Text = "";
            dtpDate.Value = System.DateTime.Now;
            txtAchievement.Enabled = false;
            dtpDate.Enabled = false;
            btnSave.Enabled = false;
            btnDelete.Enabled = false;
        }
        private void clubAchievementMaintenance_Load(object sender, EventArgs e)
        {
            loadAchievementTable();
            disableController();
            dgvAchievement.ClearSelection();
            btnDelete.Enabled = false;

        }

        private void btnDelete_Click(object sender, EventArgs e)
        {
            int index = dgvAchievement.CurrentRow.Index;
            if (index != -1)
            {
                if (DialogResult.Yes == MessageBox.Show("Do You Want Delete ?", "Confirmation", MessageBoxButtons.YesNo, MessageBoxIcon.Warning))
                {
                    if (clubAchievement.delete((int)dgvAchievement.Rows[index].Cells[0].Value))
                    {
                        loadAchievementTable();
                        disableController();
                    }
                }
            }
        }

        private void btnSave_Click(object sender, EventArgs e)
        {
            if (btnSave.Text != "Create New Achievement")
            {
                int index = dgvAchievement.CurrentRow.Index;
                if (clubAchievement.update((int)dgvAchievement.Rows[index].Cells[0].Value,txtAchievement.Text, dtpDate.Value.ToString("dd/MM/yyyy")))
                {
                    MessageBox.Show("The changes has been successfully saved!");
                    loadAchievementTable();
                    disableController();
                }
                else
                {
                    disableController();
                    MessageBox.Show("Please try again later!");
                }
                return;
            }
            if (ca.create(txtAchievement.Text, dtpDate.Value.ToString("dd/MM/yyyy")))
            {
                MessageBox.Show("The changes has been successfully saved!");
                loadAchievementTable();
                disableController();
            }
            else
            {
                disableController();
                MessageBox.Show("Please try again later!");
            }
        }

        private void dgvAchievement_SelectionChanged(object sender, EventArgs e)
        {
            btnSave.Text = "Save changes";
            int index = dgvAchievement.CurrentRow.Index;
            if (index != -1 && !(String.IsNullOrEmpty(dgvAchievement.Rows[index].Cells[0].Value?.ToString())))
            {
                txtAchievement.Text = dgvAchievement.Rows[index].Cells[2].Value?.ToString();
                DateTime dt = DateTime.ParseExact(dgvAchievement.Rows[index].Cells[1].Value?.ToString(), "dd/MM/yyyy", null); 
                dtpDate.Value = dt;
                enableController();
                btnDelete.Enabled = true;
            }
        }

        private void btnNewAchievement_Click(object sender, EventArgs e)
        {
            dgvAchievement.ClearSelection();
            enableController();
            btnSave.Text = "Create New Achievement";
            btnDelete.Enabled = false;
            txtAchievement.Text = "";
            dtpDate.Text = System.DateTime.Now.ToString("dd/MM/yyyy");
        }

        private void clubAchievementMaintenance_FormClosing(object sender, FormClosingEventArgs e)
        {
            if (this.role == "student")
            {
                stdDashboard sd = new stdDashboard(this.usrid);
                sd.Show();
                this.Hide();
            }
            else
            {
                viewClubDetails ad = new viewClubDetails(this.clubID, this.usrid, "admin");
                ad.Show();
                this.Hide();
            }
        }
    }
}
