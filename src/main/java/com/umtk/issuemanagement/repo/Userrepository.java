package com.umtk.issuemanagement.repo;

import com.umtk.issuemanagement.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Userrepository extends JpaRepository<User,Long> {

        User findByUsername(String username);
        User findByEmail(String email_);
}
