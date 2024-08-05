package com.humanresource.employees.entity;

import com.humanresource.departments.entity.Departments;
import com.humanresource.jobs.entity.Jobs;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(
        name = "employees"
)
public class Employees {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer employeeId;

    private String firstName;

    private String lastName;

    private String email;

    private String phoneNumber;

    private LocalDate hireDate;

    private Double salary;

    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            orphanRemoval = true,
            optional = true
    )
    @JoinColumn(
            name = "job_id",
            referencedColumnName = "jobId"
    )
    private Jobs job;

    @OneToOne(

    )
    @JoinColumn(
            name = "department_id",
            referencedColumnName = "departmentId"
    )
    private Departments department;
}
