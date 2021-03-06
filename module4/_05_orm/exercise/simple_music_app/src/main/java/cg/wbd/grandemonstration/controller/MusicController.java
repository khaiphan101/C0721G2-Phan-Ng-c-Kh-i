package cg.wbd.grandemonstration.controller;

import cg.wbd.grandemonstration.model.Music;
import cg.wbd.grandemonstration.service.IMusicService;
import cg.wbd.grandemonstration.service.impl.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MusicController {

    @Autowired
    IMusicService musicService;

    @GetMapping(value = "")
    public String getListPage(Model model){
        model.addAttribute("musicList",musicService.findAll());
        return "music/list";
    }

    @GetMapping("create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("music/create");
        modelAndView.addObject("musicSong", new Music());
        return modelAndView;
    }

    @PostMapping(value = "/save")
    public String create(@ModelAttribute Music music, Model model, RedirectAttributes redirect) {
        musicService.addMusic(music);
        redirect.addFlashAttribute("success", "Create music successfully!");
        return "redirect:/";
    }

    @GetMapping(value = "/delete/{id}")
        public String deleteMusic (@PathVariable Integer id){
            musicService.delete(id);
            return "redirect:/";
    }
}
