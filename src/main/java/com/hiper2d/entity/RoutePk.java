package com.hiper2d.entity;

public class RoutePk extends BaseEntity {
	private Long airlineId;
	private Airport sourceAirport;
	private Airport destinationAirport;
	
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
}
