<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : Admin
    Created on : 18 mai 2009, 17:51:41
    Author     : cygan0031
-->
<jsp:root version="2.1" xmlns:c="http://java.sun.com/jsp/jstl/core" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html"
    xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:scriptlet>if(request.getSession().getAttribute("user") == null || !((User)request.getSession().getAttribute("user")).isAdmin()) {</jsp:scriptlet>
        <jsp:forward page="Home.jsp" />
    <jsp:scriptlet>}</jsp:scriptlet>
    <jsp:directive.page contentType="text/html;charset=UTF-8" import="jwitter.Quote, jwitter.User" pageEncoding="UTF-8"/>
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
                            <h2>Users</h2>
                            <table class="stylish">
                                <tr>
                                    <th class="num">#</th>
                                    <th>Username</th>
                                    <th>Rank</th>
                                    <th></th>
                                </tr>
                                <jsp:scriptlet>int i = 1;</jsp:scriptlet>
                                <c:forEach items="#{users}" var="u">
                                    <tr>
                                        <td class="num">
                                            <jsp:scriptlet>out.println(i++);</jsp:scriptlet>
                                        </td>
                                        <td>
                                            <webuijsf:hyperlink actionExpression="#{Profile.link_profile_action}" id="link_profile"
                                    text="#{u.username}" url="/faces/Profile.jsp?id=#{u.id}"/>
                                        </td>
                                        <td>
                                            <c:if test="${u.rank == 0}">
                                                user (<webuijsf:hyperlink id="link_upgrade" text="upgrade to admin" actionExpression="#{Admin.link_upgrade_action}">
                                                <f:param name="id" value="#{u.id}" />
                                            </webuijsf:hyperlink>)
                                            </c:if>
                                            <c:if test="${u.rank != 0}">
                                                admin (<webuijsf:hyperlink id="link_downgrade" text="downgrade to user" actionExpression="#{Admin.link_downgrade_action}">
                                                <f:param name="id" value="#{u.id}" />
                                            </webuijsf:hyperlink>)
                                            </c:if>
                                        </td>
                                        <td>
                                            <webuijsf:hyperlink id="link_delete" text="delete" actionExpression="#{Admin.link_delete_action}">
                                                <f:param name="id" value="#{u.id}" />
                                            </webuijsf:hyperlink>
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
