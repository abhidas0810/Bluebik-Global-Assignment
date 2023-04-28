package com.bankApp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Email;
import lombok.Data;

@Entity
@Data
public class User {

	@Id
	@Email
	private String userEmailId;
	private String name;

	@ManyToOne
	private Account account;

}
