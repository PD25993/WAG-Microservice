package com.walgreens.icplusservice.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pat_details")
public class PatientDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long pat_id;
	@NotNull
	private String pat_first_name;
	private String pat_last_name;
	private String pat_middle_name;
	@NotNull
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@PastOrPresent
	private Date pat_birth_date;
	@NotNull
	@Size(max=2, message="Please provide HM/WK/CL")
	private String pat_phone_type;
	@Pattern(regexp="(^$|[0-9]{10})")
	private Integer pat_phone_no;
	@Email
	private String pat_email_id;
	@NotNull
	@Max(50)
	private String pat_address;
	@NotNull
	@Max(20)
	private String pat_city;
	@NotNull
	@Max(10)
	private Integer pat_zip_cd;
	@NotNull
	private String pat_state;
	@Getter(value=AccessLevel.NONE)
    @Setter(value=AccessLevel.NONE)
	@OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
	private List<RxDetails> rxdetails;
	public List<RxDetails> getRxdetails() {
		return null;
	}
	public void setRxdetails(List<RxDetails> rxdetails) {
		this.rxdetails = rxdetails;
	}
	
}
