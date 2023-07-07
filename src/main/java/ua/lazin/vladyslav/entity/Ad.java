package ua.lazin.vladyslav.entity;
import java.time.LocalDate;

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
public class Ad {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ad_id")
    int id;

    String subject;

    @Column(name = "publication_date")
    LocalDate publicationDate;

    float price;

    @Column(name = "ad_text")
    String adText;

    @ManyToOne
        @JoinColumn(name = "FK_Ad_Rubric")
    Rubric rubric;
    
    @ManyToOne
    @JoinColumn(name = "FK_Author_Rubric")
    Author author;
}
