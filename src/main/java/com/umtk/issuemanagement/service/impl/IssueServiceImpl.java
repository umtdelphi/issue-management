package com.umtk.issuemanagement.service.impl;

import com.umtk.issuemanagement.Entity.Issue;
import com.umtk.issuemanagement.dto.IssueDto;
import com.umtk.issuemanagement.repo.IssueRepository;
import com.umtk.issuemanagement.service.IssueService;
import com.umtk.issuemanagement.util.TPage;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
@Service
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
        Issue p = issueRepository.getOne(id);
        return modelMapper.map(p,IssueDto.class);
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
    public Boolean delete(Long id) {
        issueRepository.deleteById(id);
        return true;
    }


    @Override
    public IssueDto update(Long id, IssueDto issuedto) {

        Issue issueDb = issueRepository.getOne(id);

        if (issueDb == null)
            throw new IllegalArgumentException("Project doesnt exist ID: "+id);
        issueDb.setDate(issuedto.getDate());
        issueDb.setDescription(issuedto.getDescription());
        issueDb.setDetails(issuedto.getDetails());
        issueDb.setIssueStatus(issuedto.getIssueStatus());
        issueRepository.save(issueDb);
        IssueDto p =  modelMapper.map(issueDb, IssueDto.class);

        return p;

    }


}
