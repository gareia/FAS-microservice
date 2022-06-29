package com.example.usermicroservice.resource;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class SaveProfileResource {

    @NotNull
    @NotBlank
    private String firstNames;

    @NotNull
    @NotBlank
    private String lastNames;

    @NotNull
    @NotBlank
    private int cellphone;

    @NotNull
    @NotBlank
    private String address;

    @NotNull
    @NotBlank
    private String size;
}
