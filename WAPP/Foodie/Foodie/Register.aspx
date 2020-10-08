<%@ Page Title="" Language="C#" MasterPageFile="~/Site.Master" AutoEventWireup="true" CodeBehind="Register.aspx.cs" Inherits="Foodie.Register" %>
<asp:Content ID="Content1" ContentPlaceHolderID="MainContent" runat="server">
    <p>
        <strong>REGISTRATION</strong></p>
    <p>
        Username:<asp:TextBox ID="txtUsername" runat="server"></asp:TextBox>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>
    <p>
        &nbsp;Password:<asp:TextBox ID="txtPassword" runat="server"></asp:TextBox>
        &nbsp;</p>
    <p>
        Email&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <asp:TextBox ID="txtEmail" runat="server"></asp:TextBox>
    </p>
    <p>
        Address:<asp:TextBox ID="txtAddress" runat="server"></asp:TextBox>
    </p>
    <p>
&nbsp; Gender :<asp:RadioButtonList ID="rbGender" runat="server" Width="146px">
            <asp:ListItem>Male</asp:ListItem>
            <asp:ListItem>Female</asp:ListItem>
        </asp:RadioButtonList>
&nbsp;&nbsp;&nbsp;&nbsp;
    </p>
    <p>
        Country:
        <asp:DropDownList ID="ddlCountry" runat="server" >
            <asp:ListItem>Malaysia</asp:ListItem>
            <asp:ListItem>Taiwan</asp:ListItem>
            <asp:ListItem>China</asp:ListItem>
        </asp:DropDownList>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; UserType<asp:DropDownList ID="ddlUserType" runat="server">
            <asp:ListItem>Admin</asp:ListItem>
            <asp:ListItem>Customer</asp:ListItem>
            <asp:ListItem>Restaurant Owner</asp:ListItem>
        </asp:DropDownList>
    </p>
    <p>
        <asp:Button ID="btnSubmit" runat="server" OnClick="btnSubmit_Click" Text="Submit" />
        <asp:Button ID="btnReset" runat="server" OnClick="btnReset_Click" Text="Reset" />
        <asp:SqlDataSource ID="SqlDataSource1" runat="server"></asp:SqlDataSource>
    </p>
</asp:Content>
