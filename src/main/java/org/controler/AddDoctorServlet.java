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
 * Servlet implementation class AddDoctorServlet
 */
@WebServlet("/addDoctor")
public class AddDoctorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddDoctorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String name = request.getParameter("name");
	        String specialization = request.getParameter("specialization");
	        String mobile = request.getParameter("mobile");
	        String email = request.getParameter("email");

	        double fees = Double.parseDouble(
	                request.getParameter("fees"));

	        Doctor doctor = new Doctor();

	        doctor.setName(name);
	        doctor.setSpecialization(specialization);
	        doctor.setMobile(mobile);
	        doctor.setEmail(email);
	        doctor.setFees(fees);

	        DoctorService service = new DoctorService();

	        boolean status = service.addDoctor(doctor);

	        response.setContentType("text/html");

	        PrintWriter out = response.getWriter();

	        if (status) {

	            out.println("<!DOCTYPE html>");
	            out.println("<html>");
	            out.println("<head>");

	            out.println("<title>Doctor Added</title>");

	            out.println("<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css' rel='stylesheet'>");

	            out.println("<style>");

	            out.println("body{");
	            out.println("margin:0;");
	            out.println("height:100vh;");
	            out.println("display:flex;");
	            out.println("justify-content:center;");
	            out.println("align-items:center;");
	            out.println("background:linear-gradient(135deg,#eef4ff,#ffffff,#f3f7ff);");
	            out.println("font-family:'Segoe UI',sans-serif;");
	            out.println("}");

	            out.println(".success-card{");
	            out.println("width:480px;");
	            out.println("background:white;");
	            out.println("border-radius:30px;");
	            out.println("padding:50px 40px;");
	            out.println("text-align:center;");
	            out.println("box-shadow:0 20px 60px rgba(37,99,235,0.12);");
	            out.println("}");

	            out.println(".icon{");
	            out.println("width:100px;");
	            out.println("height:100px;");
	            out.println("margin:auto;");
	            out.println("margin-bottom:25px;");
	            out.println("border-radius:50%;");
	            out.println("display:flex;");
	            out.println("align-items:center;");
	            out.println("justify-content:center;");
	            out.println("background:linear-gradient(135deg,#22c55e,#16a34a);");
	            out.println("color:white;");
	            out.println("font-size:50px;");
	            out.println("font-weight:bold;");
	            out.println("}");

	            out.println("h1{");
	            out.println("font-size:2rem;");
	            out.println("font-weight:800;");
	            out.println("color:#0f172a;");
	            out.println("margin-bottom:15px;");
	            out.println("}");

	            out.println("p{");
	            out.println("color:#64748b;");
	            out.println("font-size:1rem;");
	            out.println("margin-bottom:30px;");
	            out.println("}");

	            out.println(".btn-dashboard{");
	            out.println("display:inline-block;");
	            out.println("padding:14px 28px;");
	            out.println("border-radius:14px;");
	            out.println("text-decoration:none;");
	            out.println("font-weight:700;");
	            out.println("color:white;");
	            out.println("background:linear-gradient(135deg,#2563eb,#3b82f6);");
	            out.println("}");

	            out.println(".btn-dashboard:hover{");
	            out.println("color:white;");
	            out.println("}");

	            out.println("</style>");

	            out.println("</head>");

	            out.println("<body>");

	            out.println("<div class='success-card'>");

	            out.println("<div class='icon'>✓</div>");

	            out.println("<h1>Doctor Added Successfully</h1>");

	            out.println("<p>");
	            out.println("New doctor profile has been added successfully.");
	            out.println("</p>");

	            out.println("<a href='admin-dashboard.html' class='btn-dashboard'>");
	            out.println("Back Dashboard");
	            out.println("</a>");

	            out.println("</div>");

	            out.println("</body>");
	            out.println("</html>");

	        } else {

	            out.println("<!DOCTYPE html>");
	            out.println("<html>");
	            out.println("<head>");

	            out.println("<title>Doctor Add Failed</title>");

	            out.println("<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css' rel='stylesheet'>");

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
	            out.println("width:480px;");
	            out.println("background:white;");
	            out.println("border-radius:30px;");
	            out.println("padding:50px 40px;");
	            out.println("text-align:center;");
	            out.println("box-shadow:0 20px 60px rgba(239,68,68,0.12);");
	            out.println("}");

	            out.println(".icon{");
	            out.println("width:100px;");
	            out.println("height:100px;");
	            out.println("margin:auto;");
	            out.println("margin-bottom:25px;");
	            out.println("border-radius:50%;");
	            out.println("display:flex;");
	            out.println("align-items:center;");
	            out.println("justify-content:center;");
	            out.println("background:linear-gradient(135deg,#ef4444,#dc2626);");
	            out.println("color:white;");
	            out.println("font-size:50px;");
	            out.println("font-weight:bold;");
	            out.println("}");

	            out.println("h1{");
	            out.println("font-size:2rem;");
	            out.println("font-weight:800;");
	            out.println("color:#0f172a;");
	            out.println("margin-bottom:15px;");
	            out.println("}");

	            out.println("p{");
	            out.println("color:#64748b;");
	            out.println("font-size:1rem;");
	            out.println("margin-bottom:30px;");
	            out.println("}");

	            out.println(".btn-dashboard{");
	            out.println("display:inline-block;");
	            out.println("padding:14px 28px;");
	            out.println("border-radius:14px;");
	            out.println("text-decoration:none;");
	            out.println("font-weight:700;");
	            out.println("color:white;");
	            out.println("background:linear-gradient(135deg,#2563eb,#3b82f6);");
	            out.println("}");

	            out.println(".btn-dashboard:hover{");
	            out.println("color:white;");
	            out.println("}");

	            out.println("</style>");

	            out.println("</head>");

	            out.println("<body>");

	            out.println("<div class='fail-card'>");

	            out.println("<div class='icon'>✕</div>");

	            out.println("<h1>Failed To Add Doctor</h1>");

	            out.println("<p>");
	            out.println("Please check doctor details and try again.");
	            out.println("</p>");

	            out.println("<a href='add-doctor.html' class='btn-dashboard'>");
	            out.println("Try Again");
	            out.println("</a>");

	            out.println("</div>");

	            out.println("</body>");
	            out.println("</html>");
	        }
	    }
	}