<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  <xsl:template match="/">
    <table width="100%" align="center" cellpadding="0" cellspacing="0" border="1"
    style="background-color:#CCCCCC;font-family:verdana;font-size:10pt;border:1">
      <tr>
        <td width="5%" align="left">ID</td>
        <td width="20%" align="left">ID number</td>
        <td width="20%" align="left">Airline Number</td>
        <td width="10%" align="left">Name</td>
        <td width="25%" align="left">Status</td>
        <td width="20%" align="left">Price(RM)</td>
      </tr>
    </table>
    <xsl:for-each select="Airlinesta/Table">
      <table width="100%" align="center" cellpadding="0" cellspacing="0" border="1"
      style="font-family:verdana;font-size:10pt;border:1">
        <tr>
          <td width="5%" align="left">
            <xsl:value-of select="Id"/>
          </td>
          <td width="20%" align="left">
            <xsl:value-of select="idcard"/>
          </td>
          <td width="20%" align="left">
            <xsl:value-of select="airnum"/>
          </td>
          <td width="10%" align="left">
            <xsl:value-of select="uname"/>
          </td>
          <td width="25%" align="left">
            <xsl:value-of select="status"/>
          </td>
          <td width="20%" align="left">
            <xsl:value-of select="price"/>
          </td>
        </tr>
      </table>
    </xsl:for-each>
  </xsl:template>
</xsl:stylesheet>