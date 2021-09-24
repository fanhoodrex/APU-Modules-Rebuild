<%@ Page Title="" Language="C#" MasterPageFile="~/Site.Master" AutoEventWireup="true" CodeBehind="Cart.aspx.cs" Inherits="shoppingbsform.Views.Cart" %>

<asp:Content ID="Content1" ContentPlaceHolderID="MainContent" runat="server">
    <div class="layui-main" style="text-align:center">
        <div class="layui-row sign-header">
            <img src="/Content/images/BigBook.png" style="width: 48px;">
        </div>
        <div class="layui-row sign-header">
            <h2>Your cart details</h2>
        </div>
        <div class="layui-card">
            <div class="layui-form layui-card-body signinbody">
                <ul class="cartdetails">
                </ul>
            </div>
        </div>
    </div>
    <asp:Literal ID="cartdetailscript" runat="server"></asp:Literal>
</asp:Content>
