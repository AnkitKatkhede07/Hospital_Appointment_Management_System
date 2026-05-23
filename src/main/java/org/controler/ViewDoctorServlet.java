package org.controler;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.model.Doctor;

import com.service.DoctorService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class ViewDoctorServlet
 */
@WebServlet("/viewDoctors")
public class ViewDoctorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewDoctorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");

		PrintWriter out = response.getWriter();

		DoctorService service = new DoctorService();
		List<Doctor> list = service.getAllDoctors();

		out.println("<!DOCTYPE html>");

		out.println("<html>");

		out.println("<head>");

		out.println("<title>View Doctors</title>");

		out.println("<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css' rel='stylesheet'>");

		out.println("<style>");

		out.println("body{");
		out.println("background:linear-gradient(135deg,#eef4ff,#f8fbff,#f5f8ff);");
		out.println("font-family:'Segoe UI',sans-serif;");
		out.println("padding:40px;");
		out.println("}");

		out.println(".main-box{");
		out.println("max-width:1300px;");
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

		out.println(".special-box{");
		out.println("background:#eff6ff;");
		out.println("color:#2563eb;");
		out.println("padding:7px 14px;");
		out.println("border-radius:50px;");
		out.println("font-size:13px;");
		out.println("font-weight:600;");
		out.println("}");

		out.println(".fees-box{");
		out.println("background:#ecfdf5;");
		out.println("color:#059669;");
		out.println("padding:7px 14px;");
		out.println("border-radius:50px;");
		out.println("font-size:13px;");
		out.println("font-weight:700;");
		out.println("}");

		out.println(".edit-btn{");
		out.println("background:#2563eb;");
		out.println("color:white;");
		out.println("padding:8px 14px;");
		out.println("border-radius:10px;");
		out.println("text-decoration:none;");
		out.println("font-size:13px;");
		out.println("font-weight:600;");
		out.println("margin-right:6px;");
		out.println("}");

		out.println(".delete-btn{");
		out.println("background:#ef4444;");
		out.println("color:white;");
		out.println("padding:8px 14px;");
		out.println("border-radius:10px;");
		out.println("text-decoration:none;");
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

		out.println("<h1 class='title'>Hospital <span>Doctors</span></h1>");

		out.println("<p class='sub'>Manage all hospital doctor records and details.</p>");

		out.println("</div>");

		out.println("<div class='table-card'>");

		out.println("<div class='table-responsive'>");

		out.println("<table class='table'>");

		out.println("<thead>");

		out.println("<tr>");

		out.println("<th>S.No</th>");
		out.println("<th>ID</th>");
		out.println("<th>Name</th>");
		out.println("<th>Specialization</th>");
		out.println("<th>Mobile</th>");
		out.println("<th>Email</th>");
		out.println("<th>Fees</th>");
		out.println("<th>Action</th>");

		out.println("</tr>");

		out.println("</thead>");

		out.println("<tbody>");

		int srNo1 = 1;

		for (Doctor d : list) {

		    out.println("<tr>");

		    out.println("<td><strong>" + srNo1 + "</td>");

		    out.println("<td><strong>#" + d.getId() + "</strong></td>");

		    out.println("<td><strong>" + d.getName() + "</strong></td>");

		    out.println("<td><span class='special-box'>"
		            + d.getSpecialization() + "</span></td>");

		    out.println("<td>" + d.getMobile() + "</td>");

		    out.println("<td>" + d.getEmail() + "</td>");

		    out.println("<td><span class='fees-box'>₹ "
		            + d.getFees() + "</span></td>");

		    out.println("<td>");

		    out.println("<a class='edit-btn' href='editDoctor?id="
		            + d.getId() + "'>Edit</a>");

		    out.println("<a class='delete-btn' href='deleteDoctor?id="
		            + d.getId() + "'>Delete</a>");

		    out.println("</td>");

		    out.println("</tr>");

		    srNo1++;
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
