package com.service;

import org.model.Admin;
import org.repsitory.AdminRepository;

public class AdminService {

    private final AdminRepository repo = new AdminRepository();

    public Admin loginAdmin(String email, String password) {
        if (email == null || email.isBlank() || password == null || password.isBlank()) {
            return null;
        }
        return repo.loginAdmin(email, password);
    }
}

