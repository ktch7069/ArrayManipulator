<?xml version="1.0" encoding="UTF-8"?>

<!--

    Document   : b64convert.xsl

    Created on : 2 March 2018, 3:46 PM

    Author     : tchung

    Description:

        Purpose of transformation follows.

    Credit to : https://github.com/ilyakharlamov/xslt_base64/blob/master/base64.xsl   

-->
<xsl:stylesheet version="1.0"
  xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    
    <xsl:output method ="html"/>

    <xsl:variable name="binaryValues" select="string('1,2,3,4,5')"/>
    <xsl:variable name="b64Indeces" select="string('A,B,C,D,E')"/>
    
    <xsl:template match="/">
       
        <xsl:variable name="chosen" select="string('C')"/>

         
        <xsl:call-template name="test">
            <xsl:with-param name="choose" select="$chosen"/>   
            <xsl:with-param name="indeces" select="$b64Indeces"/>
            <xsl:with-param name="values" select="$binaryValues"/>
        </xsl:call-template>  
    </xsl:template>    


    <xsl:template name="test">
        <xsl:param name="choose"/>
        <xsl:param name="indeces"/>
        <xsl:param name="values"/>
        
        <xsl:variable name="index" select="substring-before($indeces,',')"/>
        <xsl:variable name="value" select="substring-before($values,',')"/>
     
        <xsl:if test="($index != '') and ($value !='')">
            <xsl:choose>   
                <!--We haven't found the match yet, so keep going down-->
                <xsl:when test="$index != $choose">
                    <xsl:call-template name="test">
                        <xsl:with-param name="choose" select="$choose"/>
                        <xsl:with-param name="indeces" select="substring-after($indeces,',')"/>
                        <xsl:with-param name="values" select="substring-after($values,',')"/>
                    </xsl:call-template>
                </xsl:when>
                <!--We've found the match so out value-->
                <xsl:otherwise>
                    <xsl:value-of select="$value"/>
                </xsl:otherwise>
            </xsl:choose>
        </xsl:if>
    </xsl:template>
    
</xsl:stylesheet>