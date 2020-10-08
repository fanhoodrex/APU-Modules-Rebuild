<%@ Page Title="" Language="C#" MasterPageFile="~/mp.master" AutoEventWireup="true" CodeFile="viewtrain.aspx.cs" Inherits="viewtrain" %>

<asp:Content ID="Content1" ContentPlaceHolderID="ContentPlaceHolder1" Runat="Server">
    <center><h1>Train list</h1></center><p></p><p></p><p></p>
    <center><table class"w-100" border="1" style="background-color:#FFFFFF; width: 959px;">
      <%= strtrainDetails %>
    </table></center>
    <p></p>
    <p></p>
   <center> <p>Notication: Please enter the Train number which you want.</p>
    <p>Type the real name and ID number.</p>
    <p>Before purchase please check the status</p>
       <p>Please purchase the to our bank account:4283322028xxxxxx</p>
   </center>
     <form class="form-horizontal" runat="server">
               <div class="form-group"> <center>
        <asp:Label ID="Label1" runat="server" Text="Train number"></asp:Label>
     &nbsp;&nbsp;&nbsp;&nbsp;
     <asp:TextBox ID="txttrainnum" runat="server"></asp:TextBox></center>
</div><p></p>
         <div class="form-group"> <center>
        <asp:Label ID="Label2" runat="server" Text="ID number"></asp:Label>
     &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;
     <asp:TextBox ID="idnum" runat="server"></asp:TextBox></center>
</div><p></p>
         <div class="form-group"> <center>
        <asp:Label ID="Label3" runat="server" Text="Real name"></asp:Label>
     &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
     <asp:TextBox ID="txtrname" runat="server"></asp:TextBox></center>
             <asp:TextBox ID="txtstatus" runat="server" Visible="False"></asp:TextBox>
             <asp:TextBox ID="txtprice" runat="server" Visible="False"></asp:TextBox>
</div><p></p>
          <center><asp:Button ID="btnorder" runat="server" OnClick="btnorder_Click" Text="Order" Height="37px" Width="97px" /></center><p></p>
     </form>
</asp:Content>

