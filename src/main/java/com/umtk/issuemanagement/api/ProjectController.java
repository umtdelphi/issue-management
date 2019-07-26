package com.umtk.issuemanagement.api;

import com.umtk.issuemanagement.Entity.Project;
import com.umtk.issuemanagement.dto.ProjectDto;
import com.umtk.issuemanagement.service.impl.ProjectServiceImpl;
import com.umtk.issuemanagement.util.ApiPaths;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sun.awt.SunHints;

import javax.validation.Valid;

@RestController
@RequestMapping(ApiPaths.ProjectCtrl.Ctrl_)
@Api(value = ApiPaths.ProjectCtrl.Ctrl_ ,description = "Project APIs")
/* @RequestMapping(value = "/project", method = RequestMethod.GET) */
public class ProjectController {

    private final ProjectServiceImpl projectServiceImlp;

    public ProjectController(ProjectServiceImpl projectServiceImlp) {
        this.projectServiceImlp = projectServiceImlp;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get By ID Operation",response = ProjectDto.class)
    public ResponseEntity<ProjectDto> getById(@PathVariable("id") Long id){
        ProjectDto projectDto =  projectServiceImlp.getById(id);
        return  ResponseEntity.ok(projectDto);
    }

    @PostMapping
    @ApiOperation(value = "Create Operation",response = ProjectDto.class)
    public ResponseEntity<ProjectDto> createProject(@Valid @RequestBody ProjectDto project){

        return ResponseEntity.ok(projectServiceImlp.save(project));
    }

    //@RequestMapping(path = "/update",method = RequestMethod.PUT)
    @PutMapping("/{id}")
    @ApiOperation(value = "Update Operation",response = ProjectDto.class)
    public ResponseEntity<ProjectDto> updateProject(@PathVariable("id") Long id, @Valid @RequestBody ProjectDto project){

       return ResponseEntity.ok(projectServiceImlp.update(id,project))  ;

    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete Operation",response = Boolean.class)
    public ResponseEntity<Boolean>  delete(@PathVariable(value ="id" , required = true ) Long id) {

        return ResponseEntity.ok(projectServiceImlp.delete(id));
    }


}
