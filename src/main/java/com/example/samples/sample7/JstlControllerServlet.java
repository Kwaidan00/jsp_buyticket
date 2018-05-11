/*
 * Aleksander Spyra for Software Development Academy, Wroclaw 2018
 */

/*
 * Aleksander Spyra for Software Development Academy, Wroclaw 2018
 */

package com.example.samples.sample7;

import com.example.samples.sample3.Student;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "JstlControllerServlet", value = {"/sample7/jstl-samples"})
public class JstlControllerServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        Student[] students = new Student[]{
                new Student("Grzegorz", "Brzęczyszczkiewicz"),
                new Student("Horst", "Eckert"),
                new Student("Klemens", "Ochrydzki")
        };

        request.setAttribute("student_list", students);

        request.setAttribute("age", 24);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/samples/sample7/jstl-page.jsp");

        dispatcher.forward(request, response);
    }
}
