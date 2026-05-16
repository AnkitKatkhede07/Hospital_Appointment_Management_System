package org.controler;

import jakarta.servlet.ServletException;
import com.service.DoctorService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.model.Doctor;


/**
 * Servlet implementation class SearchDoctorServlet
 */
@WebServlet("/searchDoctor")
public class SearchDoctorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchDoctorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String keyword = request.getParameter("keyword");

		DoctorService service = new DoctorService();
		List<Doctor> list = service.searchDoctors(keyword);

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<!DOCTYPE html>");
		out.println("<html lang='en'>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
		out.println("<title>Search Doctors</title>");
		out.println("<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css' rel='stylesheet'>");
		out.println("<script src='https://unpkg.com/lucide@latest'></script>");

		out.println("<style>");
		out.println("body{background:linear-gradient(135deg,#eef4ff,#f8fbff,#f5f8ff);font-family:'Segoe UI',sans-serif;min-height:100vh;padding:40px 20px;}");
		out.println(".main-box{max-width:1200px;margin:auto;}");
		out.println(".top-card{background:rgba(255,255,255,0.85);backdrop-filter:blur(18px);border-radius:30px;padding:40px;box-shadow:0 20px 40px rgba(0,0,0,0.08);margin-bottom:30px;}");
		out.println(".badge-box{display:inline-flex;align-items:center;gap:8px;background:rgba(37,99,235,0.12);color:#2563eb;padding:10px 18px;border-radius:50px;font-weight:600;margin-bottom:20px;}");
		out.println(".title{font-size:55px;font-weight:800;color:#0f172a;}");
		out.println(".title span{background:linear-gradient(90deg,#2563eb,#7c3aed);-webkit-background-clip:text;-webkit-text-fill-color:transparent;}");
		out.println(".subtitle{color:#64748b;font-size:18px;margin-top:10px;}");
		out.println(".table-card{background:rgba(255,255,255,0.88);backdrop-filter:blur(18px);border-radius:30px;padding:30px;box-shadow:0 20px 40px rgba(0,0,0,0.08);}");
		out.println(".table{overflow:hidden;border-radius:20px;}");
		out.println(".table thead{background:linear-gradient(90deg,#2563eb,#7c3aed);color:white;}");
		out.println(".table th{border:none;padding:18px;font-size:15px;}");
		out.println(".table td{padding:18px;vertical-align:middle;border-color:#e2e8f0;}");
		out.println(".table tbody tr:hover{background:#f8fbff;}");
		out.println(".special-box{background:#eff6ff;color:#2563eb;padding:8px 14px;border-radius:50px;font-size:13px;font-weight:600;}");
		out.println(".fees-box{background:#ecfdf5;color:#059669;padding:8px 14px;border-radius:50px;font-size:13px;font-weight:700;}");
		out.println(".back-btn{background:linear-gradient(90deg,#2563eb,#3b82f6);border:none;padding:14px 35px;border-radius:14px;color:white;text-decoration:none;font-weight:600;display:inline-block;margin-top:25px;transition:0.3s;}");
		out.println(".back-btn:hover{transform:translateY(-3px);box-shadow:0 10px 20px rgba(37,99,235,0.25);color:white;}");
		out.println("</style>");

		out.println("</head>");
		out.println("<body>");

		out.println("<div class='main-box'>");
		out.println("<div class='top-card'>");
		out.println("<div class='badge-box'><i data-lucide='stethoscope'></i>Doctor Search Results</div>");
		out.println("<h1 class='title'>Hospital <span>Doctors</span></h1>");
		out.println("<p class='subtitle'>Search doctors by specialization and consultation details.</p>");
		out.println("</div>");

		out.println("<div class='table-card'>");
		out.println("<div class='table-responsive'>");
		out.println("<table class='table align-middle'>");
		out.println("<thead><tr><th>Sr No</th><th>ID</th><th>Name</th><th>Specialization</th><th>Mobile</th><th>Email</th><th>Fees</th></tr></thead>");
		out.println("<tbody>");
		int srNo = 1;
		if (list == null || list.isEmpty()) {
		    out.println("<tr><td colspan='6' class='text-center py-4'>No doctors found</td></tr>");
		} else {
		    for (Doctor d : list) {
		        out.println("<tr>");
		        out.println("<td><strong>" + srNo++ + "</td>");
		        out.println("<td><strong>#" + d.getId() + "</strong></td>");
		        out.println("<td><strong>" + d.getName() + "</strong></td>");
		        out.println("<td><span class='special-box'>" + d.getSpecialization() + "</span></td>");
		        out.println("<td>" + d.getMobile() + "</td>");
		        out.println("<td>" + d.getEmail() + "</td>");
		        out.println("<td><span class='fees-box'>₹ " + d.getFees() + "</span></td>");
		        out.println("</tr>");
		    }
		}

		out.println("</tbody>");
		out.println("</table>");
		out.println("</div>");
		out.println("<a href='patient-dashboard.html' class='back-btn'>Back Dashboard</a>");
		out.println("</div>");
		out.println("</div>");

		out.println("<script>lucide.createIcons();</script>");
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
