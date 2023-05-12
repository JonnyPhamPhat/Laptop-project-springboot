package phamngocphat.laptopproject.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "laptop")
public class LaptopEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "drive")
    private String drive;
    @Column(name = "screen")
    private String screen;
    @Column(name = "card")
    private String card;
    @Column(name = "operatingsystem")
    private String operatingSystem;
    @Column(name = "size")
    private String size;

    @ManyToOne
    @JoinColumn(name = "brand_code")
    private BrandEntity brand;
}
