package com.umtk.issuemanagement.repo;

import com.umtk.issuemanagement.Entity.Issue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueRepository extends JpaRepository<Issue,Long> {


}
