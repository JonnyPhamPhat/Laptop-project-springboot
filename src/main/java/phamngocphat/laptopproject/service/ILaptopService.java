package phamngocphat.laptopproject.service;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import phamngocphat.laptopproject.dto.LaptopDTO;
import phamngocphat.laptopproject.entity.LaptopEntity;

import java.util.List;

@Service
public interface ILaptopService {
    List<LaptopDTO> getAll(String keyword);
    List<LaptopEntity> listLaptopEntity();
    LaptopDTO save(LaptopDTO laptopDTO);
    void delete(long id);
    int totalItem();
    List<LaptopDTO> findAll(Pageable pageable);
}
