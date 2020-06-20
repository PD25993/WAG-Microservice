package com.walgreens.icplusservice.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "rx_details")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RxDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long rx_nbr;
	@NotNull
	private Integer fill_nbr_dispanced;
	@NotNull
	private String rx_status;	//READY/PRINTED
	@DecimalMin(value = "0.1")
	@Positive
	@NotNull
	private Double rx_amount;
	private String rx_plan;
	@NotNull
	private String rx_direction;
	@NotNull
	private Long prescriber_id;
	@NotNull
	private Long drug_id;
	@NotNull
	@Getter(value=AccessLevel.NONE)
    @Setter(value=AccessLevel.NONE)
	@ManyToOne(fetch = FetchType.EAGER)	
	@JoinColumn(name = "store_id")
	private StoreDetails store;
	@NotNull
	@Getter(value=AccessLevel.NONE)
    @Setter(value=AccessLevel.NONE)
	@ManyToOne(fetch = FetchType.EAGER)	
	@JoinColumn(name = "pat_id")
	private PatientDetails patient;
	public StoreDetails getStore() {
		return store;
	}
	public void setStore(StoreDetails store) {
		this.store = store;
	}
	public PatientDetails getPatient() {
		return patient;
	}
	public void setPatient(PatientDetails patient) {
		this.patient = patient;
	}
	
}
