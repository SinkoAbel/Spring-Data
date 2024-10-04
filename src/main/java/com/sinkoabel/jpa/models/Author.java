package com.sinkoabel.jpa.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@Table(name = "authors")
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Data
@EqualsAndHashCode(callSuper = true)
@NamedQuery(
    name = "Author.findByNamedQuery",
    query = "select a from Author a where a.age >= :age"
)
public class Author extends BaseEntity {

    @Column(
        name = "first_name",
        nullable = false,
        length = 60
    )
    private String firstName;

    @Column(
        name = "last_name",
        nullable = false,
        length = 60
    )
    private String lastName;

    @Column(
        unique = true,
        nullable = false
    )
    private String email;

    private int age;

    @ManyToMany(mappedBy = "authors", fetch = FetchType.EAGER)
    private List<Course> courses;
}
