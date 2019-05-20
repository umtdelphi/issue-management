package com.umtk.issuemanagement.api;

import com.umtk.issuemanagement.dto.ProjectDto;
import com.umtk.issuemanagement.service.impl.ProjectServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/project")
public class ProjectController {

    private final ProjectServiceImpl projectServiceImlp;

    public ProjectController(ProjectServiceImpl projectServiceImlp) {
        this.projectServiceImlp = projectServiceImlp;
    }

    @GetMapping("/{id]")
    public ResponseEntity<ProjectDto> getById(@PathVariable("id") Long id){
        ProjectDto projectDto =  projectServiceImlp.getById(id);
        return  ResponseEntity.ok(projectDto);
    }

}
