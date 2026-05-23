package org.controler;

import java.io.IOException;

import org.model.Patient;

import com.service.PatientService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PatientRegisterServlet
 */
@WebServlet("/registerPatient")
public class PatientRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public PatientRegisterServlet() {
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
		String name = request.getParameter("name");
        String ageStr = request.getParameter("age");
        String gender = request.getParameter("gender");
        String mobile = request.getParameter("mobile");
        String disease = request.getParameter("disease");
        String password = request.getParameter("password");

        int age;
        try {
            age = Integer.parseInt(ageStr);
        } catch (Exception e) {
            response.sendRedirect("patient-register.html");
            return;
        }

        Patient patient = new Patient();
        patient.setName(name);
        patient.setAge(age);
        patient.setGender(gender);
        patient.setMobile(mobile);
        patient.setDisease(disease);
        patient.setPassword(password);

        PatientService service = new PatientService();
        boolean status = service.registerPatient(patient);

        if (status) {
            response.sendRedirect("patient-login.html");
        } else {
            response.sendRedirect("patient-register.html");
        }
    }
}
