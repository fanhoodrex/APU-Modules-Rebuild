<%@ Page Title="" Language="C#" MasterPageFile="~/Site.Master" AutoEventWireup="true" CodeBehind="AddFood.aspx.cs" Inherits="Foodie.AddFood" %>
<asp:Content ID="Content1" ContentPlaceHolderID="MainContent" runat="server">
    <p>
    <asp:Label ID="Label2" runat="server" Font-Bold="True" Text="Add new product"></asp:Label>
    <br />
    <asp:Label ID="Label3" runat="server" Text="Food Name:"></asp:Label>
    <asp:TextBox ID="txtProductName" runat="server"></asp:TextBox>
</p>
<p>
    <asp:Label ID="Label4" runat="server" Text="Description:"></asp:Label>
    <asp:TextBox ID="txtDescription" runat="server" TextMode="MultiLine"></asp:TextBox>
</p>
<p>
    <asp:Label ID="Label5" runat="server" Text="Price (RM)"></asp:Label>
    <asp:TextBox ID="txtPrice" runat="server"></asp:TextBox>
</p>
<p>
    <asp:Label ID="Label6" runat="server" Text="Image"></asp:Label>
    <asp:FileUpload ID="fuProductImg" runat="server" />
</p>
<p>
    <asp:Button ID="btnAdd" runat="server" OnClick="btnAdd_Click" Text="Add" />
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
