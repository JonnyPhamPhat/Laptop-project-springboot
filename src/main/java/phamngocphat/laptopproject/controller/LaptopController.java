package phamngocphat.laptopproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import phamngocphat.laptopproject.controller.output.Output;
import phamngocphat.laptopproject.dto.LaptopDTO;
import phamngocphat.laptopproject.entity.LaptopEntity;
import phamngocphat.laptopproject.service.ILaptopService;

import java.util.List;

@Controller
public class LaptopController {

    @Autowired
    private ILaptopService laptopService;

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/")
    public String ViewHomePage(Model model, @Param("keyword") String keyword){
        List<LaptopDTO> listLaptopDTO = laptopService.getAll(keyword);
        model.addAttribute("listLaptopDTO", listLaptopDTO);
        model.addAttribute("keyword", keyword);
        return "index";
    }

    @RequestMapping("/newLaptop")
    public String ViewAddLaptop(Model model){
        LaptopDTO laptopDTO = new LaptopDTO();
        model.addAttribute("laptopDTO", laptopDTO);
        return "new_laptop";
    }

    @PostMapping("/create")
    public String CreateNewLaptop(@ModelAttribute("laptopDTO") LaptopDTO laptopDTO){
        laptopService.save(laptopDTO);
        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView ViewEditPage(@PathVariable(name = "id") Long id){
        ModelAndView modelAndView = new ModelAndView("edit_laptop");
        LaptopDTO laptopDTO = new LaptopDTO();
        laptopDTO.setId(id);
        modelAndView.addObject("laptopDTO", laptopDTO);
        return modelAndView;
    }

    @RequestMapping("/delete/{id}")
    public String DeleteLaptop(@PathVariable(name = "id") Long id){
        laptopService.delete(id);
        return "redirect:/";
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
}
