<%@ Page Title="" Language="C#" MasterPageFile="~/mp.master" AutoEventWireup="true" CodeFile="statusair.aspx.cs" Inherits="statusair" %>

<asp:Content ID="Content1" ContentPlaceHolderID="ContentPlaceHolder1" Runat="Server">
    <p></p>
    <center><h1>Airline order checking</h1></center>
    <form class="form-horizontal" runat="server">
         <div class="form-group">
                   <center> <p></p>
                       <asp:Label ID="Label1" runat="server" Text="ID number" CssClass="about-w3left"></asp:Label>
                       &nbsp;&nbsp; <asp:TextBox ID="txtid" runat="server"></asp:TextBox></center>
                </div><p></p>
        <center><asp:Button ID="btncheck" runat="server" OnClick="btnadd_Click" Text="Check" Height="37px" Width="97px" /></center>
    </form><p></p>
    <center><table class"w-100" border="1" style="background-color:#FFFFFF; width: 959px;">
      <%= strairlinestaDetails %>
    </table></center>
</asp:Content>

