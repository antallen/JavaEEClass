package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PostBody
 */
@WebServlet("/postbody")
public class PostBody extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<body>");
        out.println(bodyContent(request.getReader()));
        out.println("</body>");
        out.println("</html>");
	}
	private String bodyContent(BufferedReader reader) throws IOException {
        String input = null;
        StringBuilder requestBody = new StringBuilder();
        while((input = reader.readLine()) != null) {
            requestBody.append(input)
                       .append("<br>");
        }
        return requestBody.toString();
    } 

}
