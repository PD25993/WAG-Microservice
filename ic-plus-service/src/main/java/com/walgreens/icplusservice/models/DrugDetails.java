package com.walgreens.icplusservice.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "drug_details")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DrugDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long drug_id;
	@NotNull
	private String drug_generic_name;
	@NotNull
	private String drug_manufacturer;
	@NotNull
	private String drug_color;
}
