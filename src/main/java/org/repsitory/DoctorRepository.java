package org.repsitory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.model.Doctor;

import com.db.DBConnection;

public class DoctorRepository {

    // Add Doctor
    public boolean addDoctor(Doctor doctor) {

        boolean status = false;

        try {

            Connection con = DBConnection.getConnection();

            String sql = "INSERT INTO doctors(name, specialization, mobile, email, fees) VALUES (?, ?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, doctor.getName());
            ps.setString(2, doctor.getSpecialization());
            ps.setString(3, doctor.getMobile());
            ps.setString(4, doctor.getEmail());
            ps.setDouble(5, doctor.getFees());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                status = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    // View Doctors
    public List<Doctor> getAllDoctors() {

        List<Doctor> list = new ArrayList<>();

        try {

            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM doctors";

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Doctor doctor = new Doctor();

                doctor.setId(rs.getInt("id"));
                doctor.setName(rs.getString("name"));
                doctor.setSpecialization(rs.getString("specialization"));
                doctor.setMobile(rs.getString("mobile"));
                doctor.setEmail(rs.getString("email"));
                doctor.setFees(rs.getDouble("fees"));

                list.add(doctor);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;

    }
 // Delete Doctor
    public boolean deleteDoctor(int id) {

        boolean status = false;

        try {

            Connection con = DBConnection.getConnection();

            String sql = "DELETE FROM doctors WHERE id=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                status = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }
 // Get doctor by id
    public Doctor getDoctorById(int id) {
        Doctor doctor = null;

        try {
            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM doctors WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                doctor = new Doctor();
                doctor.setId(rs.getInt("id"));
                doctor.setName(rs.getString("name"));
                doctor.setSpecialization(rs.getString("specialization"));
                doctor.setMobile(rs.getString("mobile"));
                doctor.setEmail(rs.getString("email"));
                doctor.setFees(rs.getDouble("fees"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return doctor;
    }

    // Update doctor
    public boolean updateDoctor(Doctor doctor) {
        boolean status = false;

        try {
            Connection con = DBConnection.getConnection();

            String sql = "UPDATE doctors SET name=?, specialization=?, mobile=?, email=?, fees=? WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, doctor.getName());
            ps.setString(2, doctor.getSpecialization());
            ps.setString(3, doctor.getMobile());
            ps.setString(4, doctor.getEmail());
            ps.setDouble(5, doctor.getFees());
            ps.setInt(6, doctor.getId());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                status = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }
    //
    public List<Doctor> searchDoctors(String keyword) {
        List<Doctor> list = new ArrayList<>();

        try {
            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM doctors WHERE name LIKE ? OR specialization LIKE ? OR mobile LIKE ? OR email LIKE ?";
            PreparedStatement ps = con.prepareStatement(sql);

            String k = "%" + keyword + "%";
            ps.setString(1, k);
            ps.setString(2, k);
            ps.setString(3, k);
            ps.setString(4, k);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Doctor doctor = new Doctor();
                doctor.setId(rs.getInt("id"));
                doctor.setName(rs.getString("name"));
                doctor.setSpecialization(rs.getString("specialization"));
                doctor.setMobile(rs.getString("mobile"));
                doctor.setEmail(rs.getString("email"));
                doctor.setFees(rs.getDouble("fees"));
                list.add(doctor);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
 // Total Doctors
    public int getTotalDoctors() {

        int count = 0;

        try {

            Connection con = DBConnection.getConnection();

            String sql = "SELECT COUNT(*) FROM doctors";

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                count = rs.getInt(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return count;
    }
}