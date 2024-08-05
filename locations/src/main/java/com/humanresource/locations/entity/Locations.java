package com.humanresource.locations.entity;

import com.humanresource.countries.entity.Countries;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(
        name = "locations"
)
public class Locations {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer locationId;

    private String streetAddress;

    private String postalCode;

    private String city;

    private String stateProvince;

    @OneToOne(

    )
    @JoinColumn(
            name = "country_id",
            referencedColumnName = "countryId"
    )
    private Countries country;
}
