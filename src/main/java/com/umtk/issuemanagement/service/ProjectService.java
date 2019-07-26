package com.umtk.issuemanagement.service;

import com.umtk.issuemanagement.Entity.Project;
import com.umtk.issuemanagement.dto.ProjectDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProjectService {

    ProjectDto save(ProjectDto project);

    ProjectDto getById(Long Id);

    ProjectDto getByProjectCode(String projectCode);

    List<Project> getByProjectCodeContains(String projectCode);

    Page<Project> getAllPageable(Pageable pageable);

    Boolean delete(Long Id);

    Boolean delete(ProjectDto project);

    ProjectDto update(Long Id, ProjectDto project);
}

