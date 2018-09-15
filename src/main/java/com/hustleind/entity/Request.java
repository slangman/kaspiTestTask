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
    @SequenceGenerator(name = "requestSeq", sequenceName = "REQUEST_SEQUENCE", allocationSize = 0)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usersSeq")
    private int id;

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
