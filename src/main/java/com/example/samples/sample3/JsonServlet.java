/*
 * Aleksander Spyra for Software Development Academy, Wroclaw 2018
 */

package com.example.samples.sample3;

import org.json.JSONArray;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "JsonServlet", value = {"/sample3/json-servlet"})
public class JsonServlet extends HttpServlet {

    private Student[] students = new Student[]{
            new Student("Grzegorz", "Brzęczyszczkiewicz"),
            new Student("Horst", "Eckert"),
            new Student("Klemens", "Ochrydzki")
    };

    /**
     * Proste wyszukiwanie liniowe.
     * @param name ciąg do wyszukania
     * @return JSONObject znalezionego studenta lub pusty JSONObject.
     */
    private JSONObject getStudentJsonByName(String name) {
        for (Student student : students) {
            if (student.getFirstName().equals(name)) {
                return student.toJson();
            }
        }
        return new JSONObject();
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    /**
     * Chcemy następującą funkcjonalność:
     * 1. Gdy użytkownik wyśle żądanie GET na adres http://localhost:8080/sample3/json-servlet
     *    (bez parametru), to dostanie JSON-a z tablicą wszystkich studentów z tablicy students;
     * 2. Gdy użytkownik wyśle żadanie GET na adres http://localhost:8080/sample3/json-servlet?name=Grzegorz
     *    (z parametrem), wyszukany zostanie student o takim imieniu. Jeśli istnieje w tablicy student o takim imieniu,
     *    użytkownik dostanie JSON-a reprezentującego tego studenta. Jeśli nie istnieje, otrzyma pusty JSON.
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
         * Ustawiamy typ MIME odpowiedzi na JSON oraz kodowanie na UTF-8,
         * zgodnie ze specyfikacją JSON-a (http://www.ietf.org/rfc/rfc4627.txt)
         */
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        JSONObject json = new JSONObject();

        /*
         * Pobierany jest parametr, na podstawie którego chcemy wyszukać obiekty w bazie.
         * Metoda request.getParameter() zwraca null, jeśli parametr o podanej nazwie nie znajduje
         * się w żądaniu.
         * https://docs.oracle.com/javaee/6/api/javax/servlet/ServletRequest.html#getParameter(java.lang.String)
         */
        String searchName = request.getParameter("name");
        if (searchName != null) {
            json = getStudentJsonByName(searchName);
        } else {
            JSONArray array = new JSONArray();
            for (Student student : students) {
                array.put(student.toJson());
            }
            json.put("students", array);
        }

        out.print(json.toString());
    }

}
