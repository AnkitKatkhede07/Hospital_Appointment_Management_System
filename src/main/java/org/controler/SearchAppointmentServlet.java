package org.controler;

import jakarta.servlet.ServletException;
import com.service.AppointmentService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.model.Appointment;


/**
 * Servlet implementation class SearchAppointmentServlet
 */
@WebServlet("/searchAppointment")
public class SearchAppointmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchAppointmentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String keyword = request.getParameter("keyword");

		AppointmentService service = new AppointmentService();
		List<Appointment> list = service.searchAppointments(keyword);

		response.setContentType("text/html");

		PrintWriter out = response.getWriter();

		out.println("<!DOCTYPE html>");
		out.println("<html lang='en'>");

		out.println("<head>");

		out.println("<meta charset='UTF-8'>");
		out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");

		out.println("<title>Appointment Search Result</title>");

		out.println("<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css' rel='stylesheet'>");

		out.println("<script src='https://unpkg.com/lucide@latest'></script>");

		out.println("<style>");

		out.println("body{");
		out.println("background:linear-gradient(135deg,#eef4ff,#ffffff,#f5f8ff);");
		out.println("font-family:'Segoe UI',sans-serif;");
		out.println("min-height:100vh;");
		out.println("padding:40px 20px;");
		out.println("}");

		out.println(".main-card{");
		out.println("background:rgba(255,255,255,0.9);");
		out.println("backdrop-filter:blur(18px);");
		out.println("border-radius:30px;");
		out.println("padding:40px;");
		out.println("box-shadow:0 20px 60px rgba(15,23,42,0.08);");
		out.println("}");

		out.println(".top-badge{");
		out.println("display:inline-flex;");
		out.println("align-items:center;");
		out.println("gap:8px;");
		out.println("background:#dbeafe;");
		out.println("color:#2563eb;");
		out.println("padding:10px 18px;");
		out.println("border-radius:999px;");
		out.println("font-weight:700;");
		out.println("margin-bottom:20px;");
		out.println("}");

		out.println(".main-title{");
		out.println("font-size:3rem;");
		out.println("font-weight:900;");
		out.println("color:#0f172a;");
		out.println("margin-bottom:10px;");
		out.println("}");

		out.println(".main-title span{");
		out.println("background:linear-gradient(135deg,#2563eb,#7c3aed);");
		out.println("-webkit-background-clip:text;");
		out.println("-webkit-text-fill-color:transparent;");
		out.println("}");

		out.println(".subtitle{");
		out.println("color:#64748b;");
		out.println("margin-bottom:35px;");
		out.println("font-size:1.05rem;");
		out.println("}");

		out.println(".table-box{");
		out.println("overflow-x:auto;");
		out.println("}");

		out.println(".custom-table{");
		out.println("border-radius:20px;");
		out.println("overflow:hidden;");
		out.println("background:white;");
		out.println("}");

		out.println(".custom-table thead{");
		out.println("background:linear-gradient(135deg,#2563eb,#7c3aed);");
		out.println("color:white;");
		out.println("}");

		out.println(".custom-table th{");
		out.println("padding:18px !important;");
		out.println("font-size:15px;");
		out.println("}");

		out.println(".custom-table td{");
		out.println("padding:18px !important;");
		out.println("vertical-align:middle;");
		out.println("}");

		out.println(".custom-table tbody tr:hover{");
		out.println("background:#f8fbff;");
		out.println("}");

		out.println(".status-approved{");
		out.println("background:#dcfce7;");
		out.println("color:#166534;");
		out.println("padding:8px 14px;");
		out.println("border-radius:999px;");
		out.println("font-weight:700;");
		out.println("}");

		out.println(".status-pending{");
		out.println("background:#fef3c7;");
		out.println("color:#92400e;");
		out.println("padding:8px 14px;");
		out.println("border-radius:999px;");
		out.println("font-weight:700;");
		out.println("}");

		out.println(".status-rejected{");
		out.println("background:#fee2e2;");
		out.println("color:#991b1b;");
		out.println("padding:8px 14px;");
		out.println("border-radius:999px;");
		out.println("font-weight:700;");
		out.println("}");

		out.println(".back-btn{");
		out.println("display:inline-block;");
		out.println("margin-top:35px;");
		out.println("padding:14px 28px;");
		out.println("border-radius:16px;");
		out.println("background:linear-gradient(135deg,#2563eb,#7c3aed);");
		out.println("color:white;");
		out.println("text-decoration:none;");
		out.println("font-weight:700;");
		out.println("transition:0.3s;");
		out.println("}");

		out.println(".back-btn:hover{");
		out.println("transform:translateY(-3px);");
		out.println("color:white;");
		out.println("}");

		out.println("</style>");

		out.println("</head>");

		out.println("<body>");

		out.println("<div class='container'>");

		out.println("<div class='main-card'>");

		out.println("<div class='text-center'>");

		out.println("<div class='top-badge'>");
		out.println("<i data-lucide='calendar-search'></i>");
		out.println("Appointment Search Results");
		out.println("</div>");

		out.println("<h1 class='main-title'>Appointment <span>Records</span></h1>");

		out.println("<p class='subtitle'>");
		out.println("View all appointment details and status information.");
		out.println("</p>");

		out.println("</div>");

		out.println("<div class='table-box'>");

		out.println("<table class='table custom-table align-middle'>");

		out.println("<thead>");
		out.println("<tr>");
		out.println("<th>ID</th>");
		out.println("<th>Patient ID</th>");
		out.println("<th>Doctor ID</th>");
		out.println("<th>Appointment Date</th>");
		out.println("<th>Status</th>");
		out.println("</tr>");
		out.println("</thead>");

		out.println("<tbody>");

		for (Appointment a : list) {

		    String statusClass = "status-pending";

		    if(a.getStatus().equalsIgnoreCase("approved")){
		        statusClass = "status-approved";
		    }

		    else if(a.getStatus().equalsIgnoreCase("rejected")){
		        statusClass = "status-rejected";
		    }

		    out.println("<tr>");

		    out.println("<td><strong>" + a.getId() + "</strong></td>");

		    out.println("<td>" + a.getPatientId() + "</td>");

		    out.println("<td>" + a.getDoctorId() + "</td>");

		    out.println("<td>" + a.getAppointmentDate() + "</td>");

		    out.println("<td>");
		    out.println("<span class='" + statusClass + "'>");
		    out.println(a.getStatus());
		    out.println("</span>");
		    out.println("</td>");

		    out.println("</tr>");
		}

		out.println("</tbody>");

		out.println("</table>");

		out.println("</div>");

		out.println("<div class='text-center'>");

		out.println("<a href='admin-dashboard.html' class='back-btn'>");
		out.println("← Back to Dashboard");
		out.println("</a>");

		out.println("</div>");

		out.println("</div>");

		out.println("</div>");

		out.println("<script>");
		out.println("lucide.createIcons();");
		out.println("</script>");

		out.println("</body>");

		out.println("</html>");
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
