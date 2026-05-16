package org.controler;

import jakarta.servlet.ServletException;
import com.service.PatientService;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import org.model.Patient;



/**
 * Servlet implementation class PatientLoginServlet
 */
@WebServlet("/patientLogin")
public class PatientLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PatientLoginServlet() {
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
		String mobile = request.getParameter("mobile");
        String password = request.getParameter("password");
     
        PatientService service = new PatientService();
        Patient patient = service.loginPatient(mobile, password);

        if (patient != null) {
            HttpSession session = request.getSession();
            session.setAttribute("patientId", patient.getId());
            session.setAttribute("patientName", patient.getName());
            response.sendRedirect("patient-dashboard.html");
        } else {
        	response.setContentType("text/html");

        	PrintWriter out = response.getWriter();

        	out.println("<!DOCTYPE html>");
        	out.println("<html>");
        	out.println("<head>");

        	out.println("<title>Patient Login Failed</title>");

        	out.println("<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css' rel='stylesheet'>");

        	out.println("<style>");

        	out.println("body{");
        	out.println("margin:0;");
        	out.println("height:100vh;");
        	out.println("display:flex;");
        	out.println("justify-content:center;");
        	out.println("align-items:center;");
        	out.println("background:linear-gradient(135deg,#eef4ff,#ffffff,#f0f9ff);");
        	out.println("font-family:'Segoe UI',sans-serif;");
        	out.println("}");

        	out.println(".login-card{");
        	out.println("width:520px;");
        	out.println("background:white;");
        	out.println("padding:50px 40px;");
        	out.println("border-radius:32px;");
        	out.println("text-align:center;");
        	out.println("box-shadow:0 20px 50px rgba(37,99,235,0.12);");
        	out.println("}");

        	out.println(".icon-box{");
        	out.println("width:95px;");
        	out.println("height:95px;");
        	out.println("margin:auto;");
        	out.println("border-radius:50%;");
        	out.println("display:flex;");
        	out.println("align-items:center;");
        	out.println("justify-content:center;");
        	out.println("font-size:42px;");
        	out.println("background:linear-gradient(135deg,#ef4444,#dc2626);");
        	out.println("color:white;");
        	out.println("}");

        	out.println(".title{");
        	out.println("margin-top:30px;");
        	out.println("font-size:2.3rem;");
        	out.println("font-weight:800;");
        	out.println("color:#0f172a;");
        	out.println("}");

        	out.println(".text{");
        	out.println("margin-top:15px;");
        	out.println("font-size:1.05rem;");
        	out.println("line-height:1.8;");
        	out.println("color:#64748b;");
        	out.println("}");

        	out.println(".btn-login{");
        	out.println("margin-top:35px;");
        	out.println("display:inline-block;");
        	out.println("padding:14px 32px;");
        	out.println("border-radius:14px;");
        	out.println("text-decoration:none;");
        	out.println("font-weight:700;");
        	out.println("color:white;");
        	out.println("background:linear-gradient(135deg,#2563eb,#4f46e5);");
        	out.println("transition:0.3s;");
        	out.println("}");

        	out.println(".btn-login:hover{");
        	out.println("transform:translateY(-3px);");
        	out.println("box-shadow:0 15px 30px rgba(37,99,235,0.20);");
        	out.println("color:white;");
        	out.println("}");

        	out.println("</style>");

        	out.println("</head>");

        	out.println("<body>");

        	out.println("<div class='login-card'>");

        	out.println("<div class='icon-box'>✕</div>");

        	out.println("<h1 class='title'>Login Failed!</h1>");

        	out.println("<p class='text'>");
        	out.println("Invalid mobile number or password.");
        	out.println("Please check your credentials and try again.");
        	out.println("</p>");

        	out.println("<a href='patient-login.html' class='btn-login'>");
        	out.println("Try Again");
        	out.println("</a>");

        	out.println("</div>");

        	out.println("</body>");
        	out.println("</html>");
        }
	}

}
