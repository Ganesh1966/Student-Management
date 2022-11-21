package com.example.student.system.Entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String area;
    private String district;
    private String state;
    private String pincode;
    private AddressType addressType;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;


}
