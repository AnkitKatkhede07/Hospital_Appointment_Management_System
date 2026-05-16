package org.repsitory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.db.DBConnection;
import org.model.Patient;

public class PatientRepository {

    // Register patient
    public boolean registerPatient(Patient patient) {
        boolean status = false;

        try {
            Connection con = DBConnection.getConnection();

            String sql = "INSERT INTO patients(name, age, gender, mobile, disease, password) "
                       + "VALUES (?, ?, ?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, patient.getName());
            ps.setInt(2, patient.getAge());
            ps.setString(3, patient.getGender());
            ps.setString(4, patient.getMobile());
            ps.setString(5, patient.getDisease());
            ps.setString(6, patient.getPassword());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                status = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    // Patient login
    public Patient loginPatient(String mobile, String password) {
        Patient patient = null;

        try {
            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM patients WHERE mobile=? AND password=?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, mobile);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                patient = new Patient();

                patient.setId(rs.getInt("id"));
                patient.setName(rs.getString("name"));
                patient.setAge(rs.getInt("age"));
                patient.setGender(rs.getString("gender"));
                patient.setMobile(rs.getString("mobile"));
                patient.setDisease(rs.getString("disease"));
                patient.setPassword(rs.getString("password"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return patient;
    }
    //
    public List<Patient> searchPatients(String keyword) {
        List<Patient> list = new ArrayList<>();

        try {
            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM patients WHERE name LIKE ? OR mobile LIKE ? OR disease LIKE ?";
            PreparedStatement ps = con.prepareStatement(sql);

            String k = "%" + keyword + "%";
            ps.setString(1, k);
            ps.setString(2, k);
            ps.setString(3, k);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Patient patient = new Patient();
                patient.setId(rs.getInt("id"));
                patient.setName(rs.getString("name"));
                patient.setAge(rs.getInt("age"));
                patient.setGender(rs.getString("gender"));
                patient.setMobile(rs.getString("mobile"));
                patient.setDisease(rs.getString("disease"));
                patient.setPassword(rs.getString("password"));
                list.add(patient);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
 // Total Patients
    public int getTotalPatients() {

        int count = 0;

        try {

            Connection con = DBConnection.getConnection();

            String sql = "SELECT COUNT(*) FROM patients";

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