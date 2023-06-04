package br.com.isertech.mycv.mycvback.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Data
public class InfoRequest {

    @NotNull
    private Name name;
    private Location location;
    private String mainPosition;
    private LocalDate birthdate;
    @NotNull
    private String email;
    private String contact;
    private List<String> socialMedia;
    private String introduction;

}
