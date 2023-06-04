package br.com.isertech.mycv.mycvback.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Name {

    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    private String fullName;

}
