<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : Admin
    Created on : 18 mai 2009, 17:51:41
    Author     : cygan0031
-->
<jsp:root version="2.1" xmlns:c="http://java.sun.com/jsp/jstl/core" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html"
    xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" import="jwitter.Quote, jwitter.User" pageEncoding="UTF-8"/>
    <f:view>
        <webuijsf:page id="page1">
            <webuijsf:html id="html1">
                <webuijsf:head id="head1">
                    <webuijsf:link id="link1" url="/resources/stylesheet.css"/>
                </webuijsf:head>
                <webuijsf:body id="body1" style="-rave-layout: grid">
                    <webuijsf:form id="Formulaire">
                        <jsp:directive.include file="Header.jspf"/>
                        <div class="roundbox" id="page_content">
                            <h2>Users</h2>
                            <table class="stylish">
                                <tr>
                                    <th class="num">#</th>
                                    <th>Username</th>
                                    <th></th>
                                </tr>
                                <jsp:scriptlet>int i = 1;</jsp:scriptlet>
                                <c:forEach items="${users}" var="u">
                                    <tr>
                                        <td class="num">
                                            <jsp:scriptlet>out.println(i++);</jsp:scriptlet>
                                        </td>
                                        <td>
                                            <c:out value="${u.username}"/>
                                        </td>
                                        <td>
                                            <webuijsf:hyperlink id="hyperlink2" text="delete" url="/faces/DeleteUser.jsp?id=#{u.id}"/>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </table>
                        </div>
                        <jsp:directive.include file="Footer.jspf"/>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
