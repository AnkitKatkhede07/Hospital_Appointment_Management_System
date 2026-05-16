package org.controler;

import jakarta.servlet.ServletException;
import com.service.DoctorService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import org.model.Doctor;


/**
 * Servlet implementation class EditDoctorServlet
 */
@WebServlet("/editDoctor")
public class EditDoctorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditDoctorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));

		DoctorService service = new DoctorService();
		Doctor doctor = service.getDoctorById(id);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        if (doctor != null) {
            out.println("<html><body>");
            out.println("<h1>Edit Doctor</h1>");
            out.println("<form action='updateDoctor' method='post'>");

            out.println("<input type='hidden' name='id' value='" + doctor.getId() + "'>");

            out.println("Name: <input type='text' name='name' value='" + doctor.getName() + "'><br><br>");
            out.println("Specialization: <input type='text' name='specialization' value='" + doctor.getSpecialization() + "'><br><br>");
            out.println("Mobile: <input type='text' name='mobile' value='" + doctor.getMobile() + "'><br><br>");
            out.println("Email: <input type='email' name='email' value='" + doctor.getEmail() + "'><br><br>");
            out.println("Fees: <input type='number' name='fees' value='" + doctor.getFees() + "'><br><br>");

            out.println("<button type='submit'>Update Doctor</button>");
            out.println("</form>");
            out.println("</body></html>");
        } else {
            out.println("<h2>Doctor not found</h2>");
        }
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
