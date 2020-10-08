<%@ Page Title="" Language="C#" MasterPageFile="~/mp.master" AutoEventWireup="true" CodeFile="ForgotPassword.aspx.cs" Inherits="ForgotPassword" %>

<asp:Content ID="Content1" ContentPlaceHolderID="ContentPlaceHolder1" Runat="Server">
    <p></p>
    <p></p>
     <div class="container">
    <div class="row">
        <div class="col-md-offset-3 col-md-6">
            <form class="form-horizontal" runat="server">
               <center> <span class="heading"><font size="30">Find password</font> </span></center>
                <div class="form-group">
                   <center> <p></p>
                       <asp:Label ID="Label1" runat="server" Text="E-mail"></asp:Label>
                       &nbsp;<asp:TextBox ID="txtEmail" runat="server"></asp:TextBox></center>
               
                <div class="form-group"><p></p>
                   <center><asp:Button ID="txtSubmit" runat="server" OnClick="txtSubmit_Click" Text="Submit" Height="37px" Width="97px" /></center><p></p>
                   <center> <p><asp:Label ID="lblMessage" runat="server" Text="Message"></asp:Label></p></center><p></p>
                    <center><asp:Button ID="btnReset" runat="server" OnClick="btnReset_Click" Text="Reset" Height="37px" Width="97px" /></center>
                </div>
            </form>
        </div>
    </div>
        <asp:SqlDataSource ID="SqlDataSource1" runat="server" ConnectionString="<%$ ConnectionStrings:ConnectionString %>" SelectCommand="SELECT * FROM [Users]"></asp:SqlDataSource>
</div>
</asp:Content>

