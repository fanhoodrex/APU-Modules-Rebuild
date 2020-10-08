<%@ Page Title="" Language="C#" MasterPageFile="~/Site.Master" AutoEventWireup="true" CodeBehind="ForgetPassword.aspx.cs" Inherits="Foodie.ForgetPassword" %>
<asp:Content ID="Content1" ContentPlaceHolderID="MainContent" runat="server">
    <p>
        <br />
        FORGOT PASSWORD</p>
    <p>
        <asp:Label ID="Label2" runat="server" Text="Email"></asp:Label>
        <asp:TextBox ID="txtEmail" runat="server"></asp:TextBox>
        <asp:Button ID="btnSubmit" runat="server" OnClick="btnSubmit_Click" Text="Submit" />
        <asp:Button ID="btnReset" runat="server" OnClick="btnReset_Click" Text="Reset" />
    </p>
    <p>
        <asp:Label ID="lblMessage" runat="server" Text="-"></asp:Label>
    </p>
    <p>
    </p>
    <p>
    </p>
</asp:Content>
