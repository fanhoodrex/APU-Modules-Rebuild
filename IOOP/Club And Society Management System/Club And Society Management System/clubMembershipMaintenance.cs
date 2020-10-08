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
    public partial class clubMembershipMaintenance : Form
    {
        int clubID;
        int usrid;
        public clubMembership cm;
        string role;
        public clubMembershipMaintenance()
        {
            InitializeComponent();
        }

        public clubMembershipMaintenance(int clubID)
        {
            this.clubID = clubID;
            this.cm = new clubMembership(this.clubID);
            InitializeComponent();
        }

        public clubMembershipMaintenance(int clubID,int usrid,string role)
        {
            this.usrid = usrid;
            this.role = role;
            this.clubID = clubID;
            this.cm = new clubMembership(this.clubID);
            InitializeComponent();
        }

        void loadMembershipTable()
        {
            dgvMembership.Rows.Clear();
            dgvMembership.ClearSelection();

            List<clubMembership> memberships = cm.getClubMemberships();
            foreach (var membership in memberships)
            {
                int i = dgvMembership.Rows.Add();
                dgvMembership.Rows[i].Cells["stdID"].Value = membership.studentid;
                dgvMembership.Rows[i].Cells["stdName"].Value = student.getFullNameByID(membership.studentid);
            }
            dgvMembership.ClearSelection();
        }

        void loadStudentProfile()
        {
            cboStudents.DataSource = null;
            cboStudents.DataSource = student.GetStudentsProfileExcludeJoined();
            if (cboStudents.Items.Count == 0)
            {
                btnSave.Enabled = false;
            }
        }

        private void clubMembershipMaintenance_Load(object sender, EventArgs e)
        {
            dgvMembership.ClearSelection();
            loadMembershipTable();
            loadStudentProfile();
            disableController();
        }

        void enableController()
        {
            cboStudents.Enabled = true;
            cboStudents.SelectedIndex = -1;
            btnSave.Enabled = true;
        }

        void disableController()
        {
            cboStudents.Enabled = false;
            btnSave.Enabled = false;
            btnDelete.Enabled = false;
        }
        private void btnSave_Click(object sender, EventArgs e)
        {
            if (cm.enroll(((student)cboStudents.SelectedItem).id))
            {
                MessageBox.Show("The changes has been successfully saved!");
                loadMembershipTable();
                disableController();
            }
            else
            {
                disableController();
                MessageBox.Show("Please try again later!");
            }
        }

        private void btnDelete_Click(object sender, EventArgs e)
        {
            int index = dgvMembership.CurrentRow.Index;
            if (DialogResult.Yes == MessageBox.Show("Do You Want Delete ?", "Confirmation", MessageBoxButtons.YesNo, MessageBoxIcon.Warning))
            {
                if (cm.remove((int)dgvMembership.Rows[index].Cells[0].Value))
                {
                    MessageBox.Show("The changes has been successfully saved!");
                    loadMembershipTable();
                    btnSave.Text = "Save Changes";
                    disableController();
                }
                else
                {
                    disableController();
                    MessageBox.Show("Please try again later!");
                }
            }
        }

        private void btnNewEnrollment_Click(object sender, EventArgs e)
        {
            enableController();
            loadStudentProfile();
            btnDelete.Enabled = false;
            btnSave.Text = "Create New Enrollment";
        }

        private void dgvMembership_SelectionChanged(object sender, EventArgs e)
        {
            cboStudents.Enabled = false;
            int index = dgvMembership.CurrentRow.Index;
            if (index != -1 && !(String.IsNullOrEmpty(dgvMembership.Rows[index].Cells[0].Value?.ToString())))
            {
                btnDelete.Enabled = true;
            }
        }

        private void clubMembershipMaintenance_FormClosing(object sender, FormClosingEventArgs e)
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
