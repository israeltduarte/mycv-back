package br.com.isertech.mycv.mycvback.entity;

import br.com.isertech.mycv.mycvback.dto.Location;
import br.com.isertech.mycv.mycvback.dto.Name;
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
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Info implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "iser-uuid-generator")
    @GenericGenerator(
            name = "iser-uuid-generator",
            type = IserUUIDGenerator.class,
            parameters = @Parameter(name = "prefix", value = "INFO")
    )
    private String id;
    @Embedded
    private Name name;
    @Embedded
    private Location location;
    private String mainPosition;
    private LocalDate birthdate;
    private String email;
    private String contact;
    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> socialMedia;
    @Column(length = 1024)
    private String introduction;
}
