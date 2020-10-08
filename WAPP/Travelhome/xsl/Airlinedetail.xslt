<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match="/">
<table width="100%" align="center" cellpadding="0" cellspacing="0" border="1"
style="background-color:#CCCCCC;font-family:verdana;font-size:10pt;border:1">
<tr>
<td width="10%" align="left">ID</td>
<td width="10%" align="left">Airline Number</td>
<td width="20%" align="left">Date</td>
<td width="25%" align="left">Departure</td>
<td width="25%" align="left">Distination</td>
<td width="10%" align="left">Prices(RM)</td>
</tr>
</table>
<xsl:for-each select="Airlinedetail/Table">
<table width="100%" align="center" cellpadding="0" cellspacing="0" border="1"
style="font-family:verdana;font-size:10pt;border:1">
<tr>
<td width="10%" align="left"><xsl:value-of select="Id"/></td>
<td width="10%" align="left"><xsl:value-of select="airnumber"/></td>
<td width="20%" align="left"><xsl:value-of select="date"/></td>
<td width="25%" align="left"><xsl:value-of select="departure"/></td>
<td width="25%" align="left"><xsl:value-of select="destination"/></td>
<td width="10%" align="left"><xsl:value-of select="price"/></td>
</tr>
</table>
</xsl:for-each>
</xsl:template>
</xsl:stylesheet>