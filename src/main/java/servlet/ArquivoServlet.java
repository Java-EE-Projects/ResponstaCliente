package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

public class ArquivoServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		OutputStream out = null;
		FileInputStream fis = null;
		
		try {
			
			out = response.getOutputStream();
			response.addHeader("Content-Disposition", "attachment; filename=sistema.zip");
			response.setContentType("application/zip");
			
			fis = new FileInputStream("/Users/lucianomoreiradonascimento/Documents/allSysAlfa.zip");
			
			byte[] buffer = new byte[1024];
			
			int bytesLidos;
			
			while((bytesLidos = fis.read(buffer)) > -1) {
				out.write(buffer, 0, bytesLidos);
			}
			
		} finally {
			if (out != null) {
				out.close();
				
			}
			if (fis != null) {
				fis.close();
			}
		}
	}
}
