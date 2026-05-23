package com.service;

import java.util.List;

import org.model.Patient;
import org.repsitory.PatientRepository;

public class PatientService {

    private final PatientRepository repo = new PatientRepository();

    public boolean registerPatient(Patient patient) {
        if ((patient == null) || patient.getName() == null || patient.getName().isBlank() || (patient.getAge() <= 0)) {
			return false;
		}

        String mobile = normalizeMobile(patient.getMobile());
        if (mobile == null) {
			return false;
		}
        patient.setMobile(mobile);

        if (patient.getPassword() == null || patient.getPassword().isBlank()) {
			return false;
		}

        return repo.registerPatient(patient);
    }

    public Patient loginPatient(String mobile, String password) {
        if (mobile == null || mobile.isBlank() || password == null || password.isBlank()) {
            return null;
        }

        mobile = normalizeMobile(mobile);
        if (mobile == null) {
            return null;
        }

        return repo.loginPatient(mobile, password);
    }

    public int getTotalPatients() {
        return repo.getTotalPatients();
    }

    public List<Patient> searchPatients(String keyword) {
        return repo.searchPatients(keyword);
    }

    private String normalizeMobile(String mobile) {
        if (mobile == null) {
			return null;
		}

        mobile = mobile.trim();
        mobile = mobile.replaceAll("[\\s\\-()]", "");

        if (mobile.matches("\\d{10}")) {
            return "+91" + mobile;
        }

        if (mobile.matches("0\\d{10}")) {
            return "+91" + mobile.substring(1);
        }

        if (mobile.matches("\\+91\\d{10}")) {
            return mobile;
        }

        return null;
    }
}