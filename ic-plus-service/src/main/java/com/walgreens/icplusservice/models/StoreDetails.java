package com.walgreens.icplusservice.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "store_details")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StoreDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long store_id;
	private Integer store_nbr;
	@NotNull
	@Max(50)
	private String store_address;
	@NotNull
	@Max(20)
	private String store_city;
	@NotNull
	@Max(10)
	private Integer store_zip_cd;
	@NotNull
	private String store_state;
	@Getter(value=AccessLevel.NONE)
    @Setter(value=AccessLevel.NONE)
	@OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
	private List<RxDetails> rxdetails;
	
	public List<RxDetails> getRxdetails() {
		return null;
	}
	public void setRxdetails(List<RxDetails> rxdetails) {
		this.rxdetails = rxdetails;
	}
	

	
}
