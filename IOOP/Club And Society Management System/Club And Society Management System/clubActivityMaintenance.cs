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
    public partial class clubActivityMaintenance : Form
    {
        public int clubID,usrid;
        string role;
        clubActivity ca;
        public clubActivityMaintenance()
        {
            InitializeComponent();
        }

        public clubActivityMaintenance(int clubID)
        {
            InitializeComponent();
            this.clubID = clubID;
            this.ca = new clubActivity(clubID);
        }

        public clubActivityMaintenance(int clubID,int usrid,string role)
        {
            this.usrid = usrid;
            this.role = role;
            InitializeComponent();
            this.clubID = clubID;
            this.btnNewActivity.Visible = false;
            this.ca = new clubActivity(clubID);
            this.Size = new Size(590, 275);
        }

        void loadActivityTable()
        {
            dgvActivity.Rows.Clear();
            dgvActivity.ClearSelection();
            List<clubActivity> activities = clubActivity.getClubActivities(this.clubID);
            foreach (var activity in activities)
            {
                int i = dgvActivity.Rows.Add();
                dgvActivity.Rows[i].Cells["id"].Value = activity.id;
                dgvActivity.Rows[i].Cells["actDate"].Value = activity.dt;
                dgvActivity.Rows[i].Cells["actActivity"].Value = activity.description;
            }
            dgvActivity.ClearSelection();
        }

        void enableController()
        {
            txtActivity.Enabled = true;
            dtpDate.Enabled = true;
            btnSave.Enabled = true;
        }

        void disableController()
        {
            txtActivity.Text = "";
            dtpDate.Value = System.DateTime.Now;
            txtActivity.Enabled = false;
            dtpDate.Enabled = false;
            btnSave.Enabled = false;
            btnDelete.Enabled = false;
        }
        private void clubActivityMaintenance_Load(object sender, EventArgs e)
        {
            loadActivityTable();
            disableController();
            dgvActivity.ClearSelection();
            btnDelete.Enabled = false;
        }

        private void btnDelete_Click(object sender, EventArgs e)
        {
            int index = dgvActivity.CurrentRow.Index;
            if (index != -1)
            {
                if (DialogResult.Yes == MessageBox.Show("Do You Want Delete ?", "Confirmation", MessageBoxButtons.YesNo, MessageBoxIcon.Warning))
                {
                    if (clubActivity.delete((int)dgvActivity.Rows[index].Cells[0].Value))
                    {
                        loadActivityTable();
                        disableController();
                    }
                }
            }
        }

        private void btnSave_Click(object sender, EventArgs e)
        {
            if (btnSave.Text != "Create New Activity")
            {
                int index = dgvActivity.CurrentRow.Index;
                if (clubActivity.update((int)dgvActivity.Rows[index].Cells[0].Value, txtActivity.Text, dtpDate.Value.ToString("dd/MM/yyyy")))
                {
                    MessageBox.Show("The changes has been successfully saved!");
                    loadActivityTable();
                    disableController();
                }
                else
                {
                    disableController();
                    MessageBox.Show("Please try again later!");
                }
                return;
            }
            if (ca.create(txtActivity.Text, dtpDate.Value.ToString("dd/MM/yyyy")))
            {
                MessageBox.Show("The changes has been successfully saved!");
                loadActivityTable();
                disableController();
            }
            else
            {
                disableController();
                MessageBox.Show("Please try again later!");
            }
        }

        private void dgvActivity_SelectionChanged(object sender, EventArgs e)
        {
            btnSave.Text = "Save changes";
            int index = dgvActivity.CurrentRow.Index;
            if (index != -1 && !(String.IsNullOrEmpty(dgvActivity.Rows[index].Cells[0].Value?.ToString())))
            {
                txtActivity.Text = dgvActivity.Rows[index].Cells[2].Value?.ToString();
                DateTime dt = DateTime.ParseExact(dgvActivity.Rows[index].Cells[1].Value?.ToString(), "dd/MM/yyyy", null);
                dtpDate.Value = dt;
                enableController();
                btnDelete.Enabled = true;
            }
        }

        private void btnNewActivity_Click(object sender, EventArgs e)
        {
            dgvActivity.ClearSelection();
            enableController();
            btnSave.Text = "Create New Activity";
            btnDelete.Enabled = false;
            txtActivity.Text = "";
            dtpDate.Text = System.DateTime.Now.ToString("dd/MM/yyyy");
        }

        private void clubActivityMaintenance_FormClosing(object sender, FormClosingEventArgs e)
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
