package com.example.graphql.demo.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="player")
@Getter
@Setter
public class Player implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length = 30 , name="name")
    private String name;
    @Column(length = 30 , name="last_name")
    private String lastName;
    @Column(length =3 , name="position")
    private String position;

}
