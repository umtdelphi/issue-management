package com.umtk.issuemanagement.repo;

import com.umtk.issuemanagement.Entity.IssueHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueHistoryRepository extends JpaRepository<IssueHistory,Long> {

}
