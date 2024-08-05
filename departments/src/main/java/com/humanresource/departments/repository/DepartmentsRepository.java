package com.humanresource.departments.repository;

import com.humanresource.departments.entity.Departments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentsRepository extends JpaRepository<Departments, Integer> {

    /* All get methods */

    /*Iterable<Departments> findAllByDepartmentNameContaining(String departmentName);

    @Query(
            value = "select concat_ws(dep.departmentId, ' - ', dep.departmentName) from Departments dep"
    )
    List<String> findAllDepartments();

    Iterable<Departments>  findAllByDepartmentsLocationCity(String city);

    List<Departments> findByDepartmentNameLike(String regex);

    List<Departments> findByDepartmentNameEqualsIgnoreCase(String lastName);

    @Query(
            value = "select distinct authorFname from Books"
    )
    List<String> findAllDistinctAuthorFname();

    @Query(
            value = "select concat_ws(' - ', title, pages) from Books order by pages desc limit 1"
    )
    String findOneBookWithHighestPages();

    @Query(
            value = "SELECT b FROM Books b WHERE b.releasedYear = (SELECT MIN(b2.releasedYear) FROM Books b2)"
    )
    Departments findOneOldestBook();

    @Query(
            value = "SELECT SUM(b.pages) FROM Books b WHERE b.authorFname = ?1 AND b.authorLname = ?2"
    )
    Long totalPagesOfAuthor(String fName, String lName);

    List<Departments> findAllByPagesNot(Long page);

    List<Departments> findAllByReleasedYearGreaterThanEqualOrderByReleasedYearDesc(Long year);

    List<Departments> findAllByPagesBetween(Long from, Long to);

    List<Departments> findAllByReleasedYearIn(List<Integer> yearsList);

    @Query(
            value = "SELECT b.title, b.pages FROM Books b WHERE b.releasedYear in ?1"
    )
    List<String> findAllByReleasedYear(List<Integer> yearsList);*/

    /* All update methods */

    /* All delete methods */

}
