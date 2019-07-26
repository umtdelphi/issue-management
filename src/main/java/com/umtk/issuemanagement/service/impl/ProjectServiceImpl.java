package com.umtk.issuemanagement.service.impl;

import com.umtk.issuemanagement.Entity.Project;

import com.umtk.issuemanagement.dto.ProjectDto;
import com.umtk.issuemanagement.repo.ProjectRepository;
import com.umtk.issuemanagement.service.ProjectService;
import org.h2.mvstore.DataUtils;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final ModelMapper modelMapper;

    public ProjectServiceImpl(ProjectRepository projectRepository, ModelMapper modelMapper){
        this.projectRepository =  projectRepository;

        this.modelMapper = modelMapper;
    }

    @Override
    public ProjectDto save(ProjectDto project) {

        Project projectCheck = projectRepository.getByProjectCode(project.getProjectCode());
        if (projectCheck != null)
            throw new  IllegalArgumentException("ProjectCode Already Exist");

        if(project.getProjectCode()==null){
            throw new IllegalArgumentException("Project Code can not be null!");
        }
        Project p = modelMapper.map(project, Project.class);
        p =  projectRepository.save(p);
        project.setId(p.getId());
        return  project;
    }

    @Override
    public ProjectDto getById(Long id) {
        Project p = projectRepository.getOne(id);
        return modelMapper.map(p,ProjectDto.class);
    }

    @Override
    public ProjectDto getByProjectCode(String projectCode) {
        return null;
    }


    @Override
    public List<Project> getByProjectCodeContains(String projectCode) {
        return null;
    }

    @Override
    public Page<Project> getAllPageable(Pageable pageable) {
        return null;
    }

    @Override

    public Boolean delete(ProjectDto project) {
        return null;
    }


    public Boolean delete(Long Id) {
        projectRepository.deleteById(Id);
        return true;
    }

    @Override
    public ProjectDto update(Long Id, ProjectDto project) {

        Project projectdb = projectRepository.getOne(Id);

        if (projectdb == null)
            throw new IllegalArgumentException("Project doesnt exist ID:"+Id);

        Project projectCheck = projectRepository.getByProjectCodeAndIdNot(project.getProjectCode(),Id);

        if (projectCheck != null )
            throw new  IllegalArgumentException("ProjectCode Already Exist");

        projectdb.setProjectCode(project.getProjectCode());
        projectdb.setProjectName(project.getProjectName());

        projectRepository.save(projectdb);

        return modelMapper.map(projectdb,ProjectDto.class);
    }



}
