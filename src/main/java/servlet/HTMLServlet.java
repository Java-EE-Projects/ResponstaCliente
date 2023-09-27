package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class HTMLServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = null;
		try {
			out = response.getWriter();			
			response.setContentType("text/html");

			out.print("<HTML>");
			out.print("<HEAD></HEAD>");
			out.print("<BODY>");
			out.print("<H1>Título da Página</H1>");
			out.print("<STRONG>Este é um texto em negrito</H1>");
			out.print("</BODY></HTML>");
			
		} finally {
			if(out != null) {
				out.close();
			}
		}
	}
}
