package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "techniques")
public class Technique {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, length = 20)
    private String name;

    @OneToMany(mappedBy = "technique")
    private List<Exhibit> exhibits = new ArrayList<>();

    @Override
    public String toString() {
        return "Technique{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}