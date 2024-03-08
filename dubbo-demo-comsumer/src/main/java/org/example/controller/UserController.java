package org.example.controller;

import org.apache.dubbo.config.annotation.Reference;
import org.example.api.UserService;
import org.example.dto.UserAddDTO;
import org.example.dto.UserDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Reference(protocol = "dubbo", version = "1.0.0")
    private UserService userService;

    @GetMapping("/get")
    public UserDTO get(@RequestParam("id") Integer id) {
        return userService.get(id);
    }

    @PostMapping("/add")
    public Integer add(UserAddDTO addDTO) {
        return userService.add(addDTO);
    }

    @PostMapping("/find")
    public String find(UserAddDTO addDTO) {
        return userService.find(addDTO);
    }

}