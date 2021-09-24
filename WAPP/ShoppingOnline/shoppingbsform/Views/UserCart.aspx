<%@ Page Title="" Language="C#" MasterPageFile="~/Site.Master" AutoEventWireup="true" CodeBehind="UserCart.aspx.cs" Inherits="shoppingbsform.Views.UserCart" %>
<asp:Content ID="Content1" ContentPlaceHolderID="MainContent" runat="server">
    <div class="layui-main">
        <div class="layui-collapse usercartitems">
        </div>
    </div>
    <asp:Literal runat="server" ID="usercartjscripts"></asp:Literal>
</asp:Content>
