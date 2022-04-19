package com.example.personal.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;


@Getter
@Setter
@ToString
@Document(collection = "Personal")
@Data
public class Personal {

    @Id
    @Transient
    public static final String SEQUENCE_NAME = "personal_sequence";
    private long id;

    private String name;
    private String lastname;
    private String email;
    private String dni;
    private int phone;
    private String clientype;
}
