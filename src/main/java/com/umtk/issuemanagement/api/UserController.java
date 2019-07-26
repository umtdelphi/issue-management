package com.umtk.issuemanagement.api;

import com.umtk.issuemanagement.dto.ProjectDto;
import com.umtk.issuemanagement.service.impl.ProjectServiceImpl;
import com.umtk.issuemanagement.service.impl.UserServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/Usr")
/* @RequestMapping(value = "/project", method = RequestMethod.GET) */
public class UserController {

    private final UserServiceImpl userServiceImpl ;
    private final ModelMapper modelMapper;

    public UserController(UserServiceImpl userServiceImp, ModelMapper modelMapper) {
       this.userServiceImpl = userServiceImp;
        this.modelMapper = modelMapper;
    }




}
