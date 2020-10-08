<%@ Page Title="" Language="C#" MasterPageFile="~/mp.master" AutoEventWireup="true" CodeFile="addhoteli.aspx.cs" Inherits="addhoteli" %>

<asp:Content ID="Content1" ContentPlaceHolderID="ContentPlaceHolder1" Runat="Server">
    <p></p>
    <p></p>
     <div class="container">
    <div class="row">
        <div class="col-md-offset-3 col-md-6">
            <form class="form-horizontal" runat="server">
                <center> <span class="heading"><font size="30">Add Hotel</font></center><p></p>
               <div class="form-group">
    <center>
        <asp:Label ID="Label1" runat="server" Text="Hotel name"></asp:Label>
   
     &nbsp;&nbsp;&nbsp;
   
     <asp:TextBox ID="txthotelname" runat="server"></asp:TextBox></center>
    
</div><p></p>
<div class="form-group help">
    <center>
        <asp:Label ID="Label2" runat="server" Text="Location"></asp:Label>
        &nbsp;&nbsp;&nbsp;&nbsp; <asp:TextBox ID="txtlocation" runat="server"></asp:TextBox>
    </center>
</div><p></p>
<div class="form-group">
    <center>
        <asp:Label ID="Label5" runat="server" Text="Price per day(RM)"></asp:Label>
        <asp:TextBox ID="txtprice" runat="server"></asp:TextBox>
    </center>
</div><p></p>
<div class="form-group">
    <center>
        <asp:Label ID="Label3" runat="server" Text="Upload image"></asp:Label>
        &nbsp;<asp:FileUpload ID="fuProdImage" runat="server" CssClass="pull-right" />
    </center>
</div>
                <p></p>
<center><asp:Button ID="btnadd" runat="server" OnClick="btnadd_Click" Text="Add" Height="37px" Width="97px" /></center><p></p>
            </form>
        </div>
    </div>
         </div>
  
    </span>
  
</asp:Content>

