package com.umtk.issuemanagement.service;

import com.umtk.issuemanagement.Entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {

    User save(User user_);

    User getById(Long id);

    Page<User> getAllPageable(Pageable pageable);

    User getByUsername(String username);

}

