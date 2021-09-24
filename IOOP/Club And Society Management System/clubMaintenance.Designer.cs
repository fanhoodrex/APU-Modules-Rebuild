namespace Club_And_Society_Management_System
{
    partial class clubMaintenance
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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(clubMaintenance));
            this.dgvClub = new System.Windows.Forms.DataGridView();
            this.id = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.name = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.status = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.president = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.vicePresident = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.Secretary = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.dtCreated = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.txtClubName = new System.Windows.Forms.TextBox();
            this.label1 = new System.Windows.Forms.Label();
            this.btnCreate = new System.Windows.Forms.Button();
            this.btnViewMore = new System.Windows.Forms.Button();
            this.btnSave = new System.Windows.Forms.Button();
            this.label2 = new System.Windows.Forms.Label();
            this.txtPresident = new System.Windows.Forms.TextBox();
            this.label3 = new System.Windows.Forms.Label();
            this.txtVicePresident = new System.Windows.Forms.TextBox();
            this.label4 = new System.Windows.Forms.Label();
            this.rtxDescription = new System.Windows.Forms.RichTextBox();
            this.label5 = new System.Windows.Forms.Label();
            this.label6 = new System.Windows.Forms.Label();
            this.cboStatus = new System.Windows.Forms.ComboBox();
            this.cboSecretary = new System.Windows.Forms.ComboBox();
            this.cboViewMode = new System.Windows.Forms.ComboBox();
            this.label7 = new System.Windows.Forms.Label();
            ((System.ComponentModel.ISupportInitialize)(this.dgvClub)).BeginInit();
            this.SuspendLayout();
            // 
            // dgvClub
            // 
            this.dgvClub.AllowUserToAddRows = false;
            this.dgvClub.AllowUserToDeleteRows = false;
            this.dgvClub.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dgvClub.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.id,
            this.name,
            this.status,
            this.president,
            this.vicePresident,
            this.Secretary,
            this.dtCreated});
            this.dgvClub.Location = new System.Drawing.Point(12, 35);
            this.dgvClub.MultiSelect = false;
            this.dgvClub.Name = "dgvClub";
            this.dgvClub.SelectionMode = System.Windows.Forms.DataGridViewSelectionMode.FullRowSelect;
            this.dgvClub.Size = new System.Drawing.Size(743, 291);
            this.dgvClub.TabIndex = 0;
            this.dgvClub.SelectionChanged += new System.EventHandler(this.dgvClub_SelectionChanged);
            // 
            // id
            // 
            this.id.HeaderText = "ID";
            this.id.Name = "id";
            this.id.ReadOnly = true;
            this.id.Width = 50;
            // 
            // name
            // 
            this.name.HeaderText = "Name";
            this.name.Name = "name";
            this.name.ReadOnly = true;
            // 
            // status
            // 
            this.status.HeaderText = "Status";
            this.status.Name = "status";
            this.status.ReadOnly = true;
            // 
            // president
            // 
            this.president.HeaderText = "President";
            this.president.Name = "president";
            this.president.ReadOnly = true;
            // 
            // vicePresident
            // 
            this.vicePresident.HeaderText = "Vice President";
            this.vicePresident.Name = "vicePresident";
            this.vicePresident.ReadOnly = true;
            // 
            // Secretary
            // 
            this.Secretary.HeaderText = "Secretary";
            this.Secretary.Name = "Secretary";
            this.Secretary.ReadOnly = true;
            // 
            // dtCreated
            // 
            this.dtCreated.HeaderText = "Established Date";
            this.dtCreated.Name = "dtCreated";
            this.dtCreated.ReadOnly = true;
            this.dtCreated.Width = 140;
            // 
            // txtClubName
            // 
            this.txtClubName.Location = new System.Drawing.Point(93, 335);
            this.txtClubName.Name = "txtClubName";
            this.txtClubName.Size = new System.Drawing.Size(114, 20);
            this.txtClubName.TabIndex = 1;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(25, 337);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(62, 13);
            this.label1.TabIndex = 2;
            this.label1.Text = "Club Name:";
            // 
            // btnCreate
            // 
            this.btnCreate.Location = new System.Drawing.Point(680, 6);
            this.btnCreate.Name = "btnCreate";
            this.btnCreate.Size = new System.Drawing.Size(75, 23);
            this.btnCreate.TabIndex = 4;
            this.btnCreate.Text = "New Club";
            this.btnCreate.UseVisualStyleBackColor = true;
            this.btnCreate.Click += new System.EventHandler(this.btnCreate_Click);
            // 
            // btnViewMore
            // 
            this.btnViewMore.Location = new System.Drawing.Point(680, 332);
            this.btnViewMore.Name = "btnViewMore";
            this.btnViewMore.Size = new System.Drawing.Size(75, 23);
            this.btnViewMore.TabIndex = 5;
            this.btnViewMore.Text = "View More";
            this.btnViewMore.UseVisualStyleBackColor = true;
            this.btnViewMore.Click += new System.EventHandler(this.btnViewMore_Click);
            // 
            // btnSave
            // 
            this.btnSave.Location = new System.Drawing.Point(380, 509);
            this.btnSave.Name = "btnSave";
            this.btnSave.Size = new System.Drawing.Size(102, 23);
            this.btnSave.TabIndex = 6;
            this.btnSave.Text = "Save Changes";
            this.btnSave.UseVisualStyleBackColor = true;
            this.btnSave.Click += new System.EventHandler(this.btnSave_Click);
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(253, 335);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(54, 13);
            this.label2.TabIndex = 8;
            this.label2.Text = "President:";
            // 
            // txtPresident
            // 
            this.txtPresident.Location = new System.Drawing.Point(321, 332);
            this.txtPresident.Name = "txtPresident";
            this.txtPresident.Size = new System.Drawing.Size(161, 20);
            this.txtPresident.TabIndex = 7;
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(12, 367);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(75, 13);
            this.label3.TabIndex = 10;
            this.label3.Text = "Vice President";
            // 
            // txtVicePresident
            // 
            this.txtVicePresident.Location = new System.Drawing.Point(93, 364);
            this.txtVicePresident.Name = "txtVicePresident";
            this.txtVicePresident.Size = new System.Drawing.Size(148, 20);
            this.txtVicePresident.TabIndex = 9;
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(253, 366);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(55, 13);
            this.label4.TabIndex = 12;
            this.label4.Text = "Secretary:";
            // 
            // rtxDescription
            // 
            this.rtxDescription.Location = new System.Drawing.Point(93, 422);
            this.rtxDescription.Name = "rtxDescription";
            this.rtxDescription.Size = new System.Drawing.Size(389, 67);
            this.rtxDescription.TabIndex = 13;
            this.rtxDescription.Text = "";
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Location = new System.Drawing.Point(12, 425);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(60, 13);
            this.label5.TabIndex = 14;
            this.label5.Text = "Description";
            // 
            // label6
            // 
            this.label6.AutoSize = true;
            this.label6.Location = new System.Drawing.Point(12, 394);
            this.label6.Name = "label6";
            this.label6.Size = new System.Drawing.Size(37, 13);
            this.label6.TabIndex = 15;
            this.label6.Text = "Status";
            // 
            // cboStatus
            // 
            this.cboStatus.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
            this.cboStatus.FormattingEnabled = true;
            this.cboStatus.Items.AddRange(new object[] {
            "Inactive",
            "Active"});
            this.cboStatus.Location = new System.Drawing.Point(93, 391);
            this.cboStatus.Name = "cboStatus";
            this.cboStatus.Size = new System.Drawing.Size(105, 21);
            this.cboStatus.TabIndex = 16;
            // 
            // cboSecretary
            // 
            this.cboSecretary.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
            this.cboSecretary.FormattingEnabled = true;
            this.cboSecretary.Location = new System.Drawing.Point(321, 364);
            this.cboSecretary.Name = "cboSecretary";
            this.cboSecretary.Size = new System.Drawing.Size(161, 21);
            this.cboSecretary.TabIndex = 17;
            // 
            // cboViewMode
            // 
            this.cboViewMode.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
            this.cboViewMode.FormattingEnabled = true;
            this.cboViewMode.Items.AddRange(new object[] {
            "Active",
            "Archived"});
            this.cboViewMode.Location = new System.Drawing.Point(102, 6);
            this.cboViewMode.Name = "cboViewMode";
            this.cboViewMode.Size = new System.Drawing.Size(105, 21);
            this.cboViewMode.TabIndex = 18;
            this.cboViewMode.SelectedIndexChanged += new System.EventHandler(this.cboViewMode_SelectedIndexChanged);
            // 
            // label7
            // 
            this.label7.AutoSize = true;
            this.label7.Location = new System.Drawing.Point(25, 9);
            this.label7.Name = "label7";
            this.label7.Size = new System.Drawing.Size(62, 13);
            this.label7.TabIndex = 19;
            this.label7.Text = "View mode:";
            // 
            // clubMaintenance
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(763, 537);
            this.Controls.Add(this.label7);
            this.Controls.Add(this.cboViewMode);
            this.Controls.Add(this.cboSecretary);
            this.Controls.Add(this.cboStatus);
            this.Controls.Add(this.label6);
            this.Controls.Add(this.label5);
            this.Controls.Add(this.rtxDescription);
            this.Controls.Add(this.label4);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.txtVicePresident);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.txtPresident);
            this.Controls.Add(this.btnSave);
            this.Controls.Add(this.btnViewMore);
            this.Controls.Add(this.btnCreate);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.txtClubName);
            this.Controls.Add(this.dgvClub);
            this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
            this.MaximizeBox = false;
            this.MinimizeBox = false;
            this.Name = "clubMaintenance";
            this.Text = "Club Maintenance";
            this.FormClosing += new System.Windows.Forms.FormClosingEventHandler(this.clubMaintenance_FormClosing);
            this.Load += new System.EventHandler(this.clubMaintenance_Load);
            ((System.ComponentModel.ISupportInitialize)(this.dgvClub)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.DataGridView dgvClub;
        private System.Windows.Forms.TextBox txtClubName;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Button btnCreate;
        private System.Windows.Forms.Button btnViewMore;
        private System.Windows.Forms.Button btnSave;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.TextBox txtPresident;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.TextBox txtVicePresident;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.RichTextBox rtxDescription;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.Label label6;
        private System.Windows.Forms.ComboBox cboStatus;
        private System.Windows.Forms.ComboBox cboSecretary;
        private System.Windows.Forms.ComboBox cboViewMode;
        private System.Windows.Forms.Label label7;
        private System.Windows.Forms.DataGridViewTextBoxColumn id;
        private System.Windows.Forms.DataGridViewTextBoxColumn name;
        private System.Windows.Forms.DataGridViewTextBoxColumn status;
        private System.Windows.Forms.DataGridViewTextBoxColumn president;
        private System.Windows.Forms.DataGridViewTextBoxColumn vicePresident;
        private System.Windows.Forms.DataGridViewTextBoxColumn Secretary;
        private System.Windows.Forms.DataGridViewTextBoxColumn dtCreated;
    }
}