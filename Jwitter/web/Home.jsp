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
                <webuijsf:body id="body1">
                    <webuijsf:form id="form1">
                        <jsp:directive.include file="Header.jspf"/>
                        <div class="roundbox" id="page_content">
                            Hello there my little friend :)
                            <br/>
                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas varius hendrerit fermentum. Etiam placerat purus sagittis diam viverra vitae posuere libero auctor. Etiam eget purus ligula. Morbi scelerisque, eros sit amet mattis ultrices, mauris lacus sodales purus, pretium molestie lacus leo at leo. Donec malesuada fringilla justo, a dictum erat porttitor nec. Pellentesque a ante et nulla semper euismod nec non tortor. Nam dictum ante sed odio luctus pharetra. Ut convallis lacinia bibendum. Vestibulum a aliquam purus. Cras pulvinar pellentesque magna in posuere. Vivamus turpis enim, eleifend eget euismod vitae, iaculis quis risus. Fusce rutrum justo consectetur ante porttitor et aliquet sapien bibendum. Donec non pulvinar eros. Suspendisse aliquam, nisi ornare egestas porttitor, metus sapien cursus nunc, in porttitor enim urna in dolor. Proin vel justo justo, vel scelerisque ipsum. Mauris laoreet fringilla vulputate. Aliquam porttitor pellentesque felis in fringilla. Aenean vestibulum, urna ut egestas iaculis, lacus purus pellentesque nunc, quis lacinia elit turpis at augue. Ut pulvinar lacus pretium orci mollis lacinia.</p>
                            <p>Proin auctor feugiat erat sit amet tincidunt. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Maecenas consectetur eros quis odio sodales vitae fermentum elit commodo. Suspendisse molestie mi eu sem faucibus venenatis. Vestibulum arcu mi, euismod sed varius et, mattis vel erat. Integer feugiat elit ac urna laoreet et congue ante adipiscing. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Maecenas tempor erat vitae ipsum tincidunt dapibus. Fusce vel justo mi. Sed a viverra diam. Nunc mollis vulputate arcu quis consequat. Nulla facilisi. Maecenas porttitor mattis risus, non feugiat ipsum porta tempus. Nunc faucibus molestie tellus rhoncus porttitor.</p>
                            <p>Sed hendrerit ornare gravida. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Aliquam feugiat leo vitae lorem hendrerit id accumsan dui dignissim. Suspendisse porttitor tortor a metus vestibulum vehicula. Nulla imperdiet, sem et lobortis gravida, ipsum elit dictum urna, quis suscipit quam nisl eget erat. Phasellus quis mattis neque. Proin laoreet lectus ut mi gravida tincidunt. Praesent pharetra varius justo at laoreet. Nullam vestibulum malesuada velit posuere luctus. Sed euismod aliquet blandit. Vivamus ac nibh nec justo varius adipiscing sit amet vitae turpis. Aliquam auctor nunc at elit tempus eu porta diam porta. Nulla porta porttitor ligula, sed tristique dui tempor id. Donec sed odio neque. Nullam magna justo, mattis quis pellentesque ac, vulputate sit amet ipsum. Etiam non placerat turpis.</p>
                            <p>Vestibulum luctus sodales erat vel tristique. Fusce ipsum magna, suscipit at tempor vel, porta in odio. Ut placerat imperdiet enim nec consequat. Donec vitae velit ac sapien consectetur dictum. In adipiscing interdum tempor. Sed convallis urna at justo ultricies adipiscing. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur sed est vitae quam posuere varius id ac nunc. Vivamus porttitor ante in est auctor quis blandit ante sollicitudin. Aenean molestie rutrum nulla, gravida placerat erat congue quis. Pellentesque tortor tellus, gravida non porta quis, imperdiet vitae neque. Donec justo nibh, pretium at feugiat ut, fermentum a elit. Nam libero libero, porttitor quis hendrerit nec, facilisis et nisl.</p>
                            <p>Donec fermentum pellentesque pellentesque. Integer felis urna, porttitor nec lacinia et, lobortis sit amet odio. Sed eu sapien nibh, id ornare augue. Phasellus mollis, turpis vel tempor ultricies, velit massa vehicula neque, non vestibulum turpis nisl et enim. Phasellus blandit lorem nec turpis sodales quis fringilla nulla lobortis. Duis quis augue ante. In sodales, leo sit amet ultricies eleifend, mauris ligula accumsan augue, non tristique nulla justo eget leo. Phasellus tempus dui interdum mauris dictum quis volutpat augue convallis. Aliquam viverra arcu ut nibh ultrices at egestas diam euismod. Proin ut sapien vitae eros tincidunt interdum. Morbi tincidunt tortor quis sem iaculis pretium. Sed laoreet urna in justo cursus eget placerat velit mollis. Proin volutpat tortor a turpis pretium imperdiet. Nam vitae dolor eu nunc volutpat bibendum in ut dui. Nam tristique tincidunt bibendum. Cras volutpat est nec leo molestie condimentum. Sed enim lacus, viverra ullamcorper blandit in, semper at neque. </p>
                            <webuijsf:table augmentTitle="false" id="table1" title="Table" width="300">
                                <webuijsf:tableRowGroup id="tableRowGroup1" rows="5" sourceData="#{Home.usersDataProvider3}" sourceVar="currentRow">
                                    <webuijsf:tableColumn headerText="ID" id="tableColumn1" sort="USERS.ID">
                                        <webuijsf:staticText id="staticText1" text="#{currentRow.value['USERS.ID']}"/>
                                    </webuijsf:tableColumn>
                                    <webuijsf:tableColumn headerText="USERNAME" id="tableColumn2" sort="USERS.USERNAME">
                                        <webuijsf:staticText id="staticText2" text="#{currentRow.value['USERS.USERNAME']}"/>
                                    </webuijsf:tableColumn>
                                    <webuijsf:tableColumn headerText="RANK" id="tableColumn4" sort="USERS.RANK">
                                        <webuijsf:staticText id="staticText4" text="#{currentRow.value['USERS.RANK']}"/>
                                    </webuijsf:tableColumn>
                                </webuijsf:tableRowGroup>
                            </webuijsf:table>
                            <br/>
                        </div>
                        <jsp:directive.include file="Footer.jspf"/>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
