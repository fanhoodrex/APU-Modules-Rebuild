using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Data.OleDb; 

namespace Wawasan_Tuition_Centre
{
    public partial class Tutor_Check_Class_Student : Form
    {
        private OleDbConnection connection = new OleDbConnection("Provider=Microsoft.Jet.OLEDB.4.0;Data Source=Wawasan Tuition Centre.mdb");
        OleDbCommand command = new OleDbCommand();

        public Tutor_Check_Class_Student()
        {
            InitializeComponent();
        }

        private void Tutor_Check_Class_Student_Load(object sender, EventArgs e)
        {

        }

        private void button1_Click(object sender, EventArgs e)
        {
           command.Connection = connection;

            string query = "SELECT EnrollmentNumber.Student_ID, Users.First_Name, Users.Last_Name FROM EnrollmentNumber INNER JOIN Users ON Users.UserID = EnrollmentNumber.Student_ID WHERE EnrollmentNumber.Class_ID = '" + textBox1.Text + "'";
            command.CommandText = query;

            OleDbDataAdapter data_adapter = new OleDbDataAdapter(command);
            DataTable data_table = new DataTable();
            data_adapter.Fill(data_table);
            dataGridView1.DataSource = data_table;
        }

        private void button2_Click(object sender, EventArgs e)
        {
            this.Hide();
            Tutor_Mainpage TMP = new Tutor_Mainpage();
            TMP.ShowDialog();
        }
    }
}
