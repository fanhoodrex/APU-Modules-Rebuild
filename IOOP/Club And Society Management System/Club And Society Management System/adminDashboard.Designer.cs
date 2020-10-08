namespace Club_And_Society_Management_System
{
    partial class adminDashboard
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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(adminDashboard));
            this.pbxClub = new System.Windows.Forms.PictureBox();
            this.pbxAccount = new System.Windows.Forms.PictureBox();
            this.pbxLogout = new System.Windows.Forms.PictureBox();
            ((System.ComponentModel.ISupportInitialize)(this.pbxClub)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.pbxAccount)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.pbxLogout)).BeginInit();
            this.SuspendLayout();
            // 
            // pbxClub
            // 
            this.pbxClub.Image = ((System.Drawing.Image)(resources.GetObject("pbxClub.Image")));
            this.pbxClub.Location = new System.Drawing.Point(17, 12);
            this.pbxClub.Name = "pbxClub";
            this.pbxClub.Size = new System.Drawing.Size(181, 174);
            this.pbxClub.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.pbxClub.TabIndex = 0;
            this.pbxClub.TabStop = false;
            this.pbxClub.Click += new System.EventHandler(this.pbxClub_Click);
            // 
            // pbxAccount
            // 
            this.pbxAccount.Image = ((System.Drawing.Image)(resources.GetObject("pbxAccount.Image")));
            this.pbxAccount.Location = new System.Drawing.Point(229, 12);
            this.pbxAccount.Name = "pbxAccount";
            this.pbxAccount.Size = new System.Drawing.Size(181, 174);
            this.pbxAccount.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.pbxAccount.TabIndex = 1;
            this.pbxAccount.TabStop = false;
            this.pbxAccount.Click += new System.EventHandler(this.pbxAccount_Click);
            // 
            // pbxLogout
            // 
            this.pbxLogout.Image = ((System.Drawing.Image)(resources.GetObject("pbxLogout.Image")));
            this.pbxLogout.Location = new System.Drawing.Point(118, 211);
            this.pbxLogout.Name = "pbxLogout";
            this.pbxLogout.Size = new System.Drawing.Size(181, 174);
            this.pbxLogout.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.pbxLogout.TabIndex = 2;
            this.pbxLogout.TabStop = false;
            this.pbxLogout.Click += new System.EventHandler(this.pbxLogout_Click);
            // 
            // adminDashboard
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(423, 400);
            this.Controls.Add(this.pbxLogout);
            this.Controls.Add(this.pbxAccount);
            this.Controls.Add(this.pbxClub);
            this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
            this.MaximizeBox = false;
            this.MinimizeBox = false;
            this.Name = "adminDashboard";
            this.Text = "Admin Dashboard";
            this.FormClosing += new System.Windows.Forms.FormClosingEventHandler(this.adminDashboard_FormClosing);
            ((System.ComponentModel.ISupportInitialize)(this.pbxClub)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.pbxAccount)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.pbxLogout)).EndInit();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.PictureBox pbxClub;
        private System.Windows.Forms.PictureBox pbxAccount;
        private System.Windows.Forms.PictureBox pbxLogout;
    }
}