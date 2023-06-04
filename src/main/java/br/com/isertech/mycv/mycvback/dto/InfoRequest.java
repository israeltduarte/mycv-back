package br.com.isertech.mycv.mycvback.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class InfoRequest {

    private final Name name;
    private final Location location;
    private String mainPosition;
    private LocalDate birthDate;
    private String email;
    private String contact;
    private List<String> socialMedia;
    private String introduction;

}
