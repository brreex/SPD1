package cs544.spd1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

public class StudentsCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String studentIdStr = request.getParameter("studentid");

		long studentid = -1;
		Student student = null;

		if (studentIdStr != null && studentIdStr.matches("\\d+")) {
			studentid = Long.parseLong(studentIdStr);
			
			WebApplicationContext context = ContextLoader.getCurrentWebApplicationContext();
			
			StudentService studentService = context.getBean("studentService",StudentService.class);
			student = studentService.getStudent(studentid);
			
			//context.close();
		}

		request.setAttribute("student", student);
		request.getRequestDispatcher("student.jsp").forward(request, response);

	}

}
