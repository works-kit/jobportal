package com.eazybytes.jobportal.repository;

import com.eazybytes.jobportal.entity.JobPortalUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JobPortalUserRepository extends JpaRepository<JobPortalUser, Long> {

    Optional<JobPortalUser> readUserByEmailOrMobileNumber(String email, String mobileNumber);
    // select * from job_portal_user where email = ? or mobile_number = ?;

    Optional<JobPortalUser> findJobPortalUserByEmail(String email);
    // select * from job_portal_user where email = ?;
}