package br.com.isertech.mycv.mycvback.entity;

import br.com.isertech.mycv.mycvback.util.IserUUIDGenerator;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Curriculum implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "iser-uuid-generator")
    @GenericGenerator(
            name = "iser-uuid-generator",
            type = IserUUIDGenerator.class,
            parameters = @Parameter(name = "prefix", value = "CV")
    )
    private String id;

    @OneToOne(cascade = CascadeType.ALL)
    private Info info;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Education> education;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Certification> certification;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<WorkingExperience> workingExperience;

    private String skill;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Language> language;
}
