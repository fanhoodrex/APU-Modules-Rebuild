namespace Wawasan_Tuition_Centre
{
    partial class TuitionTime
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
            this.components = new System.ComponentModel.Container();
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(TuitionTime));
            this.label1 = new System.Windows.Forms.Label();
            this.bt_Register = new System.Windows.Forms.Button();
            this.button1 = new System.Windows.Forms.Button();
            this.wawasan_Tuition_CentreDataSet = new Wawasan_Tuition_Centre.Wawasan_Tuition_CentreDataSet();
            this.wawasanTuitionCentreDataSetBindingSource = new System.Windows.Forms.BindingSource(this.components);
            this.dataGridView1 = new System.Windows.Forms.DataGridView();
            ((System.ComponentModel.ISupportInitialize)(this.wawasan_Tuition_CentreDataSet)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.wawasanTuitionCentreDataSetBindingSource)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView1)).BeginInit();
            this.SuspendLayout();
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.BackColor = System.Drawing.Color.Transparent;
            this.label1.Font = new System.Drawing.Font("Microsoft Sans Serif", 14.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label1.ForeColor = System.Drawing.SystemColors.ActiveCaptionText;
            this.label1.Location = new System.Drawing.Point(67, 49);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(420, 29);
            this.label1.TabIndex = 4;
            this.label1.Text = "Preview of Tuition Class Schedule ";
            this.label1.Click += new System.EventHandler(this.label1_Click);
            // 
            // bt_Register
            // 
            this.bt_Register.Location = new System.Drawing.Point(260, 438);
            this.bt_Register.Margin = new System.Windows.Forms.Padding(4);
            this.bt_Register.Name = "bt_Register";
            this.bt_Register.Size = new System.Drawing.Size(100, 28);
            this.bt_Register.TabIndex = 5;
            this.bt_Register.Text = "Next";
            this.bt_Register.UseVisualStyleBackColor = true;
            this.bt_Register.Click += new System.EventHandler(this.bt_Register_Click);
            // 
            // button1
            // 
            this.button1.Location = new System.Drawing.Point(538, 438);
            this.button1.Name = "button1";
            this.button1.Size = new System.Drawing.Size(105, 28);
            this.button1.TabIndex = 6;
            this.button1.Text = "Back";
            this.button1.UseVisualStyleBackColor = true;
            this.button1.Click += new System.EventHandler(this.button1_Click);
            // 
            // wawasan_Tuition_CentreDataSet
            // 
            this.wawasan_Tuition_CentreDataSet.DataSetName = "Wawasan_Tuition_CentreDataSet";
            this.wawasan_Tuition_CentreDataSet.SchemaSerializationMode = System.Data.SchemaSerializationMode.IncludeSchema;
            // 
            // wawasanTuitionCentreDataSetBindingSource
            // 
            this.wawasanTuitionCentreDataSetBindingSource.DataSource = this.wawasan_Tuition_CentreDataSet;
            this.wawasanTuitionCentreDataSetBindingSource.Position = 0;
            // 
            // dataGridView1
            // 
            this.dataGridView1.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dataGridView1.Location = new System.Drawing.Point(194, 106);
            this.dataGridView1.Name = "dataGridView1";
            this.dataGridView1.RowTemplate.Height = 24;
            this.dataGridView1.Size = new System.Drawing.Size(519, 306);
            this.dataGridView1.TabIndex = 7;
            this.dataGridView1.CellContentClick += new System.Windows.Forms.DataGridViewCellEventHandler(this.dataGridView1_CellContentClick);
            // 
            // TuitionTime
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("$this.BackgroundImage")));
            this.ClientSize = new System.Drawing.Size(897, 507);
            this.Controls.Add(this.dataGridView1);
            this.Controls.Add(this.button1);
            this.Controls.Add(this.bt_Register);
            this.Controls.Add(this.label1);
            this.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.Name = "TuitionTime";
            this.Text = "TuitionTime";
            this.Load += new System.EventHandler(this.TuitionTime_Load);
            ((System.ComponentModel.ISupportInitialize)(this.wawasan_Tuition_CentreDataSet)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.wawasanTuitionCentreDataSetBindingSource)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView1)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Button bt_Register;
        private System.Windows.Forms.Button button1;
        private Wawasan_Tuition_CentreDataSet wawasan_Tuition_CentreDataSet;
        private System.Windows.Forms.BindingSource wawasanTuitionCentreDataSetBindingSource;
        private System.Windows.Forms.DataGridView dataGridView1;
    }
}