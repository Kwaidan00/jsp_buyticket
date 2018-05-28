<%@ page import="java.util.Date" %><%--
  ~ Aleksander Spyra for Software Development Academy, Wroclaw 2018
  --%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}"/>
<%--<fmt:setLocale value="pl_PL"/>--%>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="labels"/>

<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <title><fmt:message key="sample.title"/></title>
</head>
<body>

<div class="container">
    <div class="row">
        <div class="col-md-4">
        </div>
        <div class="col-md-4">

            <form method="GET">
                <select id="language" name="language" onchange="submit()">
                    <option value="pl_PL" ${language == 'pl_PL' ? 'selected' : ''}>Polski</option>
                    <option value="en_US" ${language == 'en_US' ? 'selected' : ''}>English</option>
                </select>
            </form>

        </div>
        <div class="col-md-4">
            <h3><fmt:message key="sample.info"/></h3>
        </div>
    </div>
</div>

</body>
</html>
