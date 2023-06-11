package com.example.javabackend.modules.user.controller;

import com.example.javabackend.entity.Dishes;
import com.example.javabackend.modules.user.DTO.*;
import com.example.javabackend.modules.user.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;



import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/accounts")

public class AccountController {
    @Autowired
    private AccountService accountsService;

    //Get All User
    @GetMapping("/all")
    public List<AccountsDTO> getAllAccount() {
        return accountsService.getAllAccount();
    }

    //Get By Id
    @GetMapping("id/{id}")
    public AccountsDTO getById(@PathVariable Long id) {
        return accountsService.getById(id);
    }

    //Create Account

    @PostMapping
    public AccountResponseDto createAccount(@ModelAttribute AccountsDTO accountsDTO) throws IOException {
        return this.accountsService.createAccount(accountsDTO);
    }

    @PostMapping("/web")
    public ModelAndView createAccountWeb(@ModelAttribute AccountsDTO accountsDTO) throws IOException {
        AccountResponseDto createAccount = this.accountsService.createAccount(accountsDTO);
        ModelAndView mav = new ModelAndView();
        mav.setViewName("redirect:/themnguoiquantri");
        mav.addObject("result", "success");
        return mav;
    }

    //Login
    @PostMapping("/login")
    public AccountResponseDto login(@RequestBody UserLoginDto user) throws Exception {
        return accountsService.login(user);
    }
    @PutMapping("/update")
    public UpdateAccountDto updateAccount(@RequestBody UpdateAccountDto accountsDTO) throws Exception {
        return accountsService.updateUser(accountsDTO);
    }

    @PutMapping("/password")
    public ChangePassDto changePass(@RequestBody ChangePassDto user) {
        return this.accountsService.changePass(user);
    }


}