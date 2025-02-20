package org.mogorovskiy.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import java.util.List;

@Entity
@Getter
@Setter
public class Attorney {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;
    private String title;

    @Lob
    private String bio;
    private String linkedinUrl;
    private String photoUrl;
    private String profileUrl;

    @ElementCollection
    private List<String> locations;

    private String email;
    private String phone;

    @ElementCollection
    private List<String> practiceAreas;
}
