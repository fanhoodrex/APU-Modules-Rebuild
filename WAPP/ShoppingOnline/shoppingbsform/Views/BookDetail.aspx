<%@ Page Title="" Language="C#" MasterPageFile="~/Site.Master" AutoEventWireup="true" CodeBehind="BookDetail.aspx.cs" Inherits="shoppingbsform.Views.BookDetail" %>

<asp:Content ID="Content1" ContentPlaceHolderID="MainContent" runat="server">
    <div class="layui-main feedbackbody">
        <div class="layui-row sign-header">
            <img src="/Content/images/BigBook.png" style="width: 48px;">
        </div>
        <div class="layui-row sign-header">
            <h2>Add a book to the shop</h2>
        </div>
        <div class="layui-card">
            <div class="layui-form layui-card-body signinbody">
                <span>Book name</span>
                <asp:TextBox required ID="bookname" runat="server" class="layui-input feedbackinput" autocomplete="off"></asp:TextBox>
                <div class="layui-row">
                    <span>Book image</span>
                    <div>
                        <button type="button" class="layui-btn" onclick="$('#MainContent_uploadimage').click()">Select image</button><asp:FileUpload runat="server" name="fileupload" ID="uploadimage" style="display:none" OnLoad="uploadimage_Load"></asp:FileUpload>
                    </div>
                </div>
                <asp:Image runat="server" ID="bookimage" />
                <span>Price</span>
                <asp:TextBox ID="Price" required runat="server" class="layui-input feedbackinput" autocomplete="off"></asp:TextBox>
                
                <span>Description</span>
                <asp:TextBox ID="DescriptionTxt" runat="server" class="layui-input feedbackinput feedbackcontent" autocomplete="off" Height="160px" TextMode="MultiLine"></asp:TextBox>
                <span>Infomations</span>
                <asp:TextBox ID="InfomationsTxt" runat="server" class="layui-input feedbackinput feedbackcontent" autocomplete="off" Height="160px" TextMode="MultiLine"></asp:TextBox>
                <asp:Button ID="save" runat="server" Text="Save" class="layui-btn feedbacksave" OnClick="save_Click" />
                <asp:Literal runat="server" Text="<script>$('#MainContent_uploadimage').on('change', function() {var filePath = $(this).val(), fileFormat = filePath.substring(filePath.lastIndexOf('.')).toLowerCase(),src = window.URL.createObjectURL(this.files[0]);$('#MainContent_bookimage').attr('src', src);});</script>" />
            </div>
        </div>
    </div>
</asp:Content>
