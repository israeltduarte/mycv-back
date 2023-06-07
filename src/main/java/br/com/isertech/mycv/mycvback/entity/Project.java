package br.com.isertech.mycv.mycvback.entity;

import br.com.isertech.mycv.mycvback.util.IserUUIDGenerator;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import java.io.Serializable;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Project implements Serializable {

    @Id
    @GeneratedValue(generator = "iser-uuid-generator")
    @GenericGenerator(
            name = "iser-uuid-generator",
            type = IserUUIDGenerator.class,
            parameters = @Parameter(name = "prefix", value = "PROJ")
    )
    private String id;
    @Column(length = 1024)
    private String description;
    private String stack;
}
