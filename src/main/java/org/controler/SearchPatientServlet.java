package org.controler;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.model.Patient;

import com.service.PatientService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class SearchPatientServlet
 */
@WebServlet("/searchPatient")
public class SearchPatientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchPatientServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String keyword = request.getParameter("keyword");

		PatientService service = new PatientService();
		List<Patient> list = service.searchPatients(keyword);

		response.setContentType("text/html");

		PrintWriter out = response.getWriter();

		out.println("<!DOCTYPE html>");

		out.println("<html>");

		out.println("<head>");

		out.println("<title>Search Patients</title>");

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
		out.println("font-size:45px;");
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

		out.println(".disease-box{");
		out.println("background:#eff6ff;");
		out.println("color:#2563eb;");
		out.println("padding:7px 14px;");
		out.println("border-radius:50px;");
		out.println("font-size:13px;");
		out.println("font-weight:600;");
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

		out.println("<h1 class='title'>Search <span>Patients</span></h1>");

		out.println("<p class='sub'>Hospital patient records and details.</p>");

		out.println("</div>");

		out.println("<div class='table-card'>");

		out.println("<div class='table-responsive'>");

		out.println("<table class='table'>");

		out.println("<thead>");

		out.println("<tr>");

		out.println("<th>Sr No</th>");
		out.println("<th>ID</th>");
		out.println("<th>Name</th>");
		out.println("<th>Age</th>");
		out.println("<th>Gender</th>");
		out.println("<th>Mobile</th>");
		out.println("<th>Disease</th>");

		out.println("</tr>");

		out.println("</thead>");

		out.println("<tbody>");

		int srNo = 1;

		for (Patient p : list) {

		    out.println("<tr>");

		    out.println("<td><strong>" + srNo++ + "</td>");

		    out.println("<td><strong>#" + p.getId() + "</strong></td>");

		    out.println("<td><strong>" + p.getName() + "</strong></td>");

		    out.println("<td>" + p.getAge() + "</td>");

		    out.println("<td>" + p.getGender() + "</td>");

		    out.println("<td>" + p.getMobile() + "</td>");

		    out.println("<td><span class='disease-box'>"
		    + p.getDisease() + "</span></td>");

		    out.println("</tr>");
		}

		out.println("</tbody>");

		out.println("</table>");

		out.println("</div>");

		out.println("<a href='admin-dashboard.html' class='back-btn'>Back Dashboard</a>");

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
