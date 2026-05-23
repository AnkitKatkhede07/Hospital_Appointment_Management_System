package org.controler;

import java.io.IOException;
import java.io.PrintWriter;

import com.service.AppointmentService;
import com.service.DoctorService;
import com.service.PatientService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ReportServlet
 */
@WebServlet("/reports")
public class ReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReportServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PatientService patientService = new PatientService();
		DoctorService doctorService = new DoctorService();
		AppointmentService appointmentService = new AppointmentService();

		int totalPatients = patientService.getTotalPatients();
		int totalDoctors = doctorService.getTotalDoctors();
		int totalAppointments = appointmentService.getTotalAppointments();
		int approved = appointmentService.getApprovedAppointments();
		int rejected = appointmentService.getRejectedAppointments();
		int pending = appointmentService.getPendingAppointments();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		StringBuilder html = new StringBuilder();

		html.append("<!DOCTYPE html>");
		html.append("<html lang='en'>");
		html.append("<head>");
		html.append("<meta charset='UTF-8'>");
		html.append("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
		html.append("<title>Hospital Reports Dashboard</title>");
		html.append("<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css' rel='stylesheet'>");
		html.append("<script src='https://unpkg.com/lucide@latest'></script>");

		html.append("<style>");
		html.append("body{background:linear-gradient(135deg,#eef4ff,#ffffff,#f5f8ff);font-family:'Segoe UI',sans-serif;min-height:100vh;padding:40px 20px;}");
		html.append(".dashboard-card{background:rgba(255,255,255,0.88);backdrop-filter:blur(18px);border-radius:32px;padding:40px;box-shadow:0 20px 60px rgba(15,23,42,0.08);border:1px solid rgba(255,255,255,0.7);}");
		html.append(".top-badge{display:inline-flex;align-items:center;gap:8px;background:#dbeafe;color:#2563eb;padding:10px 18px;border-radius:999px;font-weight:700;margin-bottom:20px;}");
		html.append(".main-title{font-size:clamp(2rem,4vw,3.5rem);font-weight:900;line-height:1.1;margin-bottom:12px;color:#0f172a;}");
		html.append(".main-title span{background:linear-gradient(135deg,#2563eb,#7c3aed);-webkit-background-clip:text;-webkit-text-fill-color:transparent;}");
		html.append(".subtitle{color:#64748b;font-size:1.05rem;margin-bottom:40px;}");
		html.append(".report-card{background:white;border-radius:24px;padding:28px;box-shadow:0 12px 30px rgba(15,23,42,0.06);height:100%;transition:0.3s;}");
		html.append(".report-card:hover{transform:translateY(-5px);}");
		html.append(".icon-box{width:70px;height:70px;border-radius:22px;display:flex;align-items:center;justify-content:center;margin-bottom:22px;}");
		html.append(".icon-box svg{width:32px;height:32px;color:white;}");
		html.append(".blue{background:linear-gradient(135deg,#2563eb,#3b82f6);}");
		html.append(".purple{background:linear-gradient(135deg,#7c3aed,#8b5cf6);}");
		html.append(".green{background:linear-gradient(135deg,#10b981,#059669);}");
		html.append(".red{background:linear-gradient(135deg,#ef4444,#dc2626);}");
		html.append(".orange{background:linear-gradient(135deg,#f59e0b,#d97706);}");
		html.append(".cyan{background:linear-gradient(135deg,#06b6d4,#0891b2);}");
		html.append(".report-title{font-size:1.1rem;font-weight:700;color:#334155;margin-bottom:10px;}");
		html.append(".report-count{font-size:2.8rem;font-weight:900;color:#0f172a;}");
		html.append(".back-btn{display:inline-block;margin-top:40px;padding:14px 28px;border-radius:16px;text-decoration:none;background:linear-gradient(135deg,#2563eb,#7c3aed);color:white;font-weight:700;transition:0.3s;}");
		html.append(".back-btn:hover{transform:translateY(-3px);color:white;}");
		html.append("</style>");

		html.append("</head>");
		html.append("<body>");

		html.append("<div class='container'>");
		html.append("<div class='dashboard-card'>");

		html.append("<div class='text-center'>");
		html.append("<div class='top-badge'><i data-lucide='bar-chart-3'></i>Hospital Analytics Dashboard</div>");
		html.append("<h1 class='main-title'>Hospital <span>Reports</span></h1>");
		html.append("<p class='subtitle'>Real-time overview of patients, doctors and appointments.</p>");
		html.append("</div>");

		html.append("<div class='row g-4'>");

		html.append("<div class='col-md-6 col-lg-4'><div class='report-card'><div class='icon-box blue'><i data-lucide='users'></i></div><div class='report-title'>Total Patients</div><div class='report-count'>").append(totalPatients).append("</div></div></div>");
		html.append("<div class='col-md-6 col-lg-4'><div class='report-card'><div class='icon-box purple'><i data-lucide='stethoscope'></i></div><div class='report-title'>Total Doctors</div><div class='report-count'>").append(totalDoctors).append("</div></div></div>");
		html.append("<div class='col-md-6 col-lg-4'><div class='report-card'><div class='icon-box cyan'><i data-lucide='calendar-days'></i></div><div class='report-title'>Total Appointments</div><div class='report-count'>").append(totalAppointments).append("</div></div></div>");

		html.append("<div class='col-md-6 col-lg-4'><div class='report-card'><div class='icon-box green'><i data-lucide='check-circle'></i></div><div class='report-title'>Approved</div><div class='report-count'>").append(approved).append("</div></div></div>");
		html.append("<div class='col-md-6 col-lg-4'><div class='report-card'><div class='icon-box red'><i data-lucide='x-circle'></i></div><div class='report-title'>Rejected</div><div class='report-count'>").append(rejected).append("</div></div></div>");
		html.append("<div class='col-md-6 col-lg-4'><div class='report-card'><div class='icon-box orange'><i data-lucide='clock-3'></i></div><div class='report-title'>Pending</div><div class='report-count'>").append(pending).append("</div></div></div>");

		html.append("</div>");

		html.append("<div class='text-center'><a href='admin-dashboard.html' class='back-btn'>← Back to Dashboard</a></div>");

		html.append("</div>");
		html.append("</div>");

		html.append("<script>lucide.createIcons();</script>");
		html.append("</body>");
		html.append("</html>");

		out.println(html.toString());
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
