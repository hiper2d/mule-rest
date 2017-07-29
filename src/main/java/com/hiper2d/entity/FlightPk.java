package com.hiper2d.entity;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

public class FlightPk extends BaseEntity {
	private String flightCode;
	private LocalDateTime depatureDate;
	
	@Override
	public int hashCode() {
		return Objects.hash(flightCode, depatureDate);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FlightPk other = (FlightPk) obj;
		if (depatureDate == null) {
			if (other.depatureDate != null)
				return false;
		} else if (!depatureDate.equals(other.depatureDate))
			return false;
		if (flightCode == null) {
			if (other.flightCode != null)
				return false;
		} else if (!flightCode.equals(other.flightCode))
			return false;
		return true;
	}
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
