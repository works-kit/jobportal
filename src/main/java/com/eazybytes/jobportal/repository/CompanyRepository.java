package com.eazybytes.jobportal.repository;

import com.eazybytes.jobportal.entity.Company;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository // Optional
public interface CompanyRepository extends JpaRepository<Company, Long> {

    @Query("SELECT DISTINCT c FROM Company c JOIN FETCH c.jobs j WHERE j.status = :status")
    List<Company> findCompaniesWithJobsByStatus(@Param("status") String status);

    @Query(value = "SELECT DISTINCT c.* FROM companies c JOIN jobs j ON c.id = j.company_id WHERE j.status = ?", nativeQuery = true)
    List<Company> findAllCompanyWithJobsActiveNativeSQL(String status);

    List<Company> fetchCompaniesWithJobsByStatus(String status);

    List<Company> fetchCompaniesWithJobsByStatusNative(String status);
}
