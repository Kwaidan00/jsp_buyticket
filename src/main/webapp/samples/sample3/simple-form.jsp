<%--
  ~ Aleksander Spyra for Software Development Academy, Wroclaw 2018
  --%>

<%--
  Created by IntelliJ IDEA.
  User: x220
  Date: 2018-05-01
  Time: 08:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <title>Formularze</title>
</head>
<body>

<div class="container">
    <div class="row">
        <div class="col-md-4"></div>
        <div class="col-md-4">

            <form action="/sample3/form-handler-servlet" method="POST" >
                <fieldset>
                    <legend>Informacje o studencie:</legend>
                    Imię: <input type="text" name="firstname" value="Grzegorz"><br>
                    Nazwisko: <input type="text" name="lastname" value="Brzęczyszczykiewicz"><br><br>
                    Pobiera stypendium <input type = "checkbox" name = "scholarship" checked = "checked" />
                    Mieszka w akademiku <input type = "checkbox" name = "dormitory"  />
                    <input type="submit" value="Wyślij">
                </fieldset>
            </form>

        </div>
        <div class="col-md-4">
        </div>
    </div>
</div>

</body>
</html>
