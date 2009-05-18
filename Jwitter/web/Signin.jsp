<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : Signin
    Created on : 18 mai 2009, 16:04:09
    Author     : cygan0031
-->
<jsp:root version="2.1" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" import="jwitter.Quote" pageEncoding="UTF-8"/>
    <f:view>
        <webuijsf:page id="page1">
            <webuijsf:html id="html1">
                <webuijsf:head id="head1">
                    <webuijsf:link id="link1" url="/resources/stylesheet.css"/>
                </webuijsf:head>
                <webuijsf:body id="body1">
                    <webuijsf:form id="Formulaire">
                        <jsp:directive.include file="Header.jspf"/>
                        <div class="roundbox" id="page_content">
                            <h2>Signin</h2>
                            <p>
                                <webuijsf:messageGroup id="messageGroup1"/>
                            </p>
                            <p>
                                Username :<br/>
                                <webuijsf:textField id="username" required="true" text="#{UserBean.username}"/>
                            </p>
                            <p>
                                Password :<br/>
                                <webuijsf:passwordField id="password" password="#{UserBean.password}" required="true"/>
                            </p>
                            <p>
                                <webuijsf:button actionExpression="#{Signin.submit_button_action}" id="submit_button" text="Signin"/>
                            </p>
                        </div>
                        <jsp:directive.include file="Footer.jspf"/>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
