package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "exhibits")
public class Exhibit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 50)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    private Material material;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "material_exhibit",
            joinColumns = @JoinColumn(name = "exhibit_id"),
            inverseJoinColumns = @JoinColumn(name = "material_id")
    )
    private List<Material> materials;

    @ManyToOne(fetch = FetchType.LAZY)
    private Author author;

    @ManyToOne(fetch = FetchType.LAZY)
    private Room room;

    @ManyToOne(fetch = FetchType.LAZY)
    private Technique technique;
}