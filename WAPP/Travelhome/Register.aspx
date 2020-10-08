<%@ Page Title="" Language="C#" MasterPageFile="~/mp.master" AutoEventWireup="true" CodeFile="Register.aspx.cs" Inherits="Register" %>

<asp:Content ID="Content1" ContentPlaceHolderID="ContentPlaceHolder1" Runat="Server">
    <p></p>
    <p></p>
     <div class="container">
    <div class="row">
        <div class="col-md-offset-3 col-md-6">
            <form class="form-horizontal" runat="server">
               <center> <span class="heading"><font size="30">User Regist</font> </span></center>
                <div class="form-group">
                   <center> <p></p>
                       <asp:Label ID="Label1" runat="server" Text="Username"></asp:Label>
                       &nbsp;<asp:TextBox ID="txtUsername" runat="server"></asp:TextBox></center>
                </div><p></p>
                <div class="form-group help">
                   <center> 
                       <asp:Label ID="Label2" runat="server" Text="Password"></asp:Label>
                       &nbsp;<asp:TextBox ID="txtPassword" runat="server"></asp:TextBox></center>
                </div>
                 <div class="form-group">
                   <center> <p></p>
                       <asp:Label ID="Label3" runat="server" Text="E-mail"></asp:Label>
                       &nbsp;<asp:TextBox ID="txtEmail" runat="server"></asp:TextBox></center>
                </div><p></p>
                <div class="form-group">
                    <center><asp:RadioButtonList ID="rdbGender" runat="server" Height="47px" Width="145px">
                    <asp:ListItem>Male</asp:ListItem><asp:ListItem>Female</asp:ListItem></asp:RadioButtonList></center><p></p>
                    <center> <asp:DropDownList ID="ddlCountry" runat="server">
                    <asp:ListItem>Malaysia</asp:ListItem>
                    <asp:ListItem>China</asp:ListItem>
                    <asp:ListItem>Japan</asp:ListItem>
                    <asp:ListItem>Korean</asp:ListItem>
                </asp:DropDownList></center><p></p>
                     <center><asp:DropDownList ID="ddlUserType" runat="server">
                    <asp:ListItem>Guest</asp:ListItem>
                </asp:DropDownList></center><p></p>
                   <center><asp:Button ID="btnRegister" runat="server" OnClick="btnRegister_Click" Text="Regist" Height="37px" Width="97px" /></center><p></p>
                    <center><asp:Button ID="btnReset" runat="server" OnClick="btnReset_Click" Text="Reset" Height="37px" Width="97px" /></center>
                  
                </div>
            </form>
        </div>
    </div>
        <asp:SqlDataSource ID="SqlDataSource1" runat="server" ConnectionString="<%$ ConnectionStrings:ConnectionString %>" SelectCommand="SELECT * FROM [Users]"></asp:SqlDataSource>
</div>
</asp:Content>

