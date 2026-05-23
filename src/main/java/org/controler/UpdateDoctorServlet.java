package org.controler;

import java.io.IOException;

import org.model.Doctor;

import com.service.DoctorService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class UpdateDoctorServlet
 */
@WebServlet("/updateDoctor")
public class UpdateDoctorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateDoctorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String specialization = request.getParameter("specialization");
        String mobile = request.getParameter("mobile");
        String email = request.getParameter("email");
        double fees = Double.parseDouble(request.getParameter("fees"));

        Doctor doctor = new Doctor();
        doctor.setId(id);
        doctor.setName(name);
        doctor.setSpecialization(specialization);
        doctor.setMobile(mobile);
        doctor.setEmail(email);
        doctor.setFees(fees);

        DoctorService service = new DoctorService();
        boolean status = service.updateDoctor(doctor);

        if (status) {
            response.sendRedirect("viewDoctors");
        } else {
            response.getWriter().println("<h2>Failed To Update Doctor</h2>");
        }
    }
	}


