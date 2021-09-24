<%@ Page Title="Regist" Language="C#" MasterPageFile="~/Site.Master" AutoEventWireup="true" CodeBehind="Regist.aspx.cs" Inherits="shoppingbsform.Views.Regist" %>

<asp:Content ID="BodyContent" ContentPlaceHolderID="MainContent" runat="server">
    <div class="layui-main sign signin-main">
        <div class="layui-row sign-header">
            <img src="/Content/images/BigBook.png" style="width: 48px;">
        </div>
        <div class="layui-row sign-header">
            <h2>Sign up to <%: WebName %>.</h2>
        </div>

        <div class="layui-form layui-card">
            <div class="layui-card-body signinbody">
                <span>Username</span>
                <asp:TextBox ID="useranme" runat="server" class="layui-input" name="useranme" autocomplete="off"></asp:TextBox>
                <span>Email address</span>
                <asp:TextBox ID="Email" runat="server" class="layui-input" name="email" autocomplete="off" TextMode="Email"></asp:TextBox>
                <%-- <input type="text" name="useranme" autocomplete="off" class="layui-input">--%>
                <div>
                    <label>
                        Password
                    </label>
                </div>
                <asp:TextBox ID="password" type="password" name="password" autocomplete="off" class="layui-input" runat="server"></asp:TextBox>
                <asp:Button ID="signup_btn" runat="server" Text="Sign up" class="layui-btn signinbtn" OnClick="signup_btn_Click"/>
            </div>
        </div>
    </div>
</asp:Content>
