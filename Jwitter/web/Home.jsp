<?xml version="1.0" encoding="UTF-8"?>
<!--
    Document   : Home
    Created on : 15 mai 2009, 16:26:30
    Author     : cygan0031
-->
<jsp:root version="2.1" xmlns:c="http://java.sun.com/jsp/jstl/core" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" import="jwitter.Quote, jwitter.User" pageEncoding="UTF-8"/>
    <f:view>
        <webuijsf:page id="page1">
            <webuijsf:html id="html1">
                <webuijsf:head id="head1">
                    <webuijsf:link id="link1" url="/resources/stylesheet.css"/>
                </webuijsf:head>
                <jsp:declaration> String str = "hubert_cumberdale-background.png"; </jsp:declaration>
                <webuijsf:body id="body1" style="background-image: url(#{str})no-repeat bottom right;">
                    <webuijsf:form id="Formulaire">
                        <jsp:directive.include file="Header.jspf"/>
                        <div class="roundbox" id="page_content">
                            <jsp:scriptlet>if(request.getSession().getAttribute("user") == null) {</jsp:scriptlet>
                            <h2>Are you lost my friend ? Make a free jwitt account!</h2>
                            <jsp:scriptlet>} else {</jsp:scriptlet>
                            <h2>What the hell do you want to jwitt ?</h2>
                            <div style="text-align: right; width: 798px; padding: 10px">
                                <div style="text-align: left">
                                    <webuijsf:dropDown id="scope" items="#{Home.dropDown1DefaultOptions.options}" selected="#{MessageBean.scope}"/>
                                    <br/>
                                    <webuijsf:textArea columns="100" id="content" style="font-size: 15px;" text="#{MessageBean.content}"/>
                                </div>
                                <webuijsf:button actionExpression="#{Home.button_update_action}" id="button_update" style="padding: 5px;" text="jwitt it!"/>
                            </div>
                            <jsp:scriptlet>}</jsp:scriptlet>

                            <c:forEach items="#{messages}" var="m">
                                <p class="message">
                                    <c:if test="${m.friend_id != 0}">
                                    [DM]
                                    </c:if>
                                    <jsp:text> </jsp:text>
                                    <strong><webuijsf:hyperlink id="link_profile" text="#{m.username}" url="/faces/Profile.jsp?id=#{m.user_id}"/></strong>
                                    <jsp:text> </jsp:text>
                                    <c:out value="${m.content}"/>
                                    <jsp:text> </jsp:text>
                                    <br />
                                    <span class="notimportant">(<c:out value="${m.created}"/>)
                                    <c:if test="${m.user_id == user.id || user.rank == 1}">
                                    <jsp:text> </jsp:text>
                                        <webuijsf:hyperlink id="link_delete" text="delete" actionExpression="#{Home.link_delete_action}">
                                                <f:param name="id" value="#{m.id}" />
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
