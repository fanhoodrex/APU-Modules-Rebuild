<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  <xsl:template match="/">
    <table width="100%" align="center" cellpadding="0" cellspacing="0" border="1"
    style="background-color:#CCCCCC;font-family:verdana;font-size:10pt;border:1">
      <tr>
        <td width="10%" align="left">ID</td>
        <td width="30%" align="left">Hotel Name</td>
        <td width="30%" align="left">Price Per Day(RM)</td>
        <td width="30%" align="left">Location</td>
      </tr>
    </table>
    <xsl:for-each select="Hoteldetail/Table">
      <table width="100%" align="center" cellpadding="0" cellspacing="0" border="1"
      style="font-family:verdana;font-size:10pt;border:1">
        <tr>
          <td width="10%" align="left"><xsl:value-of select="Id"/></td>
          <td width="30%" align="left"><xsl:value-of select="Hotelname"/></td>
          <td width="30%" align="left"><xsl:value-of select="Priceperday"/></td>
          <td width="30%" align="left"><xsl:value-of select="location"/></td>
        </tr>
      </table>
    </xsl:for-each>
  </xsl:template>
</xsl:stylesheet>