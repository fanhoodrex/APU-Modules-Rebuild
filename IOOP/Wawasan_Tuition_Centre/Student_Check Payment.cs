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
    public partial class Student_Check_Payment : Form
    {
        private OleDbConnection connection = new OleDbConnection("Provider=Microsoft.Jet.OLEDB.4.0;Data Source=Wawasan Tuition Centre.mdb");
        OleDbCommand command = new OleDbCommand();
        public Student_Check_Payment()
        {
            InitializeComponent();
        }

        private void bt_Search_Click(object sender, EventArgs e)
        {
            connection.Open();
            OleDbCommand command = new OleDbCommand();
            command.Connection = connection;
            command.CommandText = "select FirstName,LastName,StudentID,PaymentID,TotalFees,RemainingFees,PaidFees from Payment where PaymentID = '" + txtPaymentID.Text + "'";

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

        private void button1_Click(object sender, EventArgs e)
        {
            this.Hide();
            Staff_MainPage f4 = new Staff_MainPage();
            f4.ShowDialog();

        }
    }
}
