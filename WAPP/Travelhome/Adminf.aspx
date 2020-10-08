<%@ Page Title="" Language="C#" MasterPageFile="~/mp.master" AutoEventWireup="true" CodeFile="Adminf.aspx.cs" Inherits="Adminf" %>

<asp:Content ID="Content1" ContentPlaceHolderID="ContentPlaceHolder1" Runat="Server">
    <p></p><form runat="server">
    <center><asp:Button ID="btnaai" runat="server" OnClick="btnaai_Click" Text="Add airline information" Height="37px" Width="195px" /></center><p></p>
    <center><asp:Button ID="btnati" runat="server" OnClick="btnati_Click" Text="Add train information" Height="37px" Width="193px" /></center><p></p>
    <center><asp:Button ID="btnahi" runat="server" OnClick="btnahi_Click" Text="Add hotel information" Height="37px" Width="188px" /></center><p></p>
         <center><asp:Button ID="btnr" runat="server" OnClick="btnr_Click" Text="Admin regist" Height="37px" Width="188px" /></center><p></p>
            <center><asp:Button ID="btnva" runat="server" OnClick="btnva_Click" Text="View airline order information" Height="37px" Width="256px" /></center><p></p>
            <center><asp:Button ID="btnvt" runat="server" OnClick="btnvt_Click" Text="View train order information" Height="37px" Width="254px" /></center><p></p>
            <center><asp:Button ID="btnvh" runat="server" OnClick="btnvh_Click" Text="View hotel book information" Height="37px" Width="254px" /></center><p></p>
           </form>
</asp:Content>

