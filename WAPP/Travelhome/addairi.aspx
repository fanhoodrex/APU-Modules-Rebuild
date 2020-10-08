<%@ Page Title="" Language="C#" MasterPageFile="~/mp.master" AutoEventWireup="true" CodeFile="addairi.aspx.cs" Inherits="addairi" %>

<asp:Content ID="Content1" ContentPlaceHolderID="ContentPlaceHolder1" Runat="Server">
    <p></p>
    <p></p>
     <div class="container">
    <div class="row">
        <div class="col-md-offset-3 col-md-6">
            <form class="form-horizontal" runat="server">
               <center> <span class="heading"><font size="30">Add airline</font> </span></center>
                <div class="form-group">
                   <center> <p></p>
                       <asp:Label ID="Label1" runat="server" Text="Airline number" CssClass="about-w3left"></asp:Label>
                       &nbsp;&nbsp; <asp:TextBox ID="txtairlineno" runat="server"></asp:TextBox></center>
                </div><p></p>
                <div class="form-group help">
                   <center> 
                       <asp:Label ID="Label2" runat="server" Text="Date" CssClass="about-w3right"></asp:Label>
                       &nbsp;&nbsp;&nbsp; <asp:TextBox ID="txtdate" runat="server"></asp:TextBox></center>
                </div>
                 <div class="form-group">
                   <center> <p></p>
                       <asp:Label ID="Label3" runat="server" Text="Departure"></asp:Label>
                       &nbsp;&nbsp;&nbsp;&nbsp; <asp:TextBox ID="txtdeparture" runat="server"></asp:TextBox></center>
                </div><p></p>
                 <div class="form-group">
                   <center> 
                       <asp:Label ID="Label4" runat="server" Text="Destination"></asp:Label>
                       &nbsp;&nbsp;&nbsp; <asp:TextBox ID="txtdestination" runat="server"></asp:TextBox></center>
                </div>
                 <div class="form-group">
                   <center> <p></p>
                       <asp:Label ID="Label5" runat="server" Text="Price"></asp:Label>
                       &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <asp:TextBox ID="txtprice" runat="server"></asp:TextBox></center>
                </div><p></p>
                <center><asp:Button ID="btnadd" runat="server" OnClick="btnadd_Click" Text="Add" Height="37px" Width="97px" /></center><p></p>
            </form>
        </div>
    </div>
         </div>
</asp:Content>

