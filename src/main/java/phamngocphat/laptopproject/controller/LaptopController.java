package phamngocphat.laptopproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import phamngocphat.laptopproject.controller.output.Output;
import phamngocphat.laptopproject.dto.LaptopDTO;
import phamngocphat.laptopproject.entity.LaptopEntity;
import phamngocphat.laptopproject.service.ILaptopService;

import java.util.List;

@RestController
@RequestMapping("/laptop")
public class LaptopController {

    @Autowired
    private ILaptopService laptopService;


    @GetMapping
    public List<LaptopDTO> getAllLaptop(){
        return laptopService.getAll();
    }

//    @GetMapping
//    public Output paging(@RequestParam("page") int page, @RequestParam("limit") int limit){
//        Output output = new Output();
//        output.setPage(page);
//        Pageable pageable = PageRequest.of(page - 1, limit);
//        output.setListResult(laptopService.findAll(pageable));
//        output.setTotalPage((int) Math.ceil((double) (laptopService.totalItem()/limit)));
//        return output;
//    }

    @PostMapping
    public LaptopDTO insertLaptop(@RequestBody LaptopDTO laptopDTO){
        return laptopService.save(laptopDTO);
    }

    @PutMapping("/{id}")
    public LaptopDTO updateInfoLaptop(@RequestBody LaptopDTO laptopDTO, @PathVariable("id") long id){
        laptopDTO.setId(id);
        return laptopService.save(laptopDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteLaptop(@PathVariable("id") long id){
        laptopService.delete(id);
    }

    @GetMapping("/search")
    public ResponseEntity<List<LaptopEntity>> searchLaptop(@RequestParam("keyword") String keyword){
        return ResponseEntity.ok(laptopService.searchLaptop(keyword));
    }
}
