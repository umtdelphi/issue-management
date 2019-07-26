package com.umtk.issuemanagement.api;

import com.umtk.issuemanagement.dto.IssueDto;
import com.umtk.issuemanagement.service.impl.IssueServiceImpl;
import com.umtk.issuemanagement.util.ApiPaths;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(ApiPaths.IssurCtrl.Ctrl_)
/* @RequestMapping(value = "/project", method = RequestMethod.GET) */
@Api(value = ApiPaths.IssurCtrl.Ctrl_ ,description = "Project APIs")
public class IssueController {

    private final IssueServiceImpl issueServiceImlp;
    private final ModelMapper modelMapper;

    public IssueController(IssueServiceImpl issueServiceImlp,ModelMapper modelMapper) {
        this.issueServiceImlp = issueServiceImlp;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get By ID Operation",response = IssueDto.class)
    public ResponseEntity<IssueDto> getById(@PathVariable("id") Long id){
        IssueDto issueDto =  issueServiceImlp.getById(id);
        return  ResponseEntity.ok(issueDto);
    }

    @PostMapping
    @ApiOperation(value = "Create Operation",response = IssueDto.class)
    public ResponseEntity<IssueDto> createProject(@Valid @RequestBody IssueDto issueDto){

        return ResponseEntity.ok(issueServiceImlp.save(issueDto));
    }

    //@RequestMapping(path = "/update",method = RequestMethod.PUT)
    @PutMapping("/{id}")
    @ApiOperation(value = "Update Operation",response = IssueDto.class)
    public ResponseEntity<IssueDto> updateIssue(@PathVariable("id") Long id, @Valid @RequestBody IssueDto issueDto){

        return ResponseEntity.ok(issueServiceImlp.update(id,issueDto))  ;

    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete Operation",response = Boolean.class)
    public ResponseEntity<Boolean>  delete(@PathVariable(value ="id" , required = true ) Long id) {

        return ResponseEntity.ok(issueServiceImlp.delete(id));
    }


}
