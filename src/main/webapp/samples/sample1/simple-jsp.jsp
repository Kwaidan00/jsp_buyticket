<%--
  ~ Aleksander Spyra for Software Development Academy, Wroclaw 2018
  --%>
<%--
    Sekcja dyrektyw.
--%>
<%@ page import="java.util.Date" %>
<%@ page import="java.net.URL" %>
<%@ page import="org.json.JSONObject" %>
<%@ page import="org.json.JSONTokener" %>
<%@ page import="org.json.JSONArray" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--    Deklaracja pola visitCounter.
        Ponieważ kontener webowy w momencie startu kompiluje JSP do serwletu,
        a visitCounter staje się polem serwletu, możemy je traktować jako
        zmienną globalną, która nie zmienia się w trakcie działania serwera
        (aż do restartu).
--%>
<%! private long visitCounter = 0; %>

<!doctype html>
<html lang="pl">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <title>Strona startowa</title>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-4"></div>
        <div class="col-md-4">
            <h2>Witaj w naszym systemie zakupowym!</h2>
            <%-- Użycie wyrażenia.
                Jak widać, zmienna jest preinkrementowana i wyświetlana.
            --%>
            <p>Licznik odwiedzin: <%= ++visitCounter %></p>
        </div>
        <div class="col-md-4">
            <%-- Użycie wyrażenia.
                W jego wyniku w tym miejscu zostanie wyświetlona aktualna data.
            --%>
            <p>Dziś jest: <%= new Date() %></p>
            <%-- Użycie skryptletu.
                Z jego pomogą pobierane są dane z zewnętrznego API
            --%>
            <%
                // Stacja pogodowa Wrocław, ul. Wyb. J.Conrada-Korzeniowskiego 18
                int stationNumber = 117;
                URL parametersUrl = new URL("http://api.gios.gov.pl/pjp-api/rest/station/sensors/" + stationNumber);
                JSONArray parameters = new JSONArray(new JSONTokener(parametersUrl.openStream()));
                JSONObject parameter = parameters.getJSONObject(0);
                String paramName = parameter.getJSONObject("param").getString("paramName");

                URL indexesUrl = new URL("http://api.gios.gov.pl/pjp-api/rest/aqindex/getIndex/" + stationNumber);
                JSONObject root = new JSONObject(new JSONTokener(indexesUrl.openStream()));
                String so2index = root.getJSONObject("so2IndexLevel").getString("indexLevelName");
                String so2date = root.getString("so2SourceDataDate");
            %>

            <h4>Poziom zanieczyszczeń we Wro:</h4>
            <%-- Użycie wyrażenia.
                (a nawet dwa razy).
            --%>
            <p><%= paramName %></p>
            <p>Na dzień: <%= so2date %></p>
            <p>Stan: <%= so2index %></p>
        </div>
    </div>
</div>
</body>
</html>
