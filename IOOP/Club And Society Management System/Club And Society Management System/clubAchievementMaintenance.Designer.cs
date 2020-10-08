namespace Club_And_Society_Management_System
{
    partial class clubAchievementMaintenance
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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(clubAchievementMaintenance));
            this.dgvAchievement = new System.Windows.Forms.DataGridView();
            this.id = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.achDate = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.achAchievement = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.label1 = new System.Windows.Forms.Label();
            this.txtAchievement = new System.Windows.Forms.TextBox();
            this.dtpDate = new System.Windows.Forms.DateTimePicker();
            this.label2 = new System.Windows.Forms.Label();
            this.btnSave = new System.Windows.Forms.Button();
            this.btnNewAchievement = new System.Windows.Forms.Button();
            this.btnDelete = new System.Windows.Forms.Button();
            ((System.ComponentModel.ISupportInitialize)(this.dgvAchievement)).BeginInit();
            this.SuspendLayout();
            // 
            // dgvAchievement
            // 
            this.dgvAchievement.AllowUserToAddRows = false;
            this.dgvAchievement.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dgvAchievement.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.id,
            this.achDate,
            this.achAchievement});
            this.dgvAchievement.Location = new System.Drawing.Point(12, 34);
            this.dgvAchievement.Name = "dgvAchievement";
            this.dgvAchievement.SelectionMode = System.Windows.Forms.DataGridViewSelectionMode.FullRowSelect;
            this.dgvAchievement.Size = new System.Drawing.Size(547, 192);
            this.dgvAchievement.TabIndex = 3;
            this.dgvAchievement.SelectionChanged += new System.EventHandler(this.dgvAchievement_SelectionChanged);
            // 
            // id
            // 
            this.id.HeaderText = "id";
            this.id.Name = "id";
            this.id.Visible = false;
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
            this.label1.Location = new System.Drawing.Point(13, 245);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(75, 13);
            this.label1.TabIndex = 4;
            this.label1.Text = "Achievement: ";
            // 
            // txtAchievement
            // 
            this.txtAchievement.Location = new System.Drawing.Point(102, 245);
            this.txtAchievement.Name = "txtAchievement";
            this.txtAchievement.Size = new System.Drawing.Size(200, 20);
            this.txtAchievement.TabIndex = 5;
            // 
            // dtpDate
            // 
            this.dtpDate.Location = new System.Drawing.Point(102, 281);
            this.dtpDate.Name = "dtpDate";
            this.dtpDate.Size = new System.Drawing.Size(200, 20);
            this.dtpDate.TabIndex = 6;
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(46, 281);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(33, 13);
            this.label2.TabIndex = 7;
            this.label2.Text = "Date:";
            // 
            // btnSave
            // 
            this.btnSave.Location = new System.Drawing.Point(146, 307);
            this.btnSave.Name = "btnSave";
            this.btnSave.Size = new System.Drawing.Size(156, 23);
            this.btnSave.TabIndex = 8;
            this.btnSave.Text = "Save changes";
            this.btnSave.UseVisualStyleBackColor = true;
            this.btnSave.Click += new System.EventHandler(this.btnSave_Click);
            // 
            // btnNewAchievement
            // 
            this.btnNewAchievement.Location = new System.Drawing.Point(454, 5);
            this.btnNewAchievement.Name = "btnNewAchievement";
            this.btnNewAchievement.Size = new System.Drawing.Size(105, 23);
            this.btnNewAchievement.TabIndex = 9;
            this.btnNewAchievement.Text = "New Achievement";
            this.btnNewAchievement.UseVisualStyleBackColor = true;
            this.btnNewAchievement.Click += new System.EventHandler(this.btnNewAchievement_Click);
            // 
            // btnDelete
            // 
            this.btnDelete.Location = new System.Drawing.Point(484, 235);
            this.btnDelete.Name = "btnDelete";
            this.btnDelete.Size = new System.Drawing.Size(75, 23);
            this.btnDelete.TabIndex = 10;
            this.btnDelete.Text = "Delete";
            this.btnDelete.UseVisualStyleBackColor = true;
            this.btnDelete.Click += new System.EventHandler(this.btnDelete_Click);
            // 
            // clubAchievementMaintenance
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(571, 337);
            this.Controls.Add(this.btnDelete);
            this.Controls.Add(this.btnNewAchievement);
            this.Controls.Add(this.btnSave);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.dtpDate);
            this.Controls.Add(this.txtAchievement);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.dgvAchievement);
            this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
            this.MaximizeBox = false;
            this.MinimizeBox = false;
            this.Name = "clubAchievementMaintenance";
            this.Text = "Club Achievement Maintenance";
            this.FormClosing += new System.Windows.Forms.FormClosingEventHandler(this.clubAchievementMaintenance_FormClosing);
            this.Load += new System.EventHandler(this.clubAchievementMaintenance_Load);
            ((System.ComponentModel.ISupportInitialize)(this.dgvAchievement)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.DataGridView dgvAchievement;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.TextBox txtAchievement;
        private System.Windows.Forms.DateTimePicker dtpDate;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Button btnSave;
        private System.Windows.Forms.Button btnNewAchievement;
        private System.Windows.Forms.Button btnDelete;
        private System.Windows.Forms.DataGridViewTextBoxColumn id;
        private System.Windows.Forms.DataGridViewTextBoxColumn achDate;
        private System.Windows.Forms.DataGridViewTextBoxColumn achAchievement;
    }
}