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
    
    public partial class TuitionTime : Form

    {
        OleDbConnection connection = new OleDbConnection();
        OleDbCommand command = new OleDbCommand();
        String source = "Provider=Microsoft.Jet.OLEDB.4.0;Data Source=Wawasan Tuition Centre.mdb";
        
        public TuitionTime()
        {
            InitializeComponent();
        }



        private void checkedListBox1_SelectedIndexChanged(object sender, EventArgs e)
        {

        }

        private void comboBox1_SelectedIndexChanged(object sender, EventArgs e)
        {

        }

        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void bt_Register_Click(object sender, EventArgs e)
        {
            this.Hide();
            AddFees f4 = new AddFees();
            f4.ShowDialog();

        }

        private void listBox1_SelectedIndexChanged(object sender, EventArgs e)
        {

        }

        private void dataGridView1_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {

        }

        private void TuitionTime_Load(object sender, EventArgs e)
        {
            connection.ConnectionString = source;
            connection.Open();
            command.Connection = connection;
            string query = "SELECT ClassID, SubjectName, ClassDay, ClassTime, ClassDuration FROM Classinfo;";
            command.CommandText = query;

            OleDbDataAdapter data_adapter = new OleDbDataAdapter(command);
            DataTable dataTable = new DataTable();
            data_adapter.Fill(dataTable);
            dataGridView1.DataSource = dataTable;


        }

        private void button1_Click(object sender, EventArgs e)
        {
            this.Hide();
            Staff_MainPage Main = new Staff_MainPage();
            Main.ShowDialog();
        }
    }
}
