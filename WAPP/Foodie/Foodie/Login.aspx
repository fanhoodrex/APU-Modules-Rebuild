<%@ Page Title="" Language="C#" MasterPageFile="~/Site.Master" AutoEventWireup="true" CodeBehind="Login.aspx.cs" Inherits="Foodie.Login" %>
<asp:Content ID="Content1" ContentPlaceHolderID="MainContent" runat="server">
    <p>
        <br />
        <asp:Label ID="Label2" runat="server" Text="LOGIN"></asp:Label>
        <br />
        <br />
        <asp:Label ID="Label4" runat="server" Text="Username"></asp:Label>
        <asp:TextBox ID="txtUsername" runat="server"></asp:TextBox>
        <br />
        <br />
        <asp:Label ID="Label3" runat="server" Text="Password"></asp:Label>
        <asp:TextBox ID="txtPassword" runat="server" TextMode="Password"></asp:TextBox>
        <asp:SqlDataSource ID="SqlDataSource1" runat="server" ConnectionString="<%$ ConnectionStrings:foodieConnectionString %>" SelectCommand="SELECT * FROM [Users]"></asp:SqlDataSource>
        <br />
        <br />
        <br />
        <br />
        <br />
        <asp:Label ID="lblMessage" runat="server" Text="-"></asp:Label>
        <asp:Button ID="btnLogin" runat="server" OnClick="btnLogin_Click" Text="Confirm" />
        <asp:Button ID="btnReset" runat="server" OnClick="btnReset_Click" Text="Reset" />
        <asp:LinkButton ID="LinkButton1" runat="server" OnClick="LinkButton1_Click">Forgot Password?</asp:LinkButton>
    </p>
</asp:Content>
