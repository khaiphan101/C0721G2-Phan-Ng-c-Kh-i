package com.codegym.controller;

import com.codegym.model.MedicalDeclaration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MedicalFormController {

    @GetMapping(value = "")
    public ModelAndView getInfo(){
        ModelAndView modelAndView = new ModelAndView("index");

        String[] genderList = new String[]{"Nam","Nữ"};
        modelAndView.addObject("genderList",genderList);

        String[] countryList = new String[]{"Việt Nam","Mỹ"};
        modelAndView.addObject("countryList",countryList);

        String[] travelInfoList = new String[]{"Tau bay","Tau thuyen", "o to", "khac(ghi ro)"};
        modelAndView.addObject("travelInfoList",travelInfoList);

        String[] provinceList = new String[]{"Quang Nam","Quang Tri", "Da Nang", "Ha Noi"};
        modelAndView.addObject("provinceList",provinceList);

        String[] districList = new String[]{"Cam Le","Hoa Vang", "Hoa Khanh"};
        modelAndView.addObject("districList",districList);

        String[] wardList = new String[]{"Hoa Phat","Hoa Tho Dong", "Khue Trung"};
        modelAndView.addObject("wardList",wardList);

        modelAndView.addObject("medical_form",new MedicalDeclaration());
       return modelAndView;
    }

    @PostMapping(value = "/submit")
    public String saveInfo(@ModelAttribute("medical_form")MedicalDeclaration medicalDeclaration, Model model){
        model.addAttribute("medical_form",medicalDeclaration);
        return "show";
    }


}
