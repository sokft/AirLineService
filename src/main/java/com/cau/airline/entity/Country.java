package com.cau.airline.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "Country")
public class Country {
    @Id
    private String countryId;
    private String countryName;
    private String continent;
}