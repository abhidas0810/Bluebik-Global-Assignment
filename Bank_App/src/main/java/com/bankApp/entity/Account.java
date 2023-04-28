package com.bankApp.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Account {

	@Id
	@GeneratedValue
	private Integer accountNumber;
	private Double balance;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "account")
	@JsonIgnore
	private List<User> users = new ArrayList<>();

}
