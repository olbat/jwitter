<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : Profile
    Created on : May 19, 2009, 3:11:30 AM
    Author     : jessy
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
                <webuijsf:body id="body1">
                    <webuijsf:form id="Formulaire">
                        <jsp:directive.include file="Header.jspf"/>
                        <div class="roundbox" id="page_content">
                            <h2>Profile : <webuijsf:hyperlink actionExpression="#{Profile.link_profile2_action}" id="link_profile2"
                                    text="#{currentuser.username}" url="/faces/Profile.jsp?id=#{currentuser.id}"/>
                                <br />
                                <c:if test="${user != null and currentuser.id != user.id}">
                                    <c:if test="${is_following}">
                                        <webuijsf:hyperlink actionExpression="#{Profile.link_delete_follow_action}" id="link_delete_follow" text="remove follow">
                                        <f:param name="id" value="#{currentuser.id}"/>
                                        </webuijsf:hyperlink>
                                    </c:if>
                                    <c:if test="${!is_following}">
                                        <webuijsf:hyperlink actionExpression="#{Profile.link_follow_action}" id="link_follow" text="follow">
                                        <f:param name="id" value="#{currentuser.id}"/>
                                        </webuijsf:hyperlink>
                                    </c:if>
                                </c:if>
                            </h2>
                            <c:forEach items="#{messages}" var="m">
                                <p class="message">
                                    <c:if test="${m.friend_id != 0}">
                                    [DM]
                                    </c:if>
                                    <jsp:text> </jsp:text>
                                    <strong>
                                        <webuijsf:hyperlink actionExpression="#{Profile.link_profile6_action}" id="link_profile6" text="#{m.username}" url="/faces/Profile.jsp?id=#{m.user_id}"/>
                                    </strong>
                                    <jsp:text> </jsp:text>
                                    <c:out value="${m.content}"/>
                                    <jsp:text> </jsp:text>
                                    <br/>
                                    <span class="notimportant">(<c:out value="${m.created}"/>)</span>
                                </p>
                            </c:forEach>
                            <br />
                            <div style="width: 48%;">
                                <h3>Following</h3>
                                <table class="stylish">
                                <tr>
                                    <th class="num">#</th>
                                    <th>Username</th>
                                </tr>
                                <jsp:scriptlet>int i = 1;</jsp:scriptlet>
                                <c:forEach items="#{following}" var="u">
                                    <tr>
                                        <td class="num">
                                            <jsp:scriptlet>out.println(i++);</jsp:scriptlet>
                                        </td>
                                        <td>
                                            <webuijsf:hyperlink actionExpression="#{Profile.link_profile3_action}" id="link_profile3"
                                    text="#{u.username}" url="/faces/Profile.jsp?id=#{u.id}"/>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </table>
                            </div>
                            <br />
                            <div style="width: 48%;">
                                <h3>Followers</h3>
                                <table class="stylish">
                                <tr>
                                    <th class="num">#</th>
                                    <th>Username</th>
                                </tr>
                                <jsp:scriptlet>i = 1;</jsp:scriptlet>
                                <c:forEach items="#{followers}" var="u">
                                    <tr>
                                        <td class="num">
                                            <jsp:scriptlet>out.println(i++);</jsp:scriptlet>
                                        </td>
                                        <td>
                                            <webuijsf:hyperlink actionExpression="#{Profile.link_profile4_action}" id="link_profile4"
                                    text="#{u.username}" url="/faces/Profile.jsp?id=#{u.id}"/>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </table>
                            </div>
                        </div>
                        <jsp:directive.include file="Footer.jspf"/>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
