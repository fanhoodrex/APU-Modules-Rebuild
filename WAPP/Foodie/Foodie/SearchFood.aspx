<%@ Page Title="" Language="C#" MasterPageFile="~/Site.Master" AutoEventWireup="true" CodeBehind="SearchFood.aspx.cs" Inherits="Foodie.SearchFood" %>
<asp:Content ID="Content1" ContentPlaceHolderID="MainContent" runat="server">
    <p>
        &nbsp;</p>
    <p>
        &nbsp;</p>
    <p>
        &nbsp;</p>
    <p>
        &nbsp;</p>
    <p>
        &nbsp;</p>
    <p>
        &nbsp;</p>
    <p>
        <asp:Label ID="Label2" runat="server" Font-Bold="True" Text="Search Product"></asp:Label>
        <br />
        <asp:Label ID="Label3" runat="server" Text="Product Name:"></asp:Label>
        <asp:TextBox ID="txtProductName" runat="server"></asp:TextBox>
    </p>
    <p>
        <asp:Button ID="btnSearch" runat="server" OnClick="btnAdd_Click" Text="Search" />
        <asp:Button ID="btnReset" runat="server" OnClick="btnReset_Click" Text="Reset" />
    </p>
    <p>
        &nbsp;</p>
    <asp:Panel ID="Panel1" runat="server">
        <br />
        <asp:Image ID="imgProd" runat="server" Width="194px" />
        <br />
        <br />
        <asp:Label ID="Label6" runat="server" Text="Name: "></asp:Label>
        <asp:Label ID="lblProdName" runat="server" Text="-"></asp:Label>
        <br />
        <br />
        <asp:Label ID="Label4" runat="server" Text="Description:"></asp:Label>
        <asp:Label ID="lblProdDesc" runat="server" Text="-"></asp:Label>
        <br />
        <br />
        <asp:Label ID="Label5" runat="server" Text="Price (RM)"></asp:Label>
        <asp:Label ID="lblProdPrice" runat="server" Text="-"></asp:Label>
        <br />
        <br />
        <br />
        <br />
        <br />
        <br />
    </asp:Panel>
    <p>
        <asp:Label ID="lblMessage" runat="server" Text="-"></asp:Label>
    </p>
    <p>
    </p>
    <p>
    </p>
</asp:Content>
