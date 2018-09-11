package com.hustleind.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "request")
public class Request {
    @Getter
    @Setter
    @Id
    @SequenceGenerator(name = "taskSeq", sequenceName = "TASK_SEQUENCE", allocationSize = 0)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usersSeq")
    private int id;

    @Getter
    @Setter
    private String mobileNumber;

    @Getter
    @Setter
    private String firstName;

    @Getter
    @Setter
    private String secondName;

    @Getter
    @Setter
    private String middleName;

    @Getter
    @Setter
    private String companyName;

    @Getter
    @Setter
    private String companyNameAbb;

    @Getter
    @Setter
    private String bin;

}
