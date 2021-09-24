namespace Club_And_Society_Management_System
{
    partial class viewClub
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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(viewClub));
            this.dgvClub = new System.Windows.Forms.DataGridView();
            this.id = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.name = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.status = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.president = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.vicePresident = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.Secretary = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.dtCreated = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.btnJoin = new System.Windows.Forms.Button();
            this.btnUnjoin = new System.Windows.Forms.Button();
            this.dgvAchievement = new System.Windows.Forms.DataGridView();
            this.achDate = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.achAchievement = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.dgvActivity = new System.Windows.Forms.DataGridView();
            this.actDate = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.actActivity = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.label2 = new System.Windows.Forms.Label();
            this.label1 = new System.Windows.Forms.Label();
            this.lblDisplay = new System.Windows.Forms.Label();
            ((System.ComponentModel.ISupportInitialize)(this.dgvClub)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.dgvAchievement)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.dgvActivity)).BeginInit();
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
            this.dgvClub.Location = new System.Drawing.Point(12, 42);
            this.dgvClub.MultiSelect = false;
            this.dgvClub.Name = "dgvClub";
            this.dgvClub.SelectionMode = System.Windows.Forms.DataGridViewSelectionMode.FullRowSelect;
            this.dgvClub.Size = new System.Drawing.Size(743, 291);
            this.dgvClub.TabIndex = 1;
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
            // btnJoin
            // 
            this.btnJoin.Location = new System.Drawing.Point(638, 350);
            this.btnJoin.Name = "btnJoin";
            this.btnJoin.Size = new System.Drawing.Size(117, 23);
            this.btnJoin.TabIndex = 2;
            this.btnJoin.Text = "Join";
            this.btnJoin.UseVisualStyleBackColor = true;
            this.btnJoin.Click += new System.EventHandler(this.btnJoin_Click);
            // 
            // btnUnjoin
            // 
            this.btnUnjoin.Location = new System.Drawing.Point(638, 12);
            this.btnUnjoin.Name = "btnUnjoin";
            this.btnUnjoin.Size = new System.Drawing.Size(117, 23);
            this.btnUnjoin.TabIndex = 3;
            this.btnUnjoin.Text = "Unjoin";
            this.btnUnjoin.UseVisualStyleBackColor = true;
            this.btnUnjoin.Click += new System.EventHandler(this.btnUnjoin_Click);
            // 
            // dgvAchievement
            // 
            this.dgvAchievement.AllowUserToAddRows = false;
            this.dgvAchievement.AllowUserToDeleteRows = false;
            this.dgvAchievement.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dgvAchievement.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.achDate,
            this.achAchievement});
            this.dgvAchievement.Location = new System.Drawing.Point(12, 414);
            this.dgvAchievement.Name = "dgvAchievement";
            this.dgvAchievement.SelectionMode = System.Windows.Forms.DataGridViewSelectionMode.FullRowSelect;
            this.dgvAchievement.Size = new System.Drawing.Size(547, 192);
            this.dgvAchievement.TabIndex = 5;
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
            // dgvActivity
            // 
            this.dgvActivity.AllowUserToAddRows = false;
            this.dgvActivity.AllowUserToDeleteRows = false;
            this.dgvActivity.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dgvActivity.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.actDate,
            this.actActivity});
            this.dgvActivity.Location = new System.Drawing.Point(12, 666);
            this.dgvActivity.Name = "dgvActivity";
            this.dgvActivity.Size = new System.Drawing.Size(547, 192);
            this.dgvActivity.TabIndex = 4;
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
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Font = new System.Drawing.Font("Microsoft Sans Serif", 15.75F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label2.Location = new System.Drawing.Point(7, 634);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(108, 25);
            this.label2.TabIndex = 7;
            this.label2.Text = "Activities";
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Microsoft Sans Serif", 15.75F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label1.Location = new System.Drawing.Point(7, 386);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(159, 25);
            this.label1.TabIndex = 6;
            this.label1.Text = "Achievements";
            // 
            // lblDisplay
            // 
            this.lblDisplay.AutoSize = true;
            this.lblDisplay.Location = new System.Drawing.Point(13, 13);
            this.lblDisplay.Name = "lblDisplay";
            this.lblDisplay.Size = new System.Drawing.Size(35, 13);
            this.lblDisplay.TabIndex = 8;
            this.lblDisplay.Text = "label3";
            // 
            // viewClub
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(772, 870);
            this.Controls.Add(this.lblDisplay);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.dgvAchievement);
            this.Controls.Add(this.dgvActivity);
            this.Controls.Add(this.btnUnjoin);
            this.Controls.Add(this.btnJoin);
            this.Controls.Add(this.dgvClub);
            this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
            this.MaximizeBox = false;
            this.MinimizeBox = false;
            this.Name = "viewClub";
            this.Text = "View Club";
            this.FormClosing += new System.Windows.Forms.FormClosingEventHandler(this.viewClub_FormClosing);
            this.Load += new System.EventHandler(this.viewClub_Load);
            ((System.ComponentModel.ISupportInitialize)(this.dgvClub)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.dgvAchievement)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.dgvActivity)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.DataGridView dgvClub;
        private System.Windows.Forms.DataGridViewTextBoxColumn id;
        private System.Windows.Forms.DataGridViewTextBoxColumn name;
        private System.Windows.Forms.DataGridViewTextBoxColumn status;
        private System.Windows.Forms.DataGridViewTextBoxColumn president;
        private System.Windows.Forms.DataGridViewTextBoxColumn vicePresident;
        private System.Windows.Forms.DataGridViewTextBoxColumn Secretary;
        private System.Windows.Forms.DataGridViewTextBoxColumn dtCreated;
        private System.Windows.Forms.Button btnJoin;
        private System.Windows.Forms.Button btnUnjoin;
        private System.Windows.Forms.DataGridView dgvAchievement;
        private System.Windows.Forms.DataGridViewTextBoxColumn achDate;
        private System.Windows.Forms.DataGridViewTextBoxColumn achAchievement;
        private System.Windows.Forms.DataGridView dgvActivity;
        private System.Windows.Forms.DataGridViewTextBoxColumn actDate;
        private System.Windows.Forms.DataGridViewTextBoxColumn actActivity;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label lblDisplay;
    }
}