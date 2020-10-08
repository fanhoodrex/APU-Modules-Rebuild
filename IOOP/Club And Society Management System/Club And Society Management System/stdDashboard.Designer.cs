namespace Club_And_Society_Management_System
{
    partial class stdDashboard
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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(stdDashboard));
            this.pbxClub = new System.Windows.Forms.PictureBox();
            this.pbxAchievement = new System.Windows.Forms.PictureBox();
            this.pbxActivity = new System.Windows.Forms.PictureBox();
            this.pbxLogout = new System.Windows.Forms.PictureBox();
            ((System.ComponentModel.ISupportInitialize)(this.pbxClub)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.pbxAchievement)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.pbxActivity)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.pbxLogout)).BeginInit();
            this.SuspendLayout();
            // 
            // pbxClub
            // 
            this.pbxClub.Image = ((System.Drawing.Image)(resources.GetObject("pbxClub.Image")));
            this.pbxClub.Location = new System.Drawing.Point(22, 30);
            this.pbxClub.Name = "pbxClub";
            this.pbxClub.Size = new System.Drawing.Size(143, 138);
            this.pbxClub.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.pbxClub.TabIndex = 0;
            this.pbxClub.TabStop = false;
            this.pbxClub.Click += new System.EventHandler(this.pbxClub_Click);
            // 
            // pbxAchievement
            // 
            this.pbxAchievement.Image = ((System.Drawing.Image)(resources.GetObject("pbxAchievement.Image")));
            this.pbxAchievement.Location = new System.Drawing.Point(213, 30);
            this.pbxAchievement.Name = "pbxAchievement";
            this.pbxAchievement.Size = new System.Drawing.Size(143, 138);
            this.pbxAchievement.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.pbxAchievement.TabIndex = 1;
            this.pbxAchievement.TabStop = false;
            this.pbxAchievement.Click += new System.EventHandler(this.pbxAchievement_Click);
            // 
            // pbxActivity
            // 
            this.pbxActivity.Image = ((System.Drawing.Image)(resources.GetObject("pbxActivity.Image")));
            this.pbxActivity.Location = new System.Drawing.Point(27, 188);
            this.pbxActivity.Name = "pbxActivity";
            this.pbxActivity.Size = new System.Drawing.Size(143, 138);
            this.pbxActivity.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.pbxActivity.TabIndex = 2;
            this.pbxActivity.TabStop = false;
            this.pbxActivity.Click += new System.EventHandler(this.pbxActivity_Click);
            // 
            // pbxLogout
            // 
            this.pbxLogout.Image = ((System.Drawing.Image)(resources.GetObject("pbxLogout.Image")));
            this.pbxLogout.Location = new System.Drawing.Point(213, 188);
            this.pbxLogout.Name = "pbxLogout";
            this.pbxLogout.Size = new System.Drawing.Size(143, 138);
            this.pbxLogout.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.pbxLogout.TabIndex = 3;
            this.pbxLogout.TabStop = false;
            this.pbxLogout.Click += new System.EventHandler(this.pbxLogout_Click);
            // 
            // stdDashboard
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(370, 340);
            this.Controls.Add(this.pbxLogout);
            this.Controls.Add(this.pbxActivity);
            this.Controls.Add(this.pbxAchievement);
            this.Controls.Add(this.pbxClub);
            this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
            this.MaximizeBox = false;
            this.MinimizeBox = false;
            this.Name = "stdDashboard";
            this.Text = "Student Dashboard";
            this.FormClosing += new System.Windows.Forms.FormClosingEventHandler(this.stdDashboard_FormClosing);
            this.Load += new System.EventHandler(this.stdDashboard_Load);
            ((System.ComponentModel.ISupportInitialize)(this.pbxClub)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.pbxAchievement)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.pbxActivity)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.pbxLogout)).EndInit();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.PictureBox pbxClub;
        private System.Windows.Forms.PictureBox pbxAchievement;
        private System.Windows.Forms.PictureBox pbxActivity;
        private System.Windows.Forms.PictureBox pbxLogout;
    }
}