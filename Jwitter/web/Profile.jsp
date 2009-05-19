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
                            <h2>Profile : <webuijsf:hyperlink id="link_profile2" text="#{currentuser.username}" url="/faces/Profile.jsp?id=#{currentuser.id}"/>
                            </h2>
                            <c:forEach items="#{messages}" var="m">
                                <p class="message">
                                    <c:if test="${m.friend_id != 0}">
                                    [DM]
                                    </c:if>
                                    <jsp:text> </jsp:text>
                                    <strong>
                                        <webuijsf:hyperlink actionExpression="#{Profile.link_profile_action}" id="link_profile" text="#{m.username}" url="/faces/Profile.jsp?id=#{m.user_id}"/>
                                    </strong>
                                    <jsp:text> </jsp:text>
                                    <c:out value="${m.content}"/>
                                    <jsp:text> </jsp:text>
                                    <br/>
                                    <span class="notimportant">(<c:out value="${m.created}"/>)
                                    <c:if test="${user != null and m.user_id == user.id or user != null and user.rank == 1}">
                                            <jsp:text> </jsp:text>
                                            <webuijsf:hyperlink actionExpression="#{Profile.link_delete_action}" id="link_delete" text="delete">
                                                <f:param name="id" value="#{m.id}"/>
                                            </webuijsf:hyperlink>
                                        </c:if>
                                    </span>
                                </p>
                            </c:forEach>
                        </div>
                        <jsp:directive.include file="Footer.jspf"/>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
