package com.umtk.issuemanagement.dto;

import com.umtk.issuemanagement.Entity.IssueStatus;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel(value = "Issue Data Transfer Object")
public class IssueDto {
    @ApiModelProperty(value = "Issue ID",required = true)
    private Long id;
    @ApiModelProperty(value = "Description of Issue",required = true)
    private String description;
    @ApiModelProperty(value = "detail of Issue",required = true)
    private String details;
    @ApiModelProperty(value = "Date of Issue",required = true)
    private Date date;
    @ApiModelProperty(value = "Status of Issue",required = true)
    private IssueStatus issueStatus;
    @ApiModelProperty(value = "User Assignee",required = true)
    private UserDto  assignee;
}
