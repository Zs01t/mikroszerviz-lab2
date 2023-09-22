package com.example.mikroszerviz_lab2;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Name {
    //megszorítás
    @NotEmpty
    @Schema(description = "First name")
    private String fname;
    @NotEmpty

    @Schema(description = "Last name")
    private String lname;


}
