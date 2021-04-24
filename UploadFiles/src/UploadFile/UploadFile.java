package UploadFile;

import java.io.IOException;
import java.time.Instant;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class UploadFile
 */
@MultipartConfig(location="C:\\workspace\\tmp")
@WebServlet(description = "Upload Files", urlPatterns = { "/upload" })

public class UploadFile extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		request.getParts().stream().filter(part->part.getName().startsWith("file")).forEach(this::write);
	}
	private void write(Part part) {
		String submittedFileName = part.getSubmittedFileName();
		String ext = submittedFileName.substring(submittedFileName.lastIndexOf('.'));
		try {
			part.write(String.format("%s%s", Instant.now().toEpochMilli(), ext));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
