package com.umtk.issuemanagement.Entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;


@MappedSuperclass
@Getter
@Setter
public class BaseEntity implements Serializable {

    @Column(name="ceated_at")
    @Temporal(TemporalType.TIMESTAMP)
        private Date createAt;

    @Column(name="ceated_by",length = 100)
        private String createBy;

    @Column(name="updated_at")
        private Date updateAt;

    @Column(name="updated_by",length=100)
        private String updateBy;

    @Column(name="status")
        private Boolean status;

}
