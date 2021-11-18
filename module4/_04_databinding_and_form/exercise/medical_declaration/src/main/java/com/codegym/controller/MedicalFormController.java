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
    public ModelAndView getConfigPage(Model model){
        ModelAndView modelAndView = new ModelAndView("index");

//        String[] languageList = new String[]{"English","Vietnamese","Japanese","Chinese"};
////        model.addAttribute("languageList",languageList);
//        modelAndView.addObject("languageList",languageList);
//
//        Integer[] pageSizeList = new Integer[]{5, 10, 15, 25, 50, 100};
////        model.addAttribute("pageSizeList",pageSizeList);
//        modelAndView.addObject("pageSizeList",pageSizeList);

        modelAndView.addObject("medical_form",new MedicalDeclaration());
       return modelAndView;
    }

//    @PostMapping(value = "/save")
//    public String saveConfig(@ModelAttribute("mail")Mail mail, Model model){
//        model.addAttribute("mail",mail);
//        return "show";
//    }
//
//    @PostMapping(value = "/edit")
//    public ModelAndView edit(@ModelAttribute("mail")Mail mailBox, Model model){
//        ModelAndView modelAndView = new ModelAndView("edit");
//
//        String[] languageList = new String[]{"English","Vietnamese","Japanese","Chinese"};
////        model.addAttribute("languageList",languageList);
//        modelAndView.addObject("languageList",languageList);
//
//        Integer[] pageSizeList = new Integer[]{5, 10, 15, 25, 50, 100};
////        model.addAttribute("pageSizeList",pageSizeList);
//        modelAndView.addObject("pageSizeList",pageSizeList);
//        modelAndView.addObject("mail",mailBox);
//        return modelAndView;
//    }


}
