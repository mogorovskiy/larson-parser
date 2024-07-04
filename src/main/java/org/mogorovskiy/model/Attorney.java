package org.mogorovskiy.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Attorney {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;
    private String title;
    private String bio;
    private String linkedinUrl;
    private String photoUrl;
    private String profileUrl;
    private List<String> locations;
    private String email;
    private String phone;
    private List<String> practiceAreas;
    private List<String> specialties;
}
