package com.umtk.issuemanagement.service.impl;

import com.umtk.issuemanagement.Entity.IssueHistory;
import com.umtk.issuemanagement.Entity.Project;
import com.umtk.issuemanagement.repo.IssueHistoryRepository;
import com.umtk.issuemanagement.repo.ProjectRepository;
import com.umtk.issuemanagement.service.IssueHistoryService;
import com.umtk.issuemanagement.service.ProjectService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class IssueHistoryServiceImpl implements IssueHistoryService {

    private final IssueHistoryRepository issueHistoryRepository;

    public IssueHistoryServiceImpl(IssueHistoryRepository issueHistory){
        this.issueHistoryRepository =  issueHistory;
    }


    @Override
    public IssueHistory save(IssueHistory issueHistory) {

        if (issueHistory.getDate()==null){
            throw new IllegalArgumentException("issue date cannot be null!");
        }
        issueHistory = issueHistoryRepository.save(issueHistory);
        return issueHistory;
    }

    @Override
    public IssueHistory getById(Long id) {
        return issueHistoryRepository.getOne(id);
    }

    @Override
    public Page<IssueHistory> getAllPageable(Pageable pageable) {
        return issueHistoryRepository.findAll(pageable);
    }

    @Override
    public Boolean delete(IssueHistory issueHistory) {
        issueHistoryRepository.delete(issueHistory);
        return Boolean.TRUE;
    }
}
