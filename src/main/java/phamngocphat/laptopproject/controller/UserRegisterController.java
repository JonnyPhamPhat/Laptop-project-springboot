package phamngocphat.laptopproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import phamngocphat.laptopproject.dto.UserRegisterDTO;
import phamngocphat.laptopproject.service.IUserService;

@Controller
@RequestMapping("/register")
public class UserRegisterController {

    @Autowired
    private IUserService userService;

    @ModelAttribute("user")
    public UserRegisterDTO userRegisterDTO(){
        return new UserRegisterDTO();
    }

    @GetMapping
    public String ShowUserRegister(){
        return "register";
    }

    @PostMapping
    public String RegistrationUser(UserRegisterDTO userRegisterDTO){
        userService.createUser(userRegisterDTO);
        return "redirect:/register?exit";
    }

}
