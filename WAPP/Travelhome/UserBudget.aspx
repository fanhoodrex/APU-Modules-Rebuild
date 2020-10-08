<%@ Page Title="" Language="C#" MasterPageFile="~/mp.master" AutoEventWireup="true" CodeFile="UserBudget.aspx.cs" Inherits="UserBudget" %>

<asp:Content ID="Content1" ContentPlaceHolderID="ContentPlaceHolder1" Runat="Server">
    <p></p>
    <p></p>
     <div class="container">
    <div class="row">
        <div class="col-md-offset-3 col-md-6">
            <form class="form-horizontal" runat="server">
               <center> <span class="heading"><font size="30">Online budget recommendation</font> </span></center>
                <div class="form-group">
                   <center> <p></p>
                       <asp:Label ID="Label1" runat="server" Text="Budget" CssClass="about-w3left"></asp:Label>
                       &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <asp:TextBox ID="txtuserbudget" runat="server"></asp:TextBox></center>
                </div><p></p>
                <div class="form-group help">
                   <center> 
                       <asp:Label ID="Label2" runat="server" Text="Days for travel" CssClass="about-w3right"></asp:Label>
                       &nbsp; <asp:TextBox ID="txtdays" runat="server"></asp:TextBox></center>
                </div>
                 <div class="form-group">
                   <center> <p></p>
                       <asp:Label ID="Label3" runat="server" Text="Number of passengers"></asp:Label>
                       &nbsp;&nbsp;&nbsp;&nbsp; <asp:TextBox ID="txtnumpass" runat="server"></asp:TextBox></center>
                </div><p></p>
                 <div class="form-group">
                   <center> 
                       <asp:Label ID="Label4" runat="server" Text="Perfect place"></asp:Label>
                       &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <asp:TextBox ID="txtperfectplace" runat="server"></asp:TextBox></center>
                </div>
                 <div class="form-group">
                  
                </div><p></p>
                <center><asp:Button ID="btnadd" runat="server" OnClick="btncheck_Click" Text="Check" Height="37px" Width="97px" /></center><p></p>
            </form>
        </div>
    </div>
         </div>
</asp:Content>

