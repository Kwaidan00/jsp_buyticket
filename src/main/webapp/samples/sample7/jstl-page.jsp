<%@ page import="java.util.Date" %>
<%--
  ~ Aleksander Spyra for Software Development Academy, Wroclaw 2018
  --%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
    Deklaracja użycia biblioteki tagów.
    Aby wszystko działało, na serwerze muszą znajdować się odpowiednie biblioteki
    (dodane w pliku pom.xml).
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <title>JSTL</title>
</head>
<body>

<div class="container">
    <div class="row">
        <div class="col-md-4">
            <h2>Tabela wygenerowana za pomocą tagów</h2>

            <table>
                <tr>
                    <th>Imię</th>
                    <th>Nazwisko</th>
                </tr>

                <c:forEach items="${student_list}" var="student">
                    <tr>
                        <td>
                            ${student.firstName}
                        </td>
                        <td>
                            ${student.lastName}
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <div class="col-md-4">
            <h3>Instrukcje warunkowe</h3>

            <h6>Instrukcja IF</h6>
            <c:if test="${age >= 18}">
                <p>Pełnoletni</p>
            </c:if>

            <h6>Instrukcja choose-when-otherwise</h6>
            <c:choose>
                <c:when test="${age < 18}">
                    <p>Niepełnoletni</p>
                </c:when>
                <c:when test="${age > 65}">
                    <p>Emeryt</p>
                </c:when>
                <c:otherwise>
                    <p>Pełnoletni, pracujący</p>
                </c:otherwise>
            </c:choose>

        </div>
        <div class="col-md-4">
            <h3>Tagi formatujące</h3>
            <h6>Formatowanie liczb</h6>
            <%--
                Tak, za pomocą tagów mozna także deklarować zmienne
            --%>
            <c:set var="myNumber" value="42.4242"/>

            <p>Liczba: <c:out value="${myNumber}"/></p>
            <p>Tylko dwie liczby po przecinku:
                <fmt:formatNumber type="number" maxFractionDigits="2" value="${myNumber}"/>
            </p>
            <p>Jako procenty:
                <fmt:formatNumber type="percent" value="${myNumber}" maxIntegerDigits="2"/>
            </p>
            <p>Jako waluta:
                <fmt:formatNumber type="currency" value="${myNumber}" currencyCode="PLN"/>
            </p>

            <h6>Formatwanie daty</h6>

            <c:set var="date" value="<%= new java.util.Date() %>"/>

            <p>Tylko czas:
                <fmt:formatDate value="${date}" type="time"/>
            </p>
            <p>Tylko data:
                <fmt:formatDate value="${date}" type="date"/>
            </p>
            <p>I jedno, i drugie:
                <fmt:formatDate value="${date}" type="both"/>
            </p>

        </div>
    </div>
    <div class="row" style="margin-top: 20px; border-top: 2px solid grey;">
        <div class="col-md-4">
            <h3>Tagi - funkcje</h3>

            <h6>Zamiana znaków</h6>
            <c:set var="lorem" value="Lorem ipsum doloret sit amet"/>
            <p>Zawartość zmiennej:
                <c:out value="${lorem}"/>
            </p>
            <p>Zamiana:
                <c:out value="${fn:replace(lorem, 'ipsum', 'spam')}"/>
            </p>

            <h6>Czy zawiera - fn:contains</h6>
            <c:if test="${fn:contains(lorem, 'Lorem')}">
                <p>
                    Zmienna <c:out value="lorem"/> zawiera ciąg 'Lorem'.
                </p>
            </c:if>

            <h6>Wszystko małymi literami</h6>
            <p>
                <c:out value="${fn:toLowerCase(lorem)}"/>
            </p>

        </div>
        <div class="col-md-4">
            <h3>Trochę egzotyki - obsługa XML</h3>
            
            <%--
                Definiujemy zmienną, która zawiera tekst będący XML-em
            --%>
            <c:set var="someXML">
                <students>
                    <student>
                        <firstName>Jan</firstName>
                        <lastName>Kowalski</lastName>
                    </student>
                    <student>
                        <firstName>Janina</firstName>
                        <lastName>Kowalska</lastName>
                    </student>
                </students>
            </c:set>
            
            <p>Parsowanie XML-a i dostęp do zmiennej:</p>
            <%-- 
                parametr xml wskazuje plik XML, parametr var
                wskazuje nazwę zmiennej, w której ma się znaleźć wynik
            --%>
            <x:parse xml="${someXML}" var="outputVariable"/>
            <p>Pierwszy student:</p>
            <x:out select="$outputVariable/students/student[1]/firstName"/>

        </div>
        <div class="col-md-4">

        </div>
    </div>
</div>

</body>
</html>
