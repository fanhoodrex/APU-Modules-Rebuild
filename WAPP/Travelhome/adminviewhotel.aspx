<%@ Page Title="" Language="C#" MasterPageFile="~/mp.master" AutoEventWireup="true" CodeFile="adminviewhotel.aspx.cs" Inherits="adminviewhotel" %>

<asp:Content ID="Content1" ContentPlaceHolderID="ContentPlaceHolder1" Runat="Server">
    <center><h1>All hotel order</h1></center><p></p>
    <center><table class"w-100" border="1" style="background-color:#FFFFFF; width: 959px;">
      <tr style="font-weight:bold;">
          <td style="height: 26px">ID number</td>
          <td style="height: 26px">Hotel name</td>
          <td style="height: 26px">Username</td>
          <td style="height: 26px">Price(RM)</td>
          <td style="height: 26px">Status</td>
      </tr>
        <%=fetchData()%>
    </table></center><p></p>
    <center><p>Admin update the status and price</p></center>
    <form class="form-horizontal" runat="server">
        <div class="form-group">
                   <center> 
                       <asp:Label ID="Label3" runat="server" Text="ID" CssClass="about-w3left"></asp:Label>
                       &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <asp:TextBox ID="txtid" runat="server"></asp:TextBox></center>
                </div><p></p>
         <div class="form-group">
                   <center> 
                       <asp:Label ID="Label1" runat="server" Text="Status" CssClass="about-w3left"></asp:Label>
                       &nbsp;&nbsp;&nbsp;&nbsp; <asp:TextBox ID="txtstatus" runat="server"></asp:TextBox></center>
                </div><p></p>
                <div class="form-group help">
                   <center> 
                       <asp:Label ID="Label2" runat="server" Text="Price" CssClass="about-w3right"></asp:Label>
                       &nbsp;<asp:TextBox ID="txtprice" runat="server"></asp:TextBox></center>
                </div><p></p>
        <center><asp:Button ID="btncheck" runat="server" OnClick="btncheck_Click" Text="Check" Height="37px" Width="97px" /></center><p></p>
        <center><asp:Button ID="btnupdate" runat="server" OnClick="btnupdate_Click" Text="Update" Height="37px" Width="97px" /></center><p></p>
        <center><asp:Button ID="btndelete" runat="server" OnClick="btndelete_Click" Text="Delete" Height="37px" Width="97px" /></center><p></p>
    </form>
</asp:Content>

