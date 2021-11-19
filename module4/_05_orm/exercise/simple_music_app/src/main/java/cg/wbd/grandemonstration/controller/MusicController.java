package cg.wbd.grandemonstration.controller;

import cg.wbd.grandemonstration.service.IMusicService;
import cg.wbd.grandemonstration.service.impl.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MusicController {

    @Autowired
    IMusicService musicService;

    @GetMapping(value = "")
    public String getListPage(Model model){
        model.addAttribute("musicList",musicService.findAll());
        return "music/list";
    }
}
