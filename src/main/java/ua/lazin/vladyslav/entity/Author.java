package ua.lazin.vladyslav.entity;

import java.util.Set;

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
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "author_id")
    int id;

     @Version
     int version;

    @Column(name = "first_name")
    String firstName;

    @Column(name = "sur_name")
    String surName;

    @OneToMany(cascade = { CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE })
    @JoinTable(name = "author_phone", joinColumns = @JoinColumn(name = "fk_author_id"),
        inverseJoinColumns = @JoinColumn(name = "phone_fk_id", unique = true))
    Set<Phone> phones;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE })
    @JoinColumn(name = "FK_Author_Address")
    Address address;

    @OneToOne(cascade = { CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE })
    @JoinColumn(name = "FK_Author_Email", unique = true)
    Email email;

}
