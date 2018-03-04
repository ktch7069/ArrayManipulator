<?xml version="1.0" encoding="UTF-8"?>

 

<!--

    Document   : b64convert.xsl

    Created on : 2 March 2018, 3:46 PM

    Author     : tchung

    Description:

        Purpose of transformation follows.

    Credit to : https://github.com/ilyakharlamov/xslt_base64/blob/master/base64.xsl   

-->

 

<xsl:stylesheet version="2.0"
  xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
  xmlns:foo="http://whatever"
  xmlns:local="http://thisXsl"
  xmlns:b64="http://thisXsl">
    
 <!-- <xsl:function name="foo:compareCI">
    <xsl:param name="string1"/>
    <xsl:param name="string2"/>
    <xsl:value-of select="compare(upper-case($string1),upper-case($string2))"/>
  </xsl:function>-->
  
  <xsl:variable name="lookUpPath" select="document('lookup.xml')"/>

  <xsl:template match="/">

      <xsl:for-each select="b64Test/b64TestData">
            <xsl:call-template name="b64:decode"> 
             
                <xsl:with-param name="base64String" select="."/>
            </xsl:call-template>   
       
          <xsl:text>&#10;</xsl:text>
      </xsl:for-each>  
 
  </xsl:template>


  <!--Template to convert encoded B64 to ASCII

      1. Binary in B64 -> ASCII

       2.
    -->

    <xsl:template name="b64:decode">                  

        <xsl:param name="base64String"/>
       
        <!-- support for urlsafe 
        change -_into +/-->
        <xsl:variable name="base64StringUniversal" select="translate($base64String, '-_','+/')"/>
         
        
        
        <!--Case#1:No Padding at the end (no = in the last two b64 characters)
            execute if last 2 characters do not contain = character
        -->
        <xsl:if test="not(contains(substring($base64StringUniversal, string-length($base64StringUniversal) - 1), '='))">
                <xsl:variable name="binaryBase64String">
                        <xsl:call-template name="local:base64StringToBinary">
                                <xsl:with-param name="string" select="$base64StringUniversal"/>
                        </xsl:call-template>
                </xsl:variable>
                <xsl:call-template name="local:base64BinaryStringToAscii">
                        <xsl:with-param name="binaryString" select="$binaryBase64String"/>
                </xsl:call-template>
            
        </xsl:if>
 
        <!-- extract last two characters -->
        <xsl:variable name="secondLastChar" select="substring($base64StringUniversal, string-length($base64StringUniversal) - 1, 1)"/>
        <xsl:variable name="lastChar" select="substring($base64StringUniversal, string-length($base64StringUniversal), 1)"/>
        
       
        <!-- Case #2 : Only one padding
             execute if 2nd last character is not a =, and last character is = 
        -->
        <xsl:if test="($secondLastChar != '=') and ($lastChar = '=')">
          
           <!--<xsl:call-template name="local:base64BinaryStringToAscii">
                <xsl:with-param name="binaryString" select="$binaryBase64String"/>
            </xsl:call-template>-->

            <xsl:variable name="b64StringInBinary">
                <xsl:call-template name="local:base64StringToBinary">
                     <xsl:with-param name="string" select="substring-before($base64StringUniversal,'=')"/>  
                    <!--<xsl:with-param name="string" select="substring($base64StringUniversal, string-length($base64StringUniversal) - 3, 3)"/>-->
                </xsl:call-template>
            </xsl:variable>

            <!--should the substring parameter be partialBinary-->
            <xsl:call-template name="local:base64BinaryStringToAscii">
                <xsl:with-param name="binaryString" select="$b64StringInBinary"/>
            </xsl:call-template>

        </xsl:if>

        <!--Last 2 Characters are paddings - execute if last 2 characters are both = -->
        <xsl:if test="($secondLastChar = '=') and ($lastChar = '=')">
            
          <xsl:value-of select="'hello world'"/>
            <!-- xsl:text>this is == </xsl:text -->
            <xsl:variable name="binaryBase64String">
                <xsl:call-template name="local:base64StringToBinary">
                    <!-- xsl:with-param name="string" select="substring($base64StringUniversal, 1, string-length($base64StringUniversal) - 4)" / -->
                    <xsl:with-param name="string" select="substring-before($base64StringUniversal,'==')" />
                </xsl:call-template>
            </xsl:variable>

            <!-- xsl:value-of select="substring-before($base64StringUniversal,'==')"/ -->
            <xsl:call-template name="local:base64BinaryStringToAscii">
                <xsl:with-param name="binaryString" select="$binaryBase64String"/>
            </xsl:call-template>

            <!--<xsl:variable name="partialBinary">
                <xsl:call-template name="local:base64StringToBinary">
                    <xsl:with-param name="string" select="substring($base64StringUniversal, string-length($base64StringUniversal) - 3, 2)"/>
                </xsl:call-template>
            </xsl:variable>

            <xsl:call-template name="local:base64BinaryStringToAscii">
                <xsl:with-param name="binaryString" select="substring($partialBinary, 1, 7)"/>
            </xsl:call-template>-->
        </xsl:if>
    </xsl:template>

 
    <!-- Template to convert a base64 string to binary representation; this template calls template decimalToBinary 
        Recursively getting the first character in B64 and padd zeros if required
        Terminates when all characters have been converted
    -->
    <xsl:template name="local:base64StringToBinary">
        <xsl:param name="string"/>
        <xsl:variable name="base64Portion" select="substring($string, 1, 1)"/>
        <xsl:if test="$base64Portion != ''">
            <xsl:variable name="binary" select="$lookUpPath//b64ToBinary/item[base64 = $base64Portion]/binary"/>
            <xsl:call-template name="local:padZeros">
                <xsl:with-param name="string" select="$binary"/>
                <xsl:with-param name="no" select="6 - string-length($binary)"/>
            </xsl:call-template>
        </xsl:if>
        <xsl:if test="substring($string, 2) != ''">
            <xsl:call-template name="local:base64StringToBinary">
                <xsl:with-param name="string" select="substring($string, 2)"/>
            </xsl:call-template>
        </xsl:if>
    </xsl:template>
 

    <!-- Template to left pad a binary string, with the specified no of 0s, to make it of length 6 -->
    <xsl:template name="local:padZeros">
        <xsl:param name="string"/>
        <xsl:param name="no"/>

        <xsl:if test="$no &gt; 0">
            <xsl:call-template name="local:padZeros">
                <xsl:with-param name="string" select="concat('0', $string)"/>
                <xsl:with-param name="no" select="6 - string-length($string) - 1"/>
            </xsl:call-template>
        </xsl:if>
        <xsl:if test="$no = 0">
            <xsl:value-of select="$string"/>
        </xsl:if>
    </xsl:template>
        
        
    <!-- Template to convert the base64 binary string to ascii representation
         Recursively get 8bits of binary and look up the ASCII equvilant
    -->
    <xsl:template name="local:base64BinaryStringToAscii">
        <xsl:param name="binaryString"/>
        <xsl:variable name="binaryPortion8" select="substring($binaryString, 1, 8)"/>
        <xsl:if test="$binaryPortion8 != ''">
           
            <xsl:variable name="decoded8" select="$lookUpPath//binaryToAscii/item[binary =$binaryPortion8]/ascii"/>
            <xsl:choose>
                <xsl:when test="$decoded8 != ''">
                    <xsl:text>(8)</xsl:text>
                    <xsl:value-of select="$decoded8"/>
                    <xsl:call-template name="local:base64BinaryStringToAscii">
                        <xsl:with-param name="binaryString" select="substring($binaryString, 9)"/>
                    </xsl:call-template>
                </xsl:when>
                <xsl:otherwise>
                    <!--Should never get here! It means there's some non ASCII numeric chars-->
                </xsl:otherwise>
            </xsl:choose>		
        </xsl:if>
    </xsl:template>

</xsl:stylesheet>