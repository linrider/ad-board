package ua.lazin.vladyslav.entity;

import java.util.List;

import javax.persistence.*;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Table
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Rubric {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "rubric_id")
    int id;

    @Version
    int version;

    @Column(name = "rubric_name")
    String name;
}

/**
 * {
 * 	"id": 0,
 * 	"name": "Cars"
 * }
 *
 * {
 * 	"id": 5,
 * 	"name": "Furniture",
 * 	"ads": []
 * }
 */
