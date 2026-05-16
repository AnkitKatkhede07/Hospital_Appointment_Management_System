package com.service;

import java.util.List;

import org.model.Appointment;
import org.repsitory.AppointmentRepository;

public class AppointmentService {

    private final AppointmentRepository repo = new AppointmentRepository();

    public boolean bookAppointment(Appointment appt) {
        if (appt == null) return false;

        if (appt.getPatientId() <= 0) return false;
        if (appt.getDoctorId() <= 0) return false;
        if (appt.getAppointmentDate() == null) return false;

        appt.setStatus("Pending");
        return repo.bookAppointment(appt);
    }

    public List<Appointment> getAppointmentsByPatientId(int patientId) {
        return repo.getAppointmentsByPatientId(patientId);
    }

    public List<Appointment> getAllAppointments() {
        return repo.getAllAppointments();
    }

    public boolean updateStatus(int id, String status) {
        if (id <= 0) return false;
        if (status == null || status.isBlank()) return false;

        if (!status.equals("Pending") && !status.equals("Approved") && !status.equals("Rejected")) {
            return false;
        }

        return repo.updateStatus(id, status);
    }

    public List<Appointment> searchAppointments(String keyword) {
        return repo.searchAppointments(keyword);
    }

    public int getTotalAppointments() {
        return repo.getTotalAppointments();
    }

    public int getApprovedAppointments() {
        return repo.getApprovedAppointments();
    }

    public int getRejectedAppointments() {
        return repo.getRejectedAppointments();
    }

    public int getPendingAppointments() {
        return repo.getPendingAppointments();
    }
}