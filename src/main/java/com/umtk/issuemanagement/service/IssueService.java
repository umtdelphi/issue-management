package com.umtk.issuemanagement.service;

import com.umtk.issuemanagement.Entity.Issue;
import com.umtk.issuemanagement.dto.IssueDto;
import com.umtk.issuemanagement.util.TPage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IssueService {

    IssueDto save(IssueDto issue);

    IssueDto getById(Long id);

    TPage<IssueDto> getAllPageable(Pageable pageable);

    Boolean delete(IssueDto issue);
}

