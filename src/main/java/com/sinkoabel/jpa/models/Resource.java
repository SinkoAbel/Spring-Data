package com.sinkoabel.jpa.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "resources")
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Data
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS) // copies the fields of parent class into a new data table. video table inherits Resource's fields.
//@Inheritance(strategy = InheritanceType.JOINED)
//@DiscriminatorColumn(name = "resource_type") -> only with SINGLE_TABLE inheritance
public class Resource {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private int size;

    private String url;

    @OneToOne
    @JoinColumn(name = "lecture_id")
    private Lecture lecture;
}
