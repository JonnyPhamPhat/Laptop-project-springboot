package phamngocphat.laptopproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import phamngocphat.laptopproject.entity.LaptopEntity;

import java.util.List;

public interface LaptopRepository extends JpaRepository<LaptopEntity, Long> {
    @Query("SELECT p FROM LaptopEntity p WHERE CONCAT(p.name, ' ', p.drive, ' ', p.card, ' ', p.size) LIKE %?1%")
    List<LaptopEntity> searchLaptop(String keyword);
}
