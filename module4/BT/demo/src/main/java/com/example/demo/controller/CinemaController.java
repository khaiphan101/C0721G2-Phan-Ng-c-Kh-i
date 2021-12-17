package com.example.demo.controller;

import com.example.demo.model.Movie;
import com.example.demo.model.ShowCinema;
import com.example.demo.service.ICinemaService;
import com.example.demo.service.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/cinema")
public class CinemaController {

    @Autowired
    ICinemaService iCinemaService;

    @Autowired
    IMovieService iMovieService;

    @ModelAttribute("movieList")
    public Iterable<Movie> movieList(Model model) {
        return iMovieService.findAll();
    }

    //    @GetMapping
//    public String showList(Model model) {
//        model.addAttribute("showCinemas", iCinemaService.findAll());
//        return "/cinema/list";
//    }
    @GetMapping("")
    public String displayBlog(Optional<Integer> movieId, Optional<String> name,
                              Model model,
                              @PageableDefault(size = 5) Pageable pageable) {

        if (!name.isPresent() || name.get().equals("")) {
            if (movieId.isPresent()) {
                model.addAttribute("showCinemas", iCinemaService.findAllCinemaById(movieId.get(), pageable));
                model.addAttribute("movieId", movieId.get());
            } else {
                model.addAttribute("showCinemas", iCinemaService.findAllCinema(pageable));

            }
        } else {
            model.addAttribute("showCinemas", iCinemaService.findAllCinemaByMovie(name.get(), pageable));
            model.addAttribute("name", name.get());
        }
//        model.addAttribute("showCinemas", iCinemaService.findAllCinema(pageable));
        return "/cinema/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable String id, Model model) {
        Optional<ShowCinema> customer = iCinemaService.findById(id);
        iCinemaService.deleteById(customer.get().getId());
        return "redirect:/cinema";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model) {
        model.addAttribute("showCinema", new ShowCinema());
        return "/cinema/create";
    }

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute("showCinema") ShowCinema showCinema,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "/cinema/create";
        } else {
            iCinemaService.save(showCinema);
            redirectAttributes.addFlashAttribute("message", "Create successfully");
            return "redirect:/cinema";
        }
    }

    @GetMapping("/edit/{id}")
    public String showFormEdit(@PathVariable String id, Model model) {
        Optional<ShowCinema> showCinema = iCinemaService.findById(id);
        model.addAttribute("showCinema", showCinema);
        return "cinema/edit";
    }

    @PostMapping("/edit")
    public String edit(@Valid @ModelAttribute("showCinema") ShowCinema showCinema, BindingResult bindingResult,
                               Model model, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "cinema/edit";
        } else {
            iCinemaService.save(showCinema);
            redirectAttributes.addFlashAttribute("message", "Edit successfully");
            return "redirect:/cinema";
        }
    }

    @GetMapping("/detail/{id}")
    public String showDetail(@PathVariable String id, Model model) {
        Optional< ShowCinema > showCinema = iCinemaService.findById(id);
        model.addAttribute("showCinema", showCinema.get());
        return "cinema/detail";
    }
}
