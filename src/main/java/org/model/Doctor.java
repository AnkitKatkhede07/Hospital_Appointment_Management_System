package org.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class Doctor {
	private int id;
    private String name;
    private String specialization;
    private String mobile;
    private String email;
    private double fees;
}
