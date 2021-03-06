package entity;

import entity.enums.Positions;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "workers")
public class Worker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "position")
    private Positions position;

    @Column(name = "name", length = 50)
    private String name;

    @Column(name = "surname", length = 50)
    private String surname;

    @OneToMany(mappedBy = "worker", fetch = FetchType.EAGER)
    private List<Excursion> excursions = new ArrayList<>();

    @Override
    public String toString() {
        return "Worker{" +
                "id=" + id +
                ", position=" + position +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
