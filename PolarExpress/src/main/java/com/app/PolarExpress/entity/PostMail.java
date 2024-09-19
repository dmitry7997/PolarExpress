package com.app.PolarExpress.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Post_mail")
public class PostMail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String recipient;

    @Column
    private String type;

    @Column
    private Integer recipient_postcode;

    @Column
    private String recipient_address;

    @Column
    private String status;
}
