package br.com.isertech.mycv.mycvback.entity;

import br.com.isertech.mycv.mycvback.dto.Location;
import br.com.isertech.mycv.mycvback.dto.Name;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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
public class Info implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "iser-uuid-generator")
    @GenericGenerator(
            name = "iser-uuid-generator",
            strategy = "br.com.isertech.mycv.mycvback.util.IserUUIDGenerator",
            parameters = @Parameter(name = "prefix", value = "Info")
    )
    private String id;

    @Embedded
    private Name name;

    @Embedded
    private Location location;
}
