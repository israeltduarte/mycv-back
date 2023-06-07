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

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WorkingExperience implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "iser-uuid-generator")
    @GenericGenerator(
            name = "iser-uuid-generator",
            type = IserUUIDGenerator.class,
            parameters = @Parameter(name = "prefix", value = "XP")
    )
    private String id;
    private String company;
    private String startDate;
    private String endDate;
    private String title;
    @OneToOne(cascade = CascadeType.ALL)
    private Project project;
}
