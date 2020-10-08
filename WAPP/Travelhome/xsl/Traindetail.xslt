<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  <xsl:template match="/">
    <table width="100%" align="center" cellpadding="0" cellspacing="0" border="1"
    style="background-color:#CCCCCC;font-family:verdana;font-size:10pt;border:1">
      <tr>
        <td width="10%" align="left">ID</td>
        <td width="15%" align="left">Train Number</td>
        <td width="10%" align="left">Date</td>
        <td width="25%" align="left">Departure</td>
        <td width="25%" align="left">Arrival</td>
        <td width="15%" align="left">Price(RM)</td>
      </tr>
    </table>
    <xsl:for-each select="Traindetail/Table">
      <table width="100%" align="center" cellpadding="0" cellspacing="0" border="1"
      style="font-family:verdana;font-size:10pt;border:1">
        <tr>
          <td width="10%" align="left">
            <xsl:value-of select="Id"/>
          </td>
          <td width="15%" align="left">
            <xsl:value-of select="Trainnumber"/>
          </td>
          <td width="10%" align="left">
            <xsl:value-of select="Date"/>
          </td>
          <td width="25%" align="left">
            <xsl:value-of select="Departurestation"/>
          </td>
          <td width="25%" align="left">
            <xsl:value-of select="Arrivalstation"/>
          </td>
          <td width="15%" align="left">
            <xsl:value-of select="Price"/>
          </td>
        </tr>
      </table>
    </xsl:for-each>
  </xsl:template>
</xsl:stylesheet>