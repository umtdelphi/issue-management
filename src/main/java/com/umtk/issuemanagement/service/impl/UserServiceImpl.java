package com.umtk.issuemanagement.service.impl;

import com.umtk.issuemanagement.Entity.Project;
import com.umtk.issuemanagement.Entity.User;
import com.umtk.issuemanagement.repo.ProjectRepository;
import com.umtk.issuemanagement.repo.Userrepository;
import com.umtk.issuemanagement.service.ProjectService;
import com.umtk.issuemanagement.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    private final Userrepository userrepository;

    public UserServiceImpl(Userrepository userrepository){
        this.userrepository =  userrepository;
    }


    @Override
    public User save(User user_) {
        if(user_.getEmail()==null){
            throw  new IllegalArgumentException("User email cannot null");
        }
        return userrepository.save(user_);
    }

    @Override
    public User getById(Long id) {
        return userrepository.getOne(id);
    }

    @Override
    public Page<User> getAllPageable(Pageable pageable) {
        return userrepository.findAll(pageable);
    }

    @Override
    public User getByUsername(String username) {
        return userrepository.findByUsername(username);
    }
}
