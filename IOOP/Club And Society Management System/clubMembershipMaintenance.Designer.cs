namespace Club_And_Society_Management_System
{
    partial class clubMembershipMaintenance
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(clubMembershipMaintenance));
            this.dgvMembership = new System.Windows.Forms.DataGridView();
            this.stdID = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.stdName = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.btnDelete = new System.Windows.Forms.Button();
            this.btnNewEnrollment = new System.Windows.Forms.Button();
            this.btnSave = new System.Windows.Forms.Button();
            this.label1 = new System.Windows.Forms.Label();
            this.cboStudents = new System.Windows.Forms.ComboBox();
            ((System.ComponentModel.ISupportInitialize)(this.dgvMembership)).BeginInit();
            this.SuspendLayout();
            // 
            // dgvMembership
            // 
            this.dgvMembership.AllowUserToAddRows = false;
            this.dgvMembership.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dgvMembership.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.stdID,
            this.stdName});
            this.dgvMembership.Location = new System.Drawing.Point(12, 38);
            this.dgvMembership.Name = "dgvMembership";
            this.dgvMembership.SelectionMode = System.Windows.Forms.DataGridViewSelectionMode.FullRowSelect;
            this.dgvMembership.Size = new System.Drawing.Size(547, 192);
            this.dgvMembership.TabIndex = 11;
            this.dgvMembership.SelectionChanged += new System.EventHandler(this.dgvMembership_SelectionChanged);
            // 
            // stdID
            // 
            this.stdID.HeaderText = "Student ID";
            this.stdID.Name = "stdID";
            this.stdID.ReadOnly = true;
            // 
            // stdName
            // 
            this.stdName.HeaderText = "Student Name";
            this.stdName.Name = "stdName";
            this.stdName.ReadOnly = true;
            this.stdName.Width = 400;
            // 
            // btnDelete
            // 
            this.btnDelete.Location = new System.Drawing.Point(484, 239);
            this.btnDelete.Name = "btnDelete";
            this.btnDelete.Size = new System.Drawing.Size(75, 23);
            this.btnDelete.TabIndex = 18;
            this.btnDelete.Text = "Delete";
            this.btnDelete.UseVisualStyleBackColor = true;
            this.btnDelete.Click += new System.EventHandler(this.btnDelete_Click);
            // 
            // btnNewEnrollment
            // 
            this.btnNewEnrollment.Location = new System.Drawing.Point(454, 9);
            this.btnNewEnrollment.Name = "btnNewEnrollment";
            this.btnNewEnrollment.Size = new System.Drawing.Size(105, 23);
            this.btnNewEnrollment.TabIndex = 17;
            this.btnNewEnrollment.Text = "New Enrollment";
            this.btnNewEnrollment.UseVisualStyleBackColor = true;
            this.btnNewEnrollment.Click += new System.EventHandler(this.btnNewEnrollment_Click);
            // 
            // btnSave
            // 
            this.btnSave.Location = new System.Drawing.Point(264, 239);
            this.btnSave.Name = "btnSave";
            this.btnSave.Size = new System.Drawing.Size(156, 23);
            this.btnSave.TabIndex = 16;
            this.btnSave.Text = "Save changes";
            this.btnSave.UseVisualStyleBackColor = true;
            this.btnSave.Click += new System.EventHandler(this.btnSave_Click);
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(13, 244);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(79, 13);
            this.label1.TabIndex = 12;
            this.label1.Text = "Student Profile:";
            // 
            // cboStudents
            // 
            this.cboStudents.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
            this.cboStudents.FormattingEnabled = true;
            this.cboStudents.Location = new System.Drawing.Point(94, 241);
            this.cboStudents.Name = "cboStudents";
            this.cboStudents.Size = new System.Drawing.Size(154, 21);
            this.cboStudents.TabIndex = 19;
            // 
            // clubMembershipMaintenance
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(569, 271);
            this.Controls.Add(this.cboStudents);
            this.Controls.Add(this.dgvMembership);
            this.Controls.Add(this.btnDelete);
            this.Controls.Add(this.btnNewEnrollment);
            this.Controls.Add(this.btnSave);
            this.Controls.Add(this.label1);
            this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
            this.MaximizeBox = false;
            this.MinimizeBox = false;
            this.Name = "clubMembershipMaintenance";
            this.Text = "Club Membership Maintenace";
            this.FormClosing += new System.Windows.Forms.FormClosingEventHandler(this.clubMembershipMaintenance_FormClosing);
            this.Load += new System.EventHandler(this.clubMembershipMaintenance_Load);
            ((System.ComponentModel.ISupportInitialize)(this.dgvMembership)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.DataGridView dgvMembership;
        private System.Windows.Forms.Button btnDelete;
        private System.Windows.Forms.Button btnNewEnrollment;
        private System.Windows.Forms.Button btnSave;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.ComboBox cboStudents;
        private System.Windows.Forms.DataGridViewTextBoxColumn stdID;
        private System.Windows.Forms.DataGridViewTextBoxColumn stdName;
    }
}