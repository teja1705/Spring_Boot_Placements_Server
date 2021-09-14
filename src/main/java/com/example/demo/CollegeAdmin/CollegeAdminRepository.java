package com.example.demo.CollegeAdmin;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public interface CollegeAdminRepository extends JpaRepository<CollegeAdmin, Long>
{

    Optional<CollegeAdmin> findByEmail(String email);
    
}
