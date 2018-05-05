/*
 * Aleksander Spyra for Software Development Academy, Wroclaw 2018
 */

package com.example.samples.sample3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * Jedynym celem tego serwletu jest wylistowanie wszystkich parametrów żądania.
 * Robi to zarówno dla metody GET, jak i POST.
 */
@WebServlet(name = "FormHandlerServlet", value = {"/sample3/form-handler-servlet"})
public class FormHandlerServlet extends HttpServlet {

    private void printParameters(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String method = request.getMethod();

        out.println("Metoda: " + method);
        out.println("Parametry: ");
        Enumeration parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String parameterName = (String) parameterNames.nextElement();
            String parameterValue = (String) request.getParameter(parameterName);
            out.println("\t" + parameterName + " = " + parameterValue);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        printParameters(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        printParameters(request, response);
    }

}
