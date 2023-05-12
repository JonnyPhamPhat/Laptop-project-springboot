package phamngocphat.laptopproject.converter;

import org.springframework.stereotype.Component;
import phamngocphat.laptopproject.dto.LaptopDTO;
import phamngocphat.laptopproject.entity.LaptopEntity;

@Component
public class LaptopConverter {

    public LaptopEntity toEntity(LaptopDTO laptopDTO){
        LaptopEntity laptopEntity = new LaptopEntity();
        laptopEntity.setName(laptopDTO.getName());
        laptopEntity.setDrive(laptopDTO.getDrive());
        laptopEntity.setScreen(laptopDTO.getScreen());
        laptopEntity.setCard(laptopDTO.getCard());
        laptopEntity.setOperatingSystem(laptopDTO.getOperatingSystem());
        laptopEntity.setSize(laptopDTO.getSize());
        return laptopEntity;
    }

    public LaptopDTO toDTO(LaptopEntity laptopEntity){
        LaptopDTO laptopDTO = new LaptopDTO();
        if(laptopEntity.getId() != null){
            laptopDTO.setId(laptopEntity.getId());
        }
        laptopDTO.setName(laptopEntity.getName());
        laptopDTO.setDrive(laptopEntity.getDrive());
        laptopDTO.setScreen(laptopEntity.getScreen());
        laptopDTO.setCard(laptopEntity.getCard());
        laptopDTO.setOperatingSystem(laptopEntity.getOperatingSystem());
        laptopDTO.setSize(laptopEntity.getSize());
        return laptopDTO;
    }

    public LaptopEntity toEntity(LaptopDTO laptopDTO, LaptopEntity laptopEntity){
        laptopEntity.setId(laptopDTO.getId());
        laptopEntity.setName(laptopDTO.getName());
        laptopEntity.setDrive(laptopDTO.getDrive());
        laptopEntity.setScreen(laptopDTO.getScreen());
        laptopEntity.setCard(laptopDTO.getCard());
        laptopEntity.setOperatingSystem(laptopDTO.getOperatingSystem());
        laptopEntity.setSize(laptopDTO.getSize());
        return laptopEntity;
    }
}
