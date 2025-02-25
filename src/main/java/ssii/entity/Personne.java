package ssii.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
public class Personne {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    @Setter(AccessLevel.NONE) // la clé est auto-générée par la BD, On ne veut pas de "setter"
    private Integer matricule;

    @NonNull
    @Column(unique=true, length = 255)
    @Size(min = 1, max = 255)
    private String nom;

    @NonNull
    @Column(unique=true, length = 255)
    @Size(min = 1, max = 255)
    private String Prenom;

    @NonNull
    @Column(unique=true, length = 255)
    @Size(min = 1, max = 255)
    private String poste;

    @ToString.Exclude
    @OneToMany(mappedBy = "contributeur")
    private List<Participation> participations = new LinkedList<>();

    @OneToMany(mappedBy = "superieur")
    private List<Personne>subordonnes = new LinkedList<>();

    @ManyToOne
    private Personne superieur;



}
