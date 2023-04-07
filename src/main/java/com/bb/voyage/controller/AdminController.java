package com.bb.voyage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bb.voyage.dto.PkgDto;
import com.bb.voyage.service.ReservSerivce;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    ReservSerivce reservService;

    @GetMapping("/adminPkg")
    public String adminPkg(){
        return "/admin/adminPkg";
    }

    @PostMapping("/insertPkg")
    public String insertPkg(PkgDto pkgDto, RedirectAttributes redirectAttributes){
        log.info("{}",pkgDto);
        int result = reservService.insertPkg(pkgDto);
            return "redirect:/member/info";
    }
}
