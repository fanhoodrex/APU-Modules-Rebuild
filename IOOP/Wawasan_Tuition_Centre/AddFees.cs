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
    public partial class AddFees : Form
    {
       
        public OleDbConnection connection = new OleDbConnection(@"Provider=Microsoft.Jet.OLEDB.4.0;Data Source=Wawasan Tuition Centre.mdb");
     

        public AddFees()
        {
            InitializeComponent();
        }

        private void listBox1_SelectedIndexChanged(object sender, EventArgs e)
        {

        }

        private void Form3_Load(object sender, EventArgs e)
        {

            String source = "Provider=Microsoft.Jet.OLEDB.4.0;Data Source=Wawasan Tuition Centre.mdb";
            OleDbConnection connection = new OleDbConnection(source);
            OleDbCommand command = connection.CreateCommand();
            string query = "SELECT * FROM Payment where PaymentID = '" + textBox1.Text + "';";
            command.CommandText = query;

            OleDbDataAdapter data_adapter = new OleDbDataAdapter(command);
            DataTable dataTable = new DataTable();
            data_adapter.Fill(dataTable);
            dataGridView2.DataSource = dataTable;
        }

       
        private void bt_Search_Click(object sender, EventArgs e)

        {
            String source = "Provider=Microsoft.Jet.OLEDB.4.0;Data Source=Wawasan Tuition Centre.mdb";
            OleDbConnection connection = new OleDbConnection(source);
            OleDbCommand command = connection.CreateCommand();
            connection.Open();
            command.CommandText = "select * from Payment where PaymentID = '" + textBox1.Text + "'";
            command.Connection = connection;
            command.ExecuteNonQuery();

            OleDbDataReader searchID = command.ExecuteReader();
          
            while (searchID.Read())
            {
                txtEmail.Text = (searchID["Email"].ToString());
                txtMobileNumber.Text = (searchID["ContactNumber"].ToString());
                txtFirstName.Text = (searchID["FirstName"].ToString());
                txtLastName.Text = (searchID["LastName"].ToString());
                txttotfees.Text = (searchID["TotalFees"].ToString());
                txtpaidfees.Text = (searchID["PaidFees"].ToString());
                txtRemFees.Text = (searchID["RemainingFees"].ToString());
                dateTimePicker1.Value = Convert.ToDateTime(searchID["DateRegistered"]);
                txtPaymentID.Text = (searchID["PaymentID"].ToString());




            }

       

            
            
        }

        private void listView1_SelectedIndexChanged(object sender, EventArgs e)
        {

        }

        private void dataGridView1_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {

        }

        private void bt_ReturnMainPage_Click(object sender, EventArgs e)
        {
            this.Hide();
            Login L = new Login();
            L.ShowDialog();
        }

        private void btn_Addfees_Click(object sender, EventArgs e)
        {
            if (txtFirstName.Text == "" || txtLastName.Text == "" || txtEmail.Text == "" || txttotfees.Text=="" || dateTimePicker1.Text == "" || txtPaymentID.Text== "") 
            {
                MessageBox.Show("Please Fill All Fields");

            }
            
            else
            {
                
                connection.Open();
                OleDbCommand command = connection.CreateCommand();
                command.CommandType = CommandType.Text; 
                command.CommandText = "insert into [Payment] (FirstName,LastName,Email,ContactNumber,TotalFees,RemainingFees,PaidFees,PaymentDate,PaymentID) values ('" + txtFirstName.Text + "','" + txtLastName.Text + "','" + txtEmail.Text + "','" + txtMobileNumber.Text + "', '" + txttotfees.Text+"','"+ txtRemFees.Text + "','" + txtpaidfees.Text + "','" + dateTimePicker1.Value.ToString() +"','" + txtPaymentID.Text + "')";
                command.ExecuteNonQuery();
                connection.Close();
                MessageBox.Show("Data Insert Successfully");
                

            }
        }

        private void label10_Click(object sender, EventArgs e)
        {

        }

        private void button1_Click(object sender, EventArgs e)
        {
            if ( !string.IsNullOrEmpty(txttotfees.Text) && !string.IsNullOrEmpty(txtAddFees.Text))
            
                {
                txtRemFees.Text = (Convert.ToDouble(txttotfees.Text) - (Convert.ToDouble(txtAddFees.Text))).ToString();
                txtpaidfees.Text = (Convert.ToDouble(txttotfees.Text) - (Convert.ToDouble(txtRemFees.Text))).ToString();
            }
            


            
        }

        private void textBox1_TextChanged(object sender, EventArgs e)
        {

        }
    }
}
