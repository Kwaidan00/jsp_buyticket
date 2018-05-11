<%@ page import="java.util.Date" %><%--
  ~ Aleksander Spyra for Software Development Academy, Wroclaw 2018
  --%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <title>Mechanizm sesji</title>
</head>
<body>

<div class="container">
    <div class="row">
        <div class="col-md-4">
        </div>
        <div class="col-md-4">
            <%
                Integer counter = (Integer) session.getAttribute("counter");
                if (counter == null) {
                    counter = new Integer(1);
                } else {
                    counter = new Integer(counter.intValue() + 1);
                }
                session.setAttribute("counter", counter);
            %>
            <p>Counter: <%= counter.toString()%></p>
        </div>
        <div class="col-md-4">
            <h3>Statystyka sesji</h3>
            <p>Identyfikator sesji: <%= session.getId() %></p>
            <p>Czy jest nowa? <%= session.isNew() %></p>
            <p>Czas powstania: <%= session.getCreationTime() %><br>
                Czas jest podany w czasie Unixa. Bardziej czytelnie:
                <%= new Date(session.getCreationTime())%>
            </p>
            <p>Maksymalny czas nieaktywności: <%= session.getMaxInactiveInterval() %> sekund</p>

            <p>Czy identyfikator sesji pobrany z cookie? <%= request.isRequestedSessionIdFromCookie()%></p>
            <p>Czy identyfikator sesji pobrany z URL? <%= request.isRequestedSessionIdFromURL()%></p>
            <p>Czy identyfikator sesji jest ważny? <%=request.isRequestedSessionIdValid()%></p>
        </div>
    </div>
</div>

</body>
</html>
