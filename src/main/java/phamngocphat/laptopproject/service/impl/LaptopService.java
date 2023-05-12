package phamngocphat.laptopproject.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import phamngocphat.laptopproject.converter.LaptopConverter;
import phamngocphat.laptopproject.dto.LaptopDTO;
import phamngocphat.laptopproject.entity.BrandEntity;
import phamngocphat.laptopproject.entity.LaptopEntity;
import phamngocphat.laptopproject.repository.BrandRepository;
import phamngocphat.laptopproject.repository.LaptopRepository;
import phamngocphat.laptopproject.service.ILaptopService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LaptopService implements ILaptopService {

    @Autowired
    private LaptopRepository laptopRepository;

    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private LaptopConverter laptopConverter;

    @Override
    public List<LaptopDTO> getAll() {
        return ((List<LaptopEntity>) laptopRepository.findAll()).stream().map(
            this::getAllLap
        ).collect(Collectors.toList());
    }

    @Override
    public List<LaptopEntity> listLaptopEntity() {
        return laptopRepository.findAll();
    }

    private LaptopDTO getAllLap(LaptopEntity laptopEntity){
        return laptopConverter.toDTO(laptopEntity);
    }

    @Override
    public LaptopDTO save(LaptopDTO laptopDTO) {
        LaptopEntity laptopEntity =new LaptopEntity();
        if(laptopEntity != null){
            if(laptopDTO.getId() != null){
                LaptopEntity oldLap = laptopRepository.getById(laptopDTO.getId());
                laptopEntity = laptopConverter.toEntity(laptopDTO, oldLap);
            }
            else{
                laptopEntity = laptopConverter.toEntity(laptopDTO);
            }
            BrandEntity brandEntity = brandRepository.findByCode(laptopDTO.getBrandCode());
            laptopEntity.setBrand(brandEntity);
            laptopEntity = laptopRepository.save(laptopEntity);
            return laptopConverter.toDTO(laptopEntity);
        }
            return null;
    }

    @Override
    public void delete(long id) {
        LaptopDTO laptopDTO = new LaptopDTO();
        if(id >= 1){
            LaptopEntity laptopEntity = laptopRepository.getById(id);
            if(laptopDTO != null){
                laptopRepository.delete(laptopEntity);
            }
        }
    }

    @Override
    public int totalItem() {
        return (int) laptopRepository.count();
    }

    @Override
    public List<LaptopDTO> findAll(Pageable pageable) {
        List<LaptopDTO> result = new ArrayList<>();
        List<LaptopEntity> laptopEntities = laptopRepository.findAll(pageable).getContent();
        for(LaptopEntity item : laptopEntities){
        LaptopDTO laptopDTO = laptopConverter.toDTO(item);
            result.add(laptopDTO);
        }
        return result;
    }

    @Override
    public List<LaptopEntity> searchLaptop(String keyword) {
        if(keyword != null){
            return laptopRepository.searchLaptop(keyword);
        }
        return laptopRepository.findAll();
    }
}
