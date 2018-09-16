package com.hustleind.entity;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "request")
public class Request {
    @Getter
    @Setter
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    @NonNull
    private String mobileNumber;

    @Getter
    @Setter
    @NotNull
    private String firstName;

    @Getter
    @Setter
    @NotNull
    private String secondName;

    @Getter
    @Setter
    private String middleName;

    @Getter
    @Setter
    @NotNull
    private String companyName;

    @Getter
    @Setter
    private String companyNameAbb;

    @Getter
    @Setter
    @NotNull
    private String bin;

}
