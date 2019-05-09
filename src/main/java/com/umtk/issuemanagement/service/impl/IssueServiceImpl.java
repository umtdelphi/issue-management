package com.umtk.issuemanagement.service.impl;

import com.umtk.issuemanagement.Entity.Issue;
import com.umtk.issuemanagement.dto.IssueDto;
import com.umtk.issuemanagement.repo.IssueRepository;
import com.umtk.issuemanagement.service.IssueService;
import com.umtk.issuemanagement.util.TPage;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Arrays;

public class IssueServiceImpl implements IssueService {

    private final IssueRepository issueRepository;
    private final ModelMapper modelMapper;

    public IssueServiceImpl(IssueRepository issueRepository, ModelMapper modelMapper){
        this.issueRepository =  issueRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public IssueDto save(IssueDto issue) {
        if(issue.getDate()==null)
            throw new IllegalArgumentException("Issue date cannot be null");

        Issue issueDb = modelMapper.map(issue,Issue.class);

        issueDb =  issueRepository.save(issueDb);
        return modelMapper.map(issueDb,IssueDto.class);
    }

    @Override
    public IssueDto getById(Long id) {
        return null;
    }

    @Override
    public TPage<IssueDto> getAllPageable(Pageable pageable) {
        Page<Issue> data = issueRepository.findAll(pageable);
        TPage page = new TPage<IssueDto>();
        IssueDto[] dtos = modelMapper.map(data.getContent(),IssueDto[].class);
        page.setStat(data, Arrays.asList(dtos));
        return page ;
    }

    @Override
    public Boolean delete(IssueDto issue) {
        return null;
    }


/*    @Override
    public Issue save(Issue issue) {
        return issueRepository.save(issue);
    }

    @Override
    public Issue getById(Long id) {
        return issueRepository.getOne(id);
    }

    @Override
    public Page<Issue> getAllPageable(Pageable pageable) {
        return issueRepository.findAll(pageable);
    }

    @Override
    public Boolean delete(Long issueId) {
        issueRepository.deleteById(issueId);
        return Boolean.TRUE;
    }*/
}
