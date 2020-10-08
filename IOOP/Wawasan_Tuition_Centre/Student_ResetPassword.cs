using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Wawasan_Tuition_Centre
{
    public partial class Student_ResetPassword : Form
    {
        public Student_ResetPassword()
        {
            InitializeComponent();
        }

        private void button2_Click(object sender, EventArgs e)
        {
            this.Hide();
            Student_MainPage SMP = new Student_MainPage();
            SMP.ShowDialog();

        }
    }
}
