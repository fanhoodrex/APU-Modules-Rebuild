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
    public partial class Class_Schedule : Form
    {
        OleDbConnection connection = new OleDbConnection();
        OleDbCommand command = new OleDbCommand();

        public Class_Schedule()
        {
            connection.ConnectionString = "Provider=Microsoft.Jet.OLEDB.4.0;Data Source=Wawasan Tuition Centre.mdb";
            InitializeComponent();
        }

        private void Class_Schedule_Load(object sender, EventArgs e)
        {
           

        }

        private void btAdd_Click(object sender, EventArgs e)
        {
            connection.Open();
            OleDbCommand command = new OleDbCommand();
            command.Connection = connection;
            command.CommandText = "select * from ClassInfo where ClassID = '" + txtClassID.Text + "'";

            OleDbDataReader reader = command.ExecuteReader();
            int count = 0;
            while (reader.Read())
            {
                count = count + 1;
            }
            if (count == 1)
            {
                connection.Close();
                OleDbDataAdapter data_adapter = new OleDbDataAdapter(command);
                DataTable dataTable = new DataTable();
                data_adapter.Fill(dataTable);
                dataGridView1.DataSource = dataTable;
                connection.Close();
                connection.Dispose();
            }
        }

        private void dataGridView1_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {

        }

        private void button1_Click(object sender, EventArgs e)
        {
            this.Hide();
            Tutor_Mainpage TMP = new Tutor_Mainpage();
            TMP.ShowDialog();
        }
    }
}   
