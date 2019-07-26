package com.umtk.issuemanagement.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;
@Data
@ApiModel(value = "Project Data Transfer Object")
public class ProjectDto {
    @ApiModelProperty(value = "Project ID")
    private Long Id;
    @NotNull
    @ApiModelProperty(value = "Name of Project",required = true)
    private String projectName;
    @NotNull
    @ApiModelProperty(value = "Code of Project",required = true)
    private String projectCode;

}
