package eud.mum.cs472wap.lab11;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class SupportServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();
        out.print("<html><head><title>CSTech</title></head><body>");
        out.print("<form method='post'>");

        out.print("<div><label>Name:</label><input type=\"text\" name=\"name\"></input></div>");
        out.print("<div><label>Email Address:</label><input type=\"text\" name=\"email\"></input></div>");
        out.print("<div><label>Problem:</label><input type=\"text\" name=\"problem\"></input></div>");
        out.print("<div><label>Problem Description:</label><textarea name=\"problem-description\"></textarea></div>");

        out.print("<input type=\"submit\" value=\"help\"></input>");
        out.print("</form>");
        out.print("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        ServletContext servletContext = this.getServletContext();
        Random ticketId = new Random();
        String supportTicketId = "CSSP"+ticketId.nextInt();
        PrintWriter out = resp.getWriter();
        out.print("<html><head><title>CSTech</title></head><body>");

        out.print("<p>Thank you! <strong>"+req.getParameter("name")+"</strong> for contacting us.");
        out.print("We should receive reply from us with in 24 hrs in your email address <strong>"+
                req.getParameter("email")+"</strong>.");
        out.print("Let us know in our support email <strong>"+servletContext.getInitParameter("support-email")+
                "</strong> if you don\'t receive reply within 24 hrs.");
        out.print("Please be sure to attach your reference <strong>"+supportTicketId+"</strong> in your email.</p>");

        out.print("</body></html>");
    }
}
