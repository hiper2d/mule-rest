package com.hiper2d.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

@Entity
@Immutable
@IdClass(RoutePk.class)
@Table(name = "routes")
public class Route extends BaseEntity {
	
	@Id
	@Column(name = "Airline_ID")
	private Long airlineId;
	
	@Id
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Source_Airport_ID")
	private Airport sourceAirport;
	
	@Id
	@OneToOne
	@JoinColumn(name = "Destination_Airport_ID")
	private Airport destinationAirport;
	
	@Column(name = "Airline")
	private String airlineName;

	public Long getAirlineId() {
		return airlineId;
	}

	public void setAirlineId(Long airlineId) {
		this.airlineId = airlineId;
	}

	public Airport getSourceAirport() {
		return sourceAirport;
	}

	public void setSourceAirport(Airport sourceAirport) {
		this.sourceAirport = sourceAirport;
	}

	public Airport getDestinationAirport() {
		return destinationAirport;
	}

	public void setDestinationAirport(Airport destinationAirport) {
		this.destinationAirport = destinationAirport;
	}

	public String getAirlineName() {
		return airlineName;
	}

	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}
	
	
}
