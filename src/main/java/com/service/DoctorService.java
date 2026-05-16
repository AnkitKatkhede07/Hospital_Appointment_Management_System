package com.service;

import java.util.List;

import org.model.Doctor;
import org.repsitory.DoctorRepository;

public class DoctorService {

    private final DoctorRepository repo = new DoctorRepository();

    public boolean addDoctor(Doctor doctor) {
        if (doctor == null) return false;

        if (doctor.getName() == null || doctor.getName().isBlank()) return false;
        if (doctor.getSpecialization() == null || doctor.getSpecialization().isBlank()) return false;
        if (doctor.getMobile() == null || doctor.getMobile().length() != 10) return false;
        if (doctor.getEmail() == null || doctor.getEmail().isBlank()) return false;
        if (doctor.getFees() < 0) return false;

        return repo.addDoctor(doctor);
    }

    public List<Doctor> getAllDoctors() {
        return repo.getAllDoctors();
    }

    public Doctor getDoctorById(int id) {
        return repo.getDoctorById(id);
    }

    public boolean updateDoctor(Doctor doctor) {
        if (doctor == null) return false;
        if (doctor.getId() <= 0) return false;
        return repo.updateDoctor(doctor);
    }

    public boolean deleteDoctor(int id) {
        if (id <= 0) return false;
        return repo.deleteDoctor(id);
    }

    public List<Doctor> searchDoctors(String keyword) {
        return repo.searchDoctors(keyword);
    }

    public int getTotalDoctors() {
        return repo.getTotalDoctors();
    }
}