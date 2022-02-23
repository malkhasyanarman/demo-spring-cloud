package com.madness.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Data
@Accessors(chain = true)
@Entity
@Table(name = "veeva_study_country")
public class FileEntity {

    @Id
    private Long id;
    private boolean deleted;

    private String name;
    private String updateDate;
    private String description;

}
