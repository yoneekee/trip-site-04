package com.bb.voyage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
    @GetMapping("/package/pkgkorea")
    public String pkgkorea(){
        return "/package/pkgkorea";
    }
    @GetMapping("/package/pkgjapan")
    public String pkgjapan(){
        return "/package/pkgjapan";
    }
    @GetMapping("/package/pkgchina")
    public String pkgchina(){
        return "/package/pkgchina";
    }
    
    @GetMapping("/company/companyinfo")
    public String companyinfo(){
        return "/company/companyinfo";
    }
    @GetMapping("/company/companypolicy")
    public String companypolicy(){
        return "/company/companypolicy";
    }
    @GetMapping("/company/companyprofile")
    public String companyprofile(){
        return "/company/companyprofile";
    }
    @GetMapping("/contact/contact")
    public String contact(){
        return "/contact/contact";
    }
    @GetMapping("/contact/reservation")
    public String reservation(){
        return "/contact/reservation";
    }
    @GetMapping("/country/china")
    public String china(){
        return "/country/china";
    }
    @GetMapping("/country/japan")
    public String japan(){
        return "/country/japan";
    }
    @GetMapping("/country/korea")
    public String korea(){
        return "/country/korea";
    }
    @GetMapping("/transportation/airplane")
    public String airplane(){
        return "/transportation/airplane";
    }
    @GetMapping("/transportation/bus")
    public String bus(){
        return "/transportation/bus";
    }
    @GetMapping("/transportation/train")
    public String train(){
        return "/transportation/train";
    }

}
