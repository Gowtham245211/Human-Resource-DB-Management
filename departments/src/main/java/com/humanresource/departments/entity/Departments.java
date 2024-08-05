package com.humanresource.departments.entity;

import com.humanresource.locations.entity.Locations;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(
        name = "departments"
)
public class Departments {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer departmentId;

    private String departmentName;

    @OneToOne(

    )
    @JoinColumn(
            name = "location_id",
            referencedColumnName = "locationId"
    )
    private Locations location;
}
