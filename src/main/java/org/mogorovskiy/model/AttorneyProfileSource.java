package org.mogorovskiy.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
public class AttorneyProfileSource {

    private String source;
    private String profileUrl;
}
