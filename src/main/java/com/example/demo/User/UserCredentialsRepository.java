// package com.example.demo.User;

// import java.util.List;


// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Modifying;
// import org.springframework.data.jpa.repository.Query;
// import org.springframework.stereotype.Repository;
// import org.springframework.transaction.annotation.Transactional;

// @Repository
// @Transactional(readOnly = true)
// public interface UserCredentialsRepository extends JpaRepository<UserCredentials, Long>
// {

//     @Transactional
//     @Modifying
//     @Query("SELECT IF(COUNT(*)=1,true,false) as response FROM UserCredentials WHERE id = ?1 AND email = ?2 AND password = ?3 AND token = ?4")
//     Boolean findUser(Long id, String email, String password, String token);
    
// }
