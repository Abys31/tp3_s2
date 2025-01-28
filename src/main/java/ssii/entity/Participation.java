package ssii.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.PositiveOrZero;
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

public class Participation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    @Setter(AccessLevel.NONE) // la clé est auto-générée par la BD, On ne veut pas de "setter"
    private Integer id;

    @NonNull
    @Column(unique=true, length = 255)
    @Size(min = 1, max = 255)
    private String role;

    @Basic(optional = false)
    @Column(nullable = false)
    @NonNull
    @PositiveOrZero(message = "La quantité ne peut pas être négative")
    private Integer pourcentage;

    @JoinColumn(nullable = false)
    @ManyToOne(optional = false)
    @NonNull
    private Projet affectation;

    @JoinColumn(nullable = false)
    @ManyToOne(optional = false)
    @NonNull
    private Personne contributeur;
}
