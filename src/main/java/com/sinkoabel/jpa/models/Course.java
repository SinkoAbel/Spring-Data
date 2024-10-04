package com.sinkoabel.jpa.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@Table(name = "courses")
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Data
@EqualsAndHashCode(callSuper = true)
public class Course extends BaseEntity {

    private String name;

    private String description;

    @ManyToMany
    @JoinTable(
        name = "course_authors",
        joinColumns = {
            @JoinColumn(name = "course_id")
        },
        inverseJoinColumns = {
            @JoinColumn(name = "author_id")
        }
    )
    private List<Author> authors;

    @OneToMany(mappedBy = "course")
    private List<Section> sections;
}
