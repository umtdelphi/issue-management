package com.umtk.issuemanagement.api;

import com.umtk.issuemanagement.Entity.Project;
import com.umtk.issuemanagement.dto.ProjectDto;
import com.umtk.issuemanagement.service.impl.ProjectServiceImpl;
import com.umtk.issuemanagement.util.ApiPaths;
import com.umtk.issuemanagement.util.TPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.Lombok;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping(ApiPaths.ProjectCtrl.Ctrl_)
@Api(value = ApiPaths.ProjectCtrl.Ctrl_ ,description = "Project APIs")
@Slf4j
@CrossOrigin
/* @RequestMapping(value = "/project", method = RequestMethod.GET) */
public class ProjectController {

    private final ProjectServiceImpl projectServiceImlp;

    public ProjectController(ProjectServiceImpl projectServiceImlp) {
        this.projectServiceImlp = projectServiceImlp;
    }

    @GetMapping("/pagination")
    @ApiOperation(value = "Get By Pagination Operation",response = ProjectDto.class)
    public ResponseEntity<TPage<ProjectDto>> getAllByPagination(Pageable pageable){
        TPage<ProjectDto> respnsy = projectServiceImlp.getAllPageable(pageable);
        return  ResponseEntity.ok(respnsy);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get By ID Operation",response = ProjectDto.class)
    public ResponseEntity<ProjectDto> getById(@PathVariable("id") Long id){
        log.info("ProjectController-> GetByID ");
        log.debug("ProjectController-> GetByID -> PARAM:" + id);
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
