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
    public partial class Tutor_Mainpage : Form
    {
        public Tutor_Mainpage()
        {
            InitializeComponent();
        }

        private void button3_Click(object sender, EventArgs e)
        {
            this.Hide();
           Tutor_Check_Class_Student TCCS = new Tutor_Check_Class_Student();
            TCCS.ShowDialog();
        }

        private void Tutor_Mainpage_Load(object sender, EventArgs e)
        {
            
        }

        private void button1_Click(object sender, EventArgs e)
        {

        }

        private void button4_Click(object sender, EventArgs e)
        {
            this.Hide();
            Login L = new Login();
            L.ShowDialog();
        }

        private void button2_Click(object sender, EventArgs e)
        {
            this.Hide();
            Tutor_AddClass TAC = new Tutor_AddClass();
            TAC.ShowDialog();
        }

        private void button5_Click(object sender, EventArgs e)
        {
            this.Hide();
            Tutor_UpdateProfile TUP = new Tutor_UpdateProfile();
            TUP.ShowDialog();
        }
    }
}
