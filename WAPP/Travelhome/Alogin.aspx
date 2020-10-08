<%@ Page Title="" Language="C#" MasterPageFile="~/mp.master" AutoEventWireup="true" CodeFile="Alogin.aspx.cs" Inherits="Alogin" %>

<asp:Content ID="Content1" ContentPlaceHolderID="ContentPlaceHolder1" Runat="Server">
    <p></p>
    <p></p>
     <div class="container">
    <div class="row">
        <div class="col-md-offset-3 col-md-6">
            <form class="form-horizontal" runat="server">
               <center> <span class="heading"><font size="30">Admin Login</font> </span></center>
                <div class="form-group">
                   <center> <p></p>
                      <asp:Label ID="Label1" runat="server" Text="Account name"></asp:Label>
                       &nbsp;<asp:TextBox ID="txtUsername" runat="server"></asp:TextBox></center>
                </div><p></p>
                <div class="form-group help">
                   <center> 
                       <asp:Label ID="Label2" runat="server" Text="Password"></asp:Label>
                       &nbsp;&nbsp;&nbsp; <asp:TextBox ID="txtPassword" runat="server" TextMode="Password"></asp:TextBox></center>
                    <asp:TextBox ID="txtut" runat="server" Visible="False"></asp:TextBox>
                </div>
                <div class="form-group"><p></p>
                   <center><asp:Button ID="btnLogin" runat="server" OnClick="btnLogin_Click" Text="Login" Height="37px" Width="97px" /></center><p></p>
                   <center> <p><asp:Label ID="lblMessage" runat="server" Text="Message"></asp:Label></p></center><p></p>
                    <center><asp:Button ID="btnReset" runat="server" OnClick="btnReset_Click" Text="Reset" Height="37px" Width="97px" /></center>
                   
                </div>
            </form>
        </div>
    </div>
        <asp:SqlDataSource ID="SqlDataSource1" runat="server" ConnectionString="<%$ ConnectionStrings:ConnectionString %>" SelectCommand="SELECT * FROM [Users]"></asp:SqlDataSource>
</div>
</asp:Content>

