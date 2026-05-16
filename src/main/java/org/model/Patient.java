package org.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class Patient {
	private int id;
	private String name;
	private int age;
	private String gender;
	private String mobile;
	private String disease;
	private String password;
}
