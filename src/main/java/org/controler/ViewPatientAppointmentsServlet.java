package org.controler;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.model.Appointment;

import com.service.AppointmentService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


/**
 * Servlet implementation class ViewPatientAppointmentsServlet
 */
@WebServlet("/myAppointments")
public class ViewPatientAppointmentsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewPatientAppointmentsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 HttpSession session = request.getSession(false);

	        if (session == null || session.getAttribute("patientId") == null) {
	            response.sendRedirect("patient-login.html");
	            return;
	        }

	        int patientId = (int) session.getAttribute("patientId");

	        AppointmentService service = new AppointmentService();
	        List<Appointment> list = service.getAppointmentsByPatientId(patientId);

	        response.setContentType("text/html");

	        PrintWriter out = response.getWriter();

	        out.println("<!DOCTYPE html>");

	        out.println("<html>");

	        out.println("<head>");

	        out.println("<title>My Appointments</title>");

	        out.println("<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css' rel='stylesheet'>");

	        out.println("<style>");

	        out.println("body{");
	        out.println("background:linear-gradient(135deg,#eef4ff,#f8fbff,#f5f8ff);");
	        out.println("font-family:'Segoe UI',sans-serif;");
	        out.println("padding:40px;");
	        out.println("}");

	        out.println(".main-box{");
	        out.println("max-width:1200px;");
	        out.println("margin:auto;");
	        out.println("}");

	        out.println(".top-card{");
	        out.println("background:white;");
	        out.println("padding:35px;");
	        out.println("border-radius:25px;");
	        out.println("box-shadow:0 10px 30px rgba(0,0,0,0.08);");
	        out.println("margin-bottom:25px;");
	        out.println("}");

	        out.println(".title{");
	        out.println("font-size:48px;");
	        out.println("font-weight:800;");
	        out.println("color:#0f172a;");
	        out.println("}");

	        out.println(".title span{");
	        out.println("color:#2563eb;");
	        out.println("}");

	        out.println(".sub{");
	        out.println("color:#64748b;");
	        out.println("margin-top:10px;");
	        out.println("}");

	        out.println(".table-card{");
	        out.println("background:white;");
	        out.println("padding:30px;");
	        out.println("border-radius:25px;");
	        out.println("box-shadow:0 10px 30px rgba(0,0,0,0.08);");
	        out.println("}");

	        out.println(".table thead{");
	        out.println("background:linear-gradient(90deg,#2563eb,#3b82f6);");
	        out.println("color:white;");
	        out.println("}");

	        out.println(".table th{");
	        out.println("padding:16px;");
	        out.println("border:none;");
	        out.println("}");

	        out.println(".table td{");
	        out.println("padding:16px;");
	        out.println("vertical-align:middle;");
	        out.println("}");

	        out.println(".table tbody tr:hover{");
	        out.println("background:#f8fbff;");
	        out.println("}");

	        out.println(".approved{");
	        out.println("background:#dcfce7;");
	        out.println("color:#166534;");
	        out.println("padding:7px 14px;");
	        out.println("border-radius:50px;");
	        out.println("font-size:13px;");
	        out.println("font-weight:700;");
	        out.println("}");

	        out.println(".pending{");
	        out.println("background:#fef3c7;");
	        out.println("color:#92400e;");
	        out.println("padding:7px 14px;");
	        out.println("border-radius:50px;");
	        out.println("font-size:13px;");
	        out.println("font-weight:700;");
	        out.println("}");

	        out.println(".rejected{");
	        out.println("background:#fee2e2;");
	        out.println("color:#991b1b;");
	        out.println("padding:7px 14px;");
	        out.println("border-radius:50px;");
	        out.println("font-size:13px;");
	        out.println("font-weight:700;");
	        out.println("}");

	        out.println(".back-btn{");
	        out.println("display:inline-block;");
	        out.println("margin-top:25px;");
	        out.println("padding:12px 30px;");
	        out.println("background:linear-gradient(90deg,#2563eb,#3b82f6);");
	        out.println("color:white;");
	        out.println("text-decoration:none;");
	        out.println("border-radius:12px;");
	        out.println("font-weight:600;");
	        out.println("}");

	        out.println("</style>");

	        out.println("</head>");

	        out.println("<body>");

	        out.println("<div class='main-box'>");

	        out.println("<div class='top-card'>");

	        out.println("<h1 class='title'>My <span>Appointments</span></h1>");

	        out.println("<p class='sub'>View all your appointment records and status updates.</p>");

	        out.println("</div>");

	        out.println("<div class='table-card'>");

	        out.println("<div class='table-responsive'>");

	        out.println("<table class='table'>");

	        out.println("<thead>");

	        out.println("<tr>");

	        out.println("<th>Sr.No</th>");
	        out.println("<th>ID</th>");
	        out.println("<th>Patient ID</th>");
	        out.println("<th>Doctor ID</th>");
	        out.println("<th>Date</th>");
	        out.println("<th>Status</th>");

	        out.println("</tr>");

	        out.println("</thead>");

	        out.println("<tbody>");

	        int srNo = 1;

	        for (Appointment a : list) {

	            String statusClass = "pending";

	            if(a.getStatus().equalsIgnoreCase("Approved")){
	                statusClass = "approved";
	            }

	            else if(a.getStatus().equalsIgnoreCase("Rejected")){
	                statusClass = "rejected";
	            }

	            out.println("<tr>");

	            out.println("<td>" + srNo + "</td>");

	            out.println("<td><strong>#" + a.getId() + "</strong></td>");

	            out.println("<td>" + a.getPatientId() + "</td>");

	            out.println("<td>" + a.getDoctorId() + "</td>");

	            out.println("<td>" + a.getAppointmentDate() + "</td>");

	            out.println("<td><span class='" + statusClass + "'>"
	                    + a.getStatus() + "</span></td>");

	            out.println("</tr>");

	            srNo++;
	        }

	        out.println("</tbody>");

	        out.println("</table>");

	        out.println("</div>");

	        out.println("<a href='patient-dashboard.html' class='back-btn'>Back Dashboard</a>");

	        out.println("</div>");

	        out.println("</div>");

	        out.println("</body>");

	        out.println("</html>");
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
