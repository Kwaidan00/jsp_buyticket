/*
 * Aleksander Spyra for Software Development Academy, Wroclaw 2018
 */

package com.example.samples.sample1;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.Date;

/**
 *
 * Deklaracja prostego serwletu.
 *
 * Każdy serwlet dziedziczy po klasie javax.servlet.http.HttpServlet
 * Adnotacja @WebServlet mówi kontenerowi, jak nazywa się ten serwlet (name)
 * oraz jaki adres URL ma mu być przypisany (value).
 */
@WebServlet(name = "SimpleServlet", value = {"/sample1/simple-servlet"})
public class SimpleServlet extends HttpServlet {

    /**
     * Pole zliczające liczbę wizyt.
     * Dzieje się tak, ponieważ serwlety są ładowane przez kontener webowy tylko raz w trakcie pracy serwera.
     */
    private long visitCounter = 0;

    /**
     * Metoda doPost jest wywoływana wtedy, gdy pod adres serwletu (podany wyżej w adnotacji)
     * zostanie wysłane żądanie HTTP POST.
     * W praktyce POST-em wysyłane są dane formularzy.
     *
     * @param request Obiekt żądania - przechowuje wszystko to, co wiemy o żądaniu
     * @param response Obiekt odpowiedzi - tam możemy wwrzucić wszystko, co chcemy odpowiedzieć
     * @throws ServletException Zarówno ten wyjątek, jak i ten poniżej
     * @throws IOException Jest przechwytywany przez kontener webowy
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    /**
     * Metoda doGet jest wywoływana wtedy, gdy pod adres serwletu zostanie wysłane żądanie GET.
     * GET to na przykład zwykłe pobranie strony.
     * W tym przykładzie odpowiadamy wygenerowaniem strony w HTML-u.
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        // Pobranie obecnej daty
        Date today = new Date();

        // Pobranie danych z zewnętrznego API

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


        writer.println("<!doctype html>");
        writer.println("<html lang=\"pl\">");
        writer.println("  <head>");
        writer.println("    <meta charset=\"utf-8\">");
        writer.println("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">");
        writer.println("    <!-- Bootstrap CSS -->");
        writer.println("    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">");
        writer.println("    <title>Strona startowa</title>");
        writer.println("  </head>");
        writer.println("  <body>");
        writer.println("  <div class=\"container\">");
        writer.println("    <div class=\"row\">");
        writer.println("       <div class=\"col-md-4\"></div>");
        writer.println("       <div class=\"col-md-4\">");
        writer.println("          <h2>Witaj w naszym systemie!</h2>");
        writer.println("          <p>Licznik odwiedzin: " + (++visitCounter) + "</p>");
        writer.println("       </div>");
        writer.println("       <div class=\"col-md-4\">");
        writer.println("           <p>Dziś jest: " + today + "</p>");
        writer.println("           <h4>Poziom zanieczyszczeń we Wro:</h4>");
        writer.println("           <p>" + paramName + "</p>");
        writer.println("           <p>Na dzień: " + so2date + "</p>");
        writer.println("           <p>Stan: " + so2index + "</p>");
        writer.println("       </div>");
        writer.println("    </div>");
        writer.println("  </div>");
        writer.println("  </body>");
        writer.println("</html>");

    }
}
