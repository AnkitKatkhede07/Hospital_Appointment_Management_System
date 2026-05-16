package org.controler;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import com.service.AdminService;

import java.io.IOException;
import java.io.PrintWriter;

import org.model.Admin;

@WebServlet("/adminLogin")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminLoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	
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
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		AdminService service = new AdminService();
		Admin admin = service.loginAdmin(email, password);

		if (admin != null) {
			HttpSession session = request.getSession();
			session.setAttribute("adminId", admin.getId());
			session.setAttribute("adminEmail", admin.getEmail());
			response.sendRedirect("admin-dashboard.html");
		} else {
			response.setContentType("text/html");

			PrintWriter out = response.getWriter();

			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");

			out.println("<title>Admin Login Failed</title>");

			out.println(
					"<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css' rel='stylesheet'>");

			out.println("<style>");

			out.println("body{");
			out.println("margin:0;");
			out.println("height:100vh;");
			out.println("display:flex;");
			out.println("justify-content:center;");
			out.println("align-items:center;");
			out.println("background:linear-gradient(135deg,#eef2ff,#ffffff,#f3e8ff);");
			out.println("font-family:'Segoe UI',sans-serif;");
			out.println("}");

			out.println(".login-card{");
			out.println("width:500px;");
			out.println("background:white;");
			out.println("padding:50px 40px;");
			out.println("border-radius:30px;");
			out.println("text-align:center;");
			out.println("box-shadow:0 20px 50px rgba(79,70,229,0.15);");
			out.println("}");

			out.println(".icon-box{");
			out.println("width:90px;");
			out.println("height:90px;");
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
			out.println("margin-top:28px;");
			out.println("font-size:2.2rem;");
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
			out.println("padding:14px 30px;");
			out.println("border-radius:14px;");
			out.println("text-decoration:none;");
			out.println("font-weight:700;");
			out.println("color:white;");
			out.println("background:linear-gradient(135deg,#4f46e5,#2563eb);");
			out.println("}");

			out.println("</style>");

			out.println("</head>");

			out.println("<body>");

			out.println("<div class='login-card'>");

			out.println("<div class='icon-box'>✕</div>");

			out.println("<h1 class='title'>Login Failed!</h1>");

			out.println("<p class='text'>");
			out.println("Invalid admin email or password.");
			out.println("Please check your credentials and try again.");
			out.println("</p>");

			out.println("<a href='admin-login.html' class='btn-login'>");
			out.println("Try Again");
			out.println("</a>");

			out.println("</div>");

			out.println("</body>");
			out.println("</html>");
		}
	}
}
