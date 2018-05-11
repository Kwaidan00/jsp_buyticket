/*
 * Aleksander Spyra for Software Development Academy, Wroclaw 2018
 */

package com.example.samples.sample4;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SimpleControllerServlet", value = {"/sample4/controller-servlet"})
public class SimpleControllerServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] students = {"Joanna", "Maria", "Anna Maria", "Grzegorz"};
        request.setAttribute("student_list", students);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/samples/sample4/simple-view.jsp");

        dispatcher.forward(request, response);
    }
}
