package com.hiper2d.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.hiper2d.serializer.JsonDateSerializer;

@Entity
@IdClass(FlightPk.class)
@Table(name = "flights_a_zelenovsky")
public class Flight extends BaseEntity {
	
	@Id
	@Column(name = "Flight_Code")
	private String flightCode;
	
	@Id
	@Column(name = "Departure_Date")
	@JsonSerialize(using = JsonDateSerializer.class)
	private LocalDateTime depatureDate;

	public String getFlightCode() {
		return flightCode;
	}

	public void setFlightCode(String flightCode) {
		this.flightCode = flightCode;
	}

	public LocalDateTime getDepatureDate() {
		return depatureDate;
	}

	public void setDepatureDate(LocalDateTime depatureDate) {
		this.depatureDate = depatureDate;
	}
}
