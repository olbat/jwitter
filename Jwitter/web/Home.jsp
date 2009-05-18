<?xml version="1.0" encoding="UTF-8"?>
<!--
    Document   : Home
    Created on : 15 mai 2009, 16:26:30
    Author     : cygan0031
-->
<jsp:root version="2.1" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" import="jwitter.Quote"/>
    <f:view>
        <webuijsf:page id="page1">
            <webuijsf:html id="html1">
                <webuijsf:head id="head1">
                    <webuijsf:link id="link1" url="/resources/stylesheet.css"/>
                </webuijsf:head>
                <jsp:declaration> String str = "hubert_cumberdale-background.png"; </jsp:declaration>
                <webuijsf:body id="body1" style="background-image: url(#{str})no-repeat bottom right;">
                    <webuijsf:form id="form1">
                        <jsp:directive.include file="Header.jspf"/>
                        <div class="roundbox" id="page_content">
                            Hello there my little friend :)
                        </div>
                        <jsp:directive.include file="Footer.jspf"/>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
