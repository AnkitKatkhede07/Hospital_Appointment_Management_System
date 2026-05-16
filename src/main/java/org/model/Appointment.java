package org.model;

import java.sql.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Setter
@Getter
@NoArgsConstructor

public class Appointment {
	private int id;
    private int patientId;
    private int doctorId;
    private Date appointmentDate;
    private String status;
}
