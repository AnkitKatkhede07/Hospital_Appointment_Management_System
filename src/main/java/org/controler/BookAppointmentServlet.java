package org.controler;

import jakarta.servlet.ServletException;
import com.service.AppointmentService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import org.model.Appointment;

/**
 * Servlet implementation class BookAppointmentServlet
 */
@WebServlet("/bookAppointment")
public class BookAppointmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BookAppointmentServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);

		if (session == null || session.getAttribute("patientId") == null) {
			response.sendRedirect("patient-login.html");
			return;
		}

		int patientId = (int) session.getAttribute("patientId");
		int doctorId = Integer.parseInt(request.getParameter("doctorId"));
		Date appointmentDate = Date.valueOf(request.getParameter("appointmentDate"));

		Appointment appt = new Appointment();
		appt.setPatientId(patientId);
		appt.setDoctorId(doctorId);
		appt.setAppointmentDate(appointmentDate);
		appt.setStatus("Pending");

		AppointmentService service = new AppointmentService();
		boolean status = service.bookAppointment(appt);

		if (status) {
			response.setContentType("text/html");

			PrintWriter out = response.getWriter();

			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");

			out.println("<title>Appointment Success</title>");

			out.println(
					"<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css' rel='stylesheet'>");

			out.println("<style>");

			out.println("body{");
			out.println("margin:0;");
			out.println("height:100vh;");
			out.println("display:flex;");
			out.println("justify-content:center;");
			out.println("align-items:center;");
			out.println("background:linear-gradient(135deg,#eef4ff,#ffffff,#f3f6ff);");
			out.println("font-family:'Segoe UI',sans-serif;");
			out.println("}");

			out.println(".success-card{");
			out.println("width:520px;");
			out.println("background:white;");
			out.println("border-radius:30px;");
			out.println("padding:50px 40px;");
			out.println("text-align:center;");
			out.println("box-shadow:0 20px 50px rgba(37,99,235,0.15);");
			out.println("}");

			out.println(".success-icon{");
			out.println("width:90px;");
			out.println("height:90px;");
			out.println("margin:auto;");
			out.println("border-radius:50%;");
			out.println("display:flex;");
			out.println("align-items:center;");
			out.println("justify-content:center;");
			out.println("font-size:40px;");
			out.println("background:linear-gradient(135deg,#10b981,#059669);");
			out.println("color:white;");
			out.println("}");

			out.println(".success-title{");
			out.println("margin-top:30px;");
			out.println("font-size:2.2rem;");
			out.println("font-weight:800;");
			out.println("color:#0f172a;");
			out.println("}");

			out.println(".success-text{");
			out.println("margin-top:15px;");
			out.println("color:#64748b;");
			out.println("font-size:1.05rem;");
			out.println("line-height:1.8;");
			out.println("}");

			out.println(".status-badge{");
			out.println("display:inline-block;");
			out.println("margin-top:20px;");
			out.println("padding:10px 22px;");
			out.println("border-radius:999px;");
			out.println("background:#fef3c7;");
			out.println("color:#d97706;");
			out.println("font-weight:700;");
			out.println("}");

			out.println(".btn-dashboard{");
			out.println("margin-top:35px;");
			out.println("padding:14px 30px;");
			out.println("border-radius:14px;");
			out.println("text-decoration:none;");
			out.println("color:white;");
			out.println("font-weight:700;");
			out.println("background:linear-gradient(135deg,#2563eb,#4f46e5);");
			out.println("display:inline-block;");
			out.println("}");

			out.println("</style>");

			out.println("</head>");

			out.println("<body>");

			out.println("<div class='success-card'>");

			out.println("<div class='success-icon'>✓</div>");

			out.println("<h1 class='success-title'>Appointment Booked!</h1>");

			out.println("<p class='success-text'>");
			out.println("Your appointment request has been submitted successfully.");
			out.println("Please wait for admin approval.");
			out.println("</p>");

			out.println("<div class='status-badge'>Status : Pending</div>");

			out.println("<br>");

			out.println("<a href='patient-dashboard.html' class='btn-dashboard'>");
			out.println("Back To Dashboard");
			out.println("</a>");

			out.println("</div>");

			out.println("</body>");
			out.println("</html>");
		}

		else {

			response.setContentType("text/html");

			PrintWriter out = response.getWriter();

			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");

			out.println("<title>Appointment Failed</title>");

			out.println(
					"<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css' rel='stylesheet'>");

			out.println("<style>");

			out.println("body{");
			out.println("margin:0;");
			out.println("height:100vh;");
			out.println("display:flex;");
			out.println("justify-content:center;");
			out.println("align-items:center;");
			out.println("background:linear-gradient(135deg,#fff1f2,#ffffff,#ffe4e6);");
			out.println("font-family:'Segoe UI',sans-serif;");
			out.println("}");

			out.println(".fail-card{");
			out.println("width:520px;");
			out.println("background:white;");
			out.println("border-radius:30px;");
			out.println("padding:50px 40px;");
			out.println("text-align:center;");
			out.println("box-shadow:0 20px 50px rgba(239,68,68,0.15);");
			out.println("}");

			out.println(".fail-icon{");
			out.println("width:90px;");
			out.println("height:90px;");
			out.println("margin:auto;");
			out.println("border-radius:50%;");
			out.println("display:flex;");
			out.println("align-items:center;");
			out.println("justify-content:center;");
			out.println("font-size:40px;");
			out.println("background:linear-gradient(135deg,#ef4444,#dc2626);");
			out.println("color:white;");
			out.println("}");

			out.println(".fail-title{");
			out.println("margin-top:30px;");
			out.println("font-size:2.2rem;");
			out.println("font-weight:800;");
			out.println("color:#0f172a;");
			out.println("}");

			out.println(".fail-text{");
			out.println("margin-top:15px;");
			out.println("color:#64748b;");
			out.println("font-size:1.05rem;");
			out.println("line-height:1.8;");
			out.println("}");

			out.println(".btn-back{");
			out.println("margin-top:35px;");
			out.println("padding:14px 30px;");
			out.println("border-radius:14px;");
			out.println("text-decoration:none;");
			out.println("color:white;");
			out.println("font-weight:700;");
			out.println("background:linear-gradient(135deg,#ef4444,#dc2626);");
			out.println("display:inline-block;");
			out.println("}");

			out.println("</style>");

			out.println("</head>");

			out.println("<body>");

			out.println("<div class='fail-card'>");

			out.println("<div class='fail-icon'>✕</div>");

			out.println("<h1 class='fail-title'>Booking Failed!</h1>");

			out.println("<p class='fail-text'>");
			out.println("Unable to book appointment right now.");
			out.println("Please check doctor ID or try again later.");
			out.println("</p>");

			out.println("<a href='book-appointment.html' class='btn-back'>");
			out.println("Try Again");
			out.println("</a>");

			out.println("</div>");

			out.println("</body>");
			out.println("</html>");
		}
	}
}
