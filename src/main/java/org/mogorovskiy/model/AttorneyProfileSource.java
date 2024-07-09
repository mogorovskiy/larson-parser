package org.mogorovskiy.model;

import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
public class AttorneyProfileSource {

    private String source;
    private String profileUrl;
}
