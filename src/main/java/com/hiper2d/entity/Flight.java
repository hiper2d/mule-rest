package com.hiper2d.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.hiper2d.serializer.DateDeserializer;
import com.hiper2d.serializer.DateSerializer;

@Entity
@IdClass(FlightPk.class)
@Table(name = "flights_a_zelenovsky")
public class Flight extends BaseEntity {
	
	@Id
	@Column(name = "Flight_Code")
	private String flightCode;
	
	@Id
	@Column(name = "Departure_Date")
	@JsonSerialize(using = DateSerializer.class)
	@JsonDeserialize(using = DateDeserializer.class)
	private LocalDateTime depatureDate;

	@Column(name = "Airline_Name")
	private String airlineName;
	
	@Column(name = "Departure_Airport")
	private String departureAirport;
	
	@Column(name = "Destination_Airport")
	private String destinationAirport;
	
	@Column(name = "Aircraft_Type")
	private String aircraftType;
	
	@Column(name = "Seat_Availability")
	private int seatAvailability;
	
	@Column(name = "Price")
	private Double price;

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

	public String getAirlineName() {
		return airlineName;
	}

	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}

	public String getDepartureAirport() {
		return departureAirport;
	}

	public void setDepartureAirport(String departureAirport) {
		this.departureAirport = departureAirport;
	}

	public String getDestinationAirport() {
		return destinationAirport;
	}

	public void setDestinationAirport(String destinationAirport) {
		this.destinationAirport = destinationAirport;
	}

	public String getAircraftType() {
		return aircraftType;
	}

	public void setAircraftType(String aircraftType) {
		this.aircraftType = aircraftType;
	}

	public int getSeatAvailability() {
		return seatAvailability;
	}

	public void setSeatAvailability(int seatAvailability) {
		this.seatAvailability = seatAvailability;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
}
