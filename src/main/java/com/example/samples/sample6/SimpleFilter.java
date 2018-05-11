/*
 * Aleksander Spyra for Software Development Academy, Wroclaw 2018
 */

package com.example.samples.sample6;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;
import java.util.Enumeration;

/**
 * Prosty filtr konfigurowany za pomocą adnotacji.
 * Filtry można podpinać albo pod konkretne strony poprzez użycie w adnotacji
 * servletNames = {"NazwaSerwletu1", "NazwaServletu2", ...}
 * albo poprzez podanie wzorca URL:
 * urlPatterns = {"/sample5", "/sample6", ...}
 */
// @WebFilter(filterName = "SimpleFilter", urlPatterns = {"/"})
@WebFilter(filterName = "SimpleFilter", servletNames = {"CookieServlet"})
public class SimpleFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {

        // Logika wykonywana przed logiką serwletu
        String remoteAddress = servletRequest.getRemoteAddr();
        System.out.println(new Date() + " New request from IP: " + remoteAddress);

        /*
         * Wywołanie tej metody spowoduje przekazanie sterowania do kolejnego filtra
         * LUB do serwletu, jeśli nie ma już kolejnych filtrów w łańcuchu.
         * Element obowiązkowy.
         */
        filterChain.doFilter(servletRequest, servletResponse);

        // Logika wykonywana po logice serwletu
        String contentType = servletResponse.getContentType();
        System.out.println(new Date() + " Response was generated as " + contentType);

    }

    @Override
    public void destroy() {

    }
}
