<%@ Page Title="" Language="C#" MasterPageFile="~/mp.master" AutoEventWireup="true" CodeFile="Login.aspx.cs" Inherits="Login" %>

<asp:Content ID="Content1" ContentPlaceHolderID="ContentPlaceHolder1" Runat="Server">
    <p></p>
    <p></p>
     <div class="container">
    <div class="row">
        <div class="col-md-offset-3 col-md-6">
            <form class="form-horizontal" runat="server">
               <center> <span class="heading"><font size="30">User Login</font> </span></center>
                <div class="form-group">
                   <center> <p></p>
                       <asp:Label ID="Label1" runat="server" Text="Username"></asp:Label>
                       &nbsp;<asp:TextBox ID="txtUsername" runat="server"></asp:TextBox></center>
                </div><p></p>
                <div class="form-group help">
                   <center> 
                       <asp:Label ID="Label2" runat="server" Text="Password"></asp:Label>
                       &nbsp;<asp:TextBox ID="txtPassword" runat="server" TextMode="Password"></asp:TextBox></center>
                </div>
                <div class="form-group"><p></p>
                   <center><asp:Button ID="btnLogin" runat="server" OnClick="btnLogin_Click" Text="Login" Height="37px" Width="97px" /></center><p></p>
                   <center> <p><asp:Label ID="lblMessage" runat="server" Text="Message"></asp:Label></p></center><p></p>
                    <center><asp:Button ID="btnReset" runat="server" OnClick="btnReset_Click" Text="Reset" Height="37px" Width="97px" /></center>
                   <center><p><asp:LinkButton ID="LinkButton1" runat="server" OnClick="LinkButton1_Click">Forget Password?</asp:LinkButton></p></center>
                    <center><p><asp:LinkButton ID="LinkButton2" runat="server" OnClick="LinkButton2_Click">Don't have account? Here regist!</asp:LinkButton></p></center>
                </div>
            </form>
        </div>
    </div>
        <asp:SqlDataSource ID="SqlDataSource1" runat="server" ConnectionString="<%$ ConnectionStrings:ConnectionString %>" SelectCommand="SELECT * FROM [Users]"></asp:SqlDataSource>
</div>
</asp:Content>

