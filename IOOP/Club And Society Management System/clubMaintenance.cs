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
    public partial class clubMaintenance : Form
    {
        public clubMaintenance()
        {
            InitializeComponent();
            dgvClub.SelectionChanged -= new System.EventHandler(this.dgvClub_SelectionChanged);
            loadSecretaryComboBox();
            
        }

        void loadSecretaryComboBox()
        {
            cboSecretary.Items.Clear();
            cboSecretary.DisplayMember = "name";
            cboSecretary.DataSource = student.GetStudentsProfile();
           
        }

        
        void reloadClubTable()
        {
            dgvClub.ClearSelection();
            dgvClub.Rows.Clear();
            List<club> clubs = new List<club>();

            switch (cboViewMode.SelectedIndex)
            {
                case 0:
                    clubs = club.GetActiveClubs();
                    break;
                case 1:
                    clubs = club.GetArchivedClubs();
                    break;
            }
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
            dgvClub.ClearSelection();
            dgvClub.SelectionChanged += new System.EventHandler(this.dgvClub_SelectionChanged);
        }

        private void btnSave_Click(object sender, EventArgs e)
        {
            int index = dgvClub.CurrentRow.Index;
            if (btnSave.Text != "Create New Club")
            {
                club c = new club((int)dgvClub.Rows[index].Cells[0].Value);
                if (c.update(txtClubName.Text, txtPresident.Text, txtVicePresident.Text, ((student)cboSecretary.SelectedItem).id, rtxDescription.Text,cboStatus.SelectedIndex))
                {
                    MessageBox.Show("Club (" + txtClubName.Text + ") has been successfully saved!");
                    reloadClubTable();
                    disabledControlForManagingClub();
                }
                else
                {
                    disabledControlForManagingClub();
                    MessageBox.Show("Please try again later!");
                }
                return;
            }
            if (club.create(txtClubName.Text, txtPresident.Text, txtVicePresident.Text, ((student)cboSecretary.SelectedItem).id, rtxDescription.Text))
            {
                MessageBox.Show("Club (" + txtClubName.Text + ") has been successfully created!");
                reloadClubTable();
                disabledControlForManagingClub();
            }
            else
            {
                disabledControlForManagingClub();
                MessageBox.Show("Please try again later!");
            }
        }
        private void dgvClub_SelectionChanged(object sender, EventArgs e)
        {
            btnSave.Text = "Save changes";
            int index = dgvClub.CurrentRow.Index;
            if (index != -1 && !(String.IsNullOrEmpty(dgvClub.Rows[index].Cells[0].Value?.ToString())))
            {
                txtClubName.Text = dgvClub.Rows[index].Cells[1].Value?.ToString();
                txtPresident.Text = dgvClub.Rows[index].Cells[3].Value?.ToString();
                txtVicePresident.Text = dgvClub.Rows[index].Cells[4].Value?.ToString();
                cboSecretary.SelectedIndex = cboSecretary.FindStringExact(dgvClub.Rows[index].Cells[5].Value?.ToString());
                cboStatus.SelectedIndex = dgvClub.Rows[index].Cells[2]?.Value.ToString() == "True" ? 1 : 0;
                rtxDescription.Text = club.getDescription((int)dgvClub.Rows[index].Cells[0].Value);
                enabledControlForManagingClub();
                btnViewMore.Enabled = true;
            }
        }

        private void clubMaintenance_Load(object sender, EventArgs e)
        {
            reloadClubTable();
            disabledControlForManagingClub();
            cboViewMode.SelectedIndex = 0;
        }

        private void btnCreate_Click(object sender, EventArgs e)
        {
            dgvClub.ClearSelection();
            txtClubName.Text = "";
            txtPresident.Text = "";
            txtVicePresident.Text = "";
            rtxDescription.Text = "";
            cboStatus.SelectedIndex = -1;
            cboSecretary.SelectedIndex = -1;
            btnSave.Enabled = true;
            enabledControlForManagingClub();
            cboViewMode.SelectedIndex = 0;
            btnSave.Text = "Create New Club";
            btnViewMore.Enabled = false;
        }

        void disabledControlForManagingClub()
        {
            txtClubName.Enabled = false;
            txtPresident.Enabled = false;
            txtVicePresident.Enabled = false;
            rtxDescription.Enabled = false;
            cboSecretary.Enabled = false;
            cboStatus.Enabled = false;
            btnSave.Enabled = false;
            txtClubName.Text = "";
            txtPresident.Text = "";
            txtVicePresident.Text = "";
            rtxDescription.Text = "";
            cboStatus.SelectedIndex = -1;
            cboSecretary.SelectedIndex = -1;
            btnViewMore.Enabled = false;
        }

        void enabledControlForManagingClub()
        {
            txtClubName.Enabled = true;
            txtPresident.Enabled = true;
            txtVicePresident.Enabled = true;
            rtxDescription.Enabled = true;
            cboSecretary.Enabled = true;
            cboStatus.Enabled = true;
            btnSave.Enabled = true;
        }

        private void cboViewMode_SelectedIndexChanged(object sender, EventArgs e)
        {
            reloadClubTable();
            disabledControlForManagingClub();
        }

        private void btnViewMore_Click(object sender, EventArgs e)
        {
            int index = dgvClub.CurrentRow.Index;
            if (index != -1 && !(String.IsNullOrEmpty(dgvClub.Rows[index].Cells[0].Value?.ToString())))
            {
                //clubAchievementMaintenance ca = new clubAchievementMaintenance((int)dgvClub.Rows[index].Cells[0].Value);
                //clubActivityMaintenance ca = new clubActivityMaintenance((int)dgvClub.Rows[index].Cells[0].Value);
                viewClubDetails ca = new viewClubDetails((int)dgvClub.Rows[index].Cells[0].Value);
                ca.Show();
                this.Hide();
            }
        }

        private void clubMaintenance_FormClosing(object sender, FormClosingEventArgs e)
        {
            adminDashboard ad = new adminDashboard();
            ad.Show();
            this.Dispose();
        }
    }
}
