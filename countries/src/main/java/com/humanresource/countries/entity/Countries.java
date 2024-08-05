package com.humanresource.countries.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(
        name = "countries"
)
public class Countries {

    @Id
    private Character countryId;

    private String countryName;
}
