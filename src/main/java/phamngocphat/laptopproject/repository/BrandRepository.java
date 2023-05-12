package phamngocphat.laptopproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import phamngocphat.laptopproject.entity.BrandEntity;

public interface BrandRepository extends JpaRepository<BrandEntity, Long> {
    BrandEntity findByCode(String code);
}
