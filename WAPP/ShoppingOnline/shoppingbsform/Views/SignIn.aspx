<%@ Page Title="Sign" Language="C#" MasterPageFile="~/Site.Master" AutoEventWireup="true" CodeBehind="SignIn.aspx.cs" Inherits="shoppingbsform.Views.SignIn" %>

<asp:Content ID="Content1" ContentPlaceHolderID="MainContent" runat="server">
    <div class="layui-main sign signin-main">
        <div class="layui-row sign-header">
            <img src="/Content/images/BigBook.png" style="width: 48px;">
        </div>
        <div class="layui-row sign-header">
            <h2>Sign in to <%: WebName %>.</h2>
        </div>

        <div class="layui-form layui-card">
            <div class="layui-card-body signinbody">
                <span>Username or email address</span>
                <asp:TextBox ID="useranme" runat="server" class="layui-input" name="useranme" autocomplete="off"></asp:TextBox>
                <%-- <input type="text" name="useranme" autocomplete="off" class="layui-input">--%>
                <div>
                    <label>
                        Password
                    <%--<a class="forgotlink" href="">Forgot password?</a>--%>
                    </label>
                </div>
                <asp:TextBox ID="password" type="password" name="password" autocomplete="off" class="layui-input" runat="server"></asp:TextBox>
                <%--                <button class="layui-btn signinbtn">Sign in</button>--%>
                <asp:Button ID="signin_btn" runat="server" Text="Sign in" class="layui-btn signinbtn" OnClick="signin_btn_Click" />
            </div>
        </div>
        <div class="layui-card">
            <div class="layui-card-body signin footinfo">
                <p>New to <%: WebName %>?</p>
                <a class="signin createinfo" href="/Views/Regist">Create an account.</a>
            </div>
        </div>
    </div>
</asp:Content>
