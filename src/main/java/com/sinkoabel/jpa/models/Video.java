package com.sinkoabel.jpa.models;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Polymorphism;
import org.hibernate.annotations.PolymorphismType;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@EqualsAndHashCode(callSuper = true)
@Polymorphism(type = PolymorphismType.EXPLICIT)
// @PrimaryKeyJoinColumn(name = "video_id") -> Works with JOINED inheritance
// @DiscriminatorValue("V") -> Not needed, works with SINGLE_TABLE inheritance
public class Video extends Resource {
    private int length;
}
