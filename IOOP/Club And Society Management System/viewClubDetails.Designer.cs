namespace Club_And_Society_Management_System
{
    partial class viewClubDetails
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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(viewClubDetails));
            this.dgvMembership = new System.Windows.Forms.DataGridView();
            this.mmbID = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.mmbName = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.dgvActivity = new System.Windows.Forms.DataGridView();
            this.actDate = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.actActivity = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.dgvAchievement = new System.Windows.Forms.DataGridView();
            this.achDate = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.achAchievement = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.label1 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.btnModifyAchievement = new System.Windows.Forms.Button();
            this.btnModifyActivity = new System.Windows.Forms.Button();
            this.btnModifyMembership = new System.Windows.Forms.Button();
            ((System.ComponentModel.ISupportInitialize)(this.dgvMembership)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.dgvActivity)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.dgvAchievement)).BeginInit();
            this.SuspendLayout();
            // 
            // dgvMembership
            // 
            this.dgvMembership.AllowUserToAddRows = false;
            this.dgvMembership.AllowUserToDeleteRows = false;
            this.dgvMembership.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dgvMembership.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.mmbID,
            this.mmbName});
            this.dgvMembership.Location = new System.Drawing.Point(28, 522);
            this.dgvMembership.Name = "dgvMembership";
            this.dgvMembership.Size = new System.Drawing.Size(547, 223);
            this.dgvMembership.TabIndex = 0;
            // 
            // mmbID
            // 
            this.mmbID.HeaderText = "member ID";
            this.mmbID.Name = "mmbID";
            this.mmbID.ReadOnly = true;
            // 
            // mmbName
            // 
            this.mmbName.HeaderText = "Member Name";
            this.mmbName.Name = "mmbName";
            this.mmbName.ReadOnly = true;
            this.mmbName.Width = 400;
            // 
            // dgvActivity
            // 
            this.dgvActivity.AllowUserToAddRows = false;
            this.dgvActivity.AllowUserToDeleteRows = false;
            this.dgvActivity.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dgvActivity.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.actDate,
            this.actActivity});
            this.dgvActivity.Location = new System.Drawing.Point(28, 281);
            this.dgvActivity.Name = "dgvActivity";
            this.dgvActivity.Size = new System.Drawing.Size(547, 192);
            this.dgvActivity.TabIndex = 1;
            // 
            // actDate
            // 
            this.actDate.HeaderText = "Date";
            this.actDate.Name = "actDate";
            this.actDate.ReadOnly = true;
            // 
            // actActivity
            // 
            this.actActivity.HeaderText = "Activity";
            this.actActivity.Name = "actActivity";
            this.actActivity.ReadOnly = true;
            this.actActivity.Width = 400;
            // 
            // dgvAchievement
            // 
            this.dgvAchievement.AllowUserToAddRows = false;
            this.dgvAchievement.AllowUserToDeleteRows = false;
            this.dgvAchievement.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dgvAchievement.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.achDate,
            this.achAchievement});
            this.dgvAchievement.Location = new System.Drawing.Point(28, 33);
            this.dgvAchievement.Name = "dgvAchievement";
            this.dgvAchievement.SelectionMode = System.Windows.Forms.DataGridViewSelectionMode.FullRowSelect;
            this.dgvAchievement.Size = new System.Drawing.Size(547, 192);
            this.dgvAchievement.TabIndex = 2;
            // 
            // achDate
            // 
            this.achDate.HeaderText = "Date";
            this.achDate.Name = "achDate";
            this.achDate.ReadOnly = true;
            // 
            // achAchievement
            // 
            this.achAchievement.HeaderText = "Achievement";
            this.achAchievement.Name = "achAchievement";
            this.achAchievement.ReadOnly = true;
            this.achAchievement.Width = 400;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Microsoft Sans Serif", 15.75F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label1.Location = new System.Drawing.Point(23, 5);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(159, 25);
            this.label1.TabIndex = 3;
            this.label1.Text = "Achievements";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Font = new System.Drawing.Font("Microsoft Sans Serif", 15.75F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label2.Location = new System.Drawing.Point(23, 253);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(108, 25);
            this.label2.TabIndex = 4;
            this.label2.Text = "Activities";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Font = new System.Drawing.Font("Microsoft Sans Serif", 15.75F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label3.Location = new System.Drawing.Point(23, 494);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(108, 25);
            this.label3.TabIndex = 5;
            this.label3.Text = "Members";
            // 
            // btnModifyAchievement
            // 
            this.btnModifyAchievement.Location = new System.Drawing.Point(462, 231);
            this.btnModifyAchievement.Name = "btnModifyAchievement";
            this.btnModifyAchievement.Size = new System.Drawing.Size(113, 23);
            this.btnModifyAchievement.TabIndex = 6;
            this.btnModifyAchievement.Text = "Modify Achievement";
            this.btnModifyAchievement.UseVisualStyleBackColor = true;
            this.btnModifyAchievement.Click += new System.EventHandler(this.btnModifyAchievement_Click);
            // 
            // btnModifyActivity
            // 
            this.btnModifyActivity.Location = new System.Drawing.Point(462, 479);
            this.btnModifyActivity.Name = "btnModifyActivity";
            this.btnModifyActivity.Size = new System.Drawing.Size(113, 23);
            this.btnModifyActivity.TabIndex = 7;
            this.btnModifyActivity.Text = "Modify Activity";
            this.btnModifyActivity.UseVisualStyleBackColor = true;
            this.btnModifyActivity.Click += new System.EventHandler(this.btnModifyActivity_Click);
            // 
            // btnModifyMembership
            // 
            this.btnModifyMembership.Location = new System.Drawing.Point(462, 753);
            this.btnModifyMembership.Name = "btnModifyMembership";
            this.btnModifyMembership.Size = new System.Drawing.Size(113, 23);
            this.btnModifyMembership.TabIndex = 8;
            this.btnModifyMembership.Text = "Modify Membership";
            this.btnModifyMembership.UseVisualStyleBackColor = true;
            this.btnModifyMembership.Click += new System.EventHandler(this.btnModifyMembership_Click);
            // 
            // viewClubDetails
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(609, 788);
            this.Controls.Add(this.btnModifyMembership);
            this.Controls.Add(this.btnModifyActivity);
            this.Controls.Add(this.btnModifyAchievement);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.dgvAchievement);
            this.Controls.Add(this.dgvActivity);
            this.Controls.Add(this.dgvMembership);
            this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
            this.MaximizeBox = false;
            this.MinimizeBox = false;
            this.Name = "viewClubDetails";
            this.Text = "Manage Club Details";
            this.FormClosing += new System.Windows.Forms.FormClosingEventHandler(this.viewClubDetails_FormClosing);
            this.Load += new System.EventHandler(this.viewClubDetails_Load);
            ((System.ComponentModel.ISupportInitialize)(this.dgvMembership)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.dgvActivity)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.dgvAchievement)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.DataGridView dgvMembership;
        private System.Windows.Forms.DataGridView dgvActivity;
        private System.Windows.Forms.DataGridView dgvAchievement;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.DataGridViewTextBoxColumn achDate;
        private System.Windows.Forms.DataGridViewTextBoxColumn achAchievement;
        private System.Windows.Forms.Button btnModifyAchievement;
        private System.Windows.Forms.Button btnModifyActivity;
        private System.Windows.Forms.Button btnModifyMembership;
        private System.Windows.Forms.DataGridViewTextBoxColumn actDate;
        private System.Windows.Forms.DataGridViewTextBoxColumn actActivity;
        private System.Windows.Forms.DataGridViewTextBoxColumn mmbID;
        private System.Windows.Forms.DataGridViewTextBoxColumn mmbName;
    }
}