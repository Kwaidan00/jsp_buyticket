/*
 * Aleksander Spyra for Software Development Academy, Wroclaw 2018
 */

package com.example.samples.sample5;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Prosty serwlet, który pokazuje, w jaki sposób utworzyć obiekt ciasteczka, jak je wysłać
 * do przeglądarki oraz jak wyświetlić ciasteczka.
 */
@WebServlet(name = "CookieServlet", value = {"/sample5/cookie-servlet"})
public class CookieServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        // Tworzymy swoje pierwsze ciasteczko i dodajemy do odpowiedzi
        String cookieName = "MyCookie";
        String cookieValue = "2000";

        Cookie myCookie = new Cookie(cookieName, cookieValue);
        // Ustawiamy długość życia ciasteczka (w sekundach)
        // wpisanie 0 powoduje usunięcie ciasteczka
        myCookie.setMaxAge(60);
        response.addCookie(myCookie);

        // Pobieramy wszystkie istniejące ciasteczka
        Cookie[] cookies = request.getCookies();

        out.println("<!doctype html>");
        out.println("<html lang=\"pl\">");
        out.println("  <head>");
        out.println("    <meta charset=\"utf-8\">");
        out.println("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">");
        out.println("    <!-- Bootstrap CSS -->");
        out.println("    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">");
        out.println("    <title>Strona z ciasteczkami</title>");
        out.println("  </head>");
        out.println("  <body>");
        out.println("  <div class=\"container\">");
        out.println("    <div class=\"row\">");
        out.println("       <div class=\"col-md-4\"></div>");
        out.println("       <div class=\"col-md-4\">");
        out.println("          <h2>Na tej stronie używamy ciasteczek</h2>");
        out.println("       </div>");
        out.println("       <div class=\"col-md-4\">");
        out.println("       <table><tr><td>Nazwa</td><td>Wartość</td></tr>");
        // Wyświetlenie wszystkich ciasteczek
        for (Cookie cookie : cookies){
            String name = cookie.getName();
            String value = cookie.getValue();
            out.println("<tr><td>" + name + "</td><td>" + value + "</td></tr>");
        }
        out.println("           </table>");
        out.println("       </div>");
        out.println("    </div>");
        out.println("  </div>");
        out.println("  </body>");
        out.println("</html>");

    }
}
