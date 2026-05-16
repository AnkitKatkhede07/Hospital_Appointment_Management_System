package org.controler;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.model.Doctor;

import com.service.DoctorService;

/**
 * Servlet implementation class ViewDocterPatient
 */
@WebServlet("/ViewDocterPatient")
public class ViewDocterPatient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewDocterPatient() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        DoctorService service = new DoctorService();
        List<Doctor> list = service.getAllDoctors();

        out.println("<!DOCTYPE html>");
        out.println("<html lang='en'>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
        out.println("<title>View Doctors</title>");
        out.println("<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css' rel='stylesheet'>");
        out.println("<style>");
        out.println("body{background:linear-gradient(to bottom right,#eef4ff,#ffffff,#f1f5ff);font-family:'Segoe UI',sans-serif;padding:40px;}");
        out.println(".main-box{background:white;border-radius:30px;padding:40px;box-shadow:0 15px 40px rgba(0,0,0,0.08);}");
        out.println(".title{font-size:3rem;font-weight:800;color:#0f172a;}");
        out.println(".title span{color:#2563eb;}");
        out.println(".subtitle{color:#64748b;margin-bottom:35px;}");
        out.println(".table{border-radius:20px;overflow:hidden;}");
        out.println(".table thead{background:#2563eb;color:white;}");
        out.println(".table th{padding:18px !important;}");
        out.println(".table td{padding:16px !important;vertical-align:middle;}");
        out.println(".table tbody tr:hover{background:#f8fbff;}");
        out.println(".fees{color:#059669;font-weight:700;}");
        out.println(".back-btn{background:linear-gradient(135deg,#2563eb,#3b82f6);color:white;padding:14px 30px;border-radius:14px;text-decoration:none;font-weight:700;display:inline-block;margin-top:25px;}");
        out.println(".back-btn:hover{color:white;transform:translateY(-2px);}");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");

        out.println("<div class='container'>");
        out.println("<div class='main-box'>");
        out.println("<h1 class='title'>Hospital <span>Doctors</span></h1>");
        out.println("<p class='subtitle'>View all available doctors and their details.</p>");

        out.println("<div class='table-responsive'>");
        out.println("<table class='table table-hover align-middle'>");
        out.println("<thead>");
        out.println("<tr>");
        out.println("<th>Sr.No</th>");
        out.println("<th>ID</th>");
        out.println("<th>Name</th>");
        out.println("<th>Specialization</th>");
        out.println("<th>Mobile</th>");
        out.println("<th>Email</th>");
        out.println("<th>Fees</th>");
        out.println("</tr>");
        out.println("</thead>");
        out.println("<tbody>");

        int srNo = 1;
        for (Doctor d : list) {
            out.println("<tr>");
            out.println("<td><b>" + srNo + "</td>");
            out.println("<td>#<b>" + d.getId() + "</td>");
            out.println("<td><b>" + d.getName() + "</b></td>");
            out.println("<td><b>" + d.getSpecialization() + "</td>");
            out.println("<td>" + d.getMobile() + "</td>");
            out.println("<td>" + d.getEmail() + "</td>");
            out.println("<td class='fees'>&#8377; " + d.getFees() + "</td>");
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
