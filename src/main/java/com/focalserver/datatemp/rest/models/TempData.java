package com.focalserver.datatemp.rest.models;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Table(name = "datatemp")
public @Data class TempData {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long dataId;

	@NotNull
	private Long temperature;

	@NotNull
	private Long humidity;

	@NotNull
	private Timestamp dateTime;

	public TempData() {
		super();
	}
}