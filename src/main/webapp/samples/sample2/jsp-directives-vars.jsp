<%--
  ~ Aleksander Spyra for Software Development Academy, Wroclaw 2018
  --%>
<%--
    Sekcja dyrektyw.
--%>
<%@ page import="java.util.Enumeration" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>

<!doctype html>
<html lang="pl">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <title>Dyrektywy i zmienne</title>
</head>
<body>
<%--
    Użycie dyrektywy.
    Do tego pliku zostanie przeklejona na etapie kompilacji
    zawartość pligu JSPF.
--%>
<%@ include file="jsp-header.jspf"%>
<div class="container">
    <div class="row">
        <div class="col-md-4">
            <h5>Kilka informacji wyciągniętych z żądania:</h5>
            <%--
                Jak widać, do zmiennych zdefiniowanych można odwoływać się zarówno w czystej Javie,
                przy użyciu wyrażeń czy skryptletów, jak również za pomocą Expression Language.
            --%>
            <ul>
                <li>Adres lokalny: <%= request.getLocalAddr() %></li>
                <li>Nazwa lokalna: ${pageContext.request.localName}</li>
                <li>Port lokalny: ${pageContext.request.localPort}</li>
            </ul>
        </div>
        <div class="col-md-4">
            <h2>Na tej stronie użyto dyrektyw, zmiennych </h2>
        </div>
        <div class="col-md-4">
            <%--
                Poniższa tabelka przedstawia parametry nagłówka żądania.
                Użyto zmiennej niejawnej request.
            --%>
            <table>
                <tr><td>Header name</td><td>Header value</td></tr>
            <%
                Enumeration headerNames = request.getHeaderNames();
                while (headerNames.hasMoreElements()) {
                    String parameterName = (String) headerNames.nextElement();
                    String parameterValue = (String) request.getHeader(parameterName);
            %>
                    <tr><td><%= parameterName %></td><td><%= parameterValue%></td></tr>
                <%}
            %>
            </table>
        </div>
    </div>
</div>
</body>
</html>
