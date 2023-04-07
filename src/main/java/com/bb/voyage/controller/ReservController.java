package com.bb.voyage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bb.voyage.dto.PkgDto;
import com.bb.voyage.dto.ReservDto;
import com.bb.voyage.service.ReservSerivce;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class ReservController {
    @Autowired
    ReservSerivce reservService;

    @GetMapping("/reservation/reservation")
    public String reservation(){
        return "/reservation/reservation";
    }

    @PostMapping("/reservProcess")
    public String insertReserv(ReservDto reservDto, RedirectAttributes redirectAttributes){
        log.info("{reservDto}",reservDto);
        int result = reservService.insertReserv(reservDto);
            return "redirect:/member/info";
    }



    @GetMapping("/packageSerch")
    @ResponseBody
    public List<PkgDto> packageSearch(PkgDto pkgDto){
        return reservService.getFilteredPkg(pkgDto);
    }
}
