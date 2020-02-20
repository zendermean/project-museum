package entity;

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
@Table(name = "rooms")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "number", unique = true)
    private Integer number;

    @Column(name = "floor")
    private Integer floor;

    @OneToMany(mappedBy = "room", fetch = FetchType.LAZY)
    private List<Exhibit> exhibits = new ArrayList<>();
}
