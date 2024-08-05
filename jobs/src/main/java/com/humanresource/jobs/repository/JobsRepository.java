package com.humanresource.jobs.repository;

import com.humanresource.jobs.entity.Jobs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobsRepository extends JpaRepository<Jobs, Integer> {

   /* @Query(
            value = "SELECT o.orderDate, o.amount, c.firstName, c.lastName FROM Orders o JOIN Customer c ON o.customer.customerId = c.customerId"
    )
    List<String> joinOrderCustomer()*/;
}
