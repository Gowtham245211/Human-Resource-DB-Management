package com.humanresource.employees.repository;

import com.humanresource.employees.entity.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeesRepository extends JpaRepository<Employees, Integer> {

    @Modifying
    @Query(
            nativeQuery = true,
            value = "update experience set location=?1 where company_name=?2 and start_date=?3"
    )
    void updateLocationByCompanyNameAndStartDate(String city, String companyName, String startDate);

    @Modifying
    @Query(
            nativeQuery = true,
            value = "update experience set start_date=?1 where can_id=?2 and company_name=?3"
    )
    void updateStartDateByCanIdAndCompanyName(String startDate, Long canId, String companyName);
}
