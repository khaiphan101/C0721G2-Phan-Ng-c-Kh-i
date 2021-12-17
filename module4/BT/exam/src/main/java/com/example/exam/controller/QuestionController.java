package com.example.exam.controller;

import com.example.exam.model.Question;
import com.example.exam.model.QuestionType;
import com.example.exam.service.IQuestionService;
import com.example.exam.service.IQuestionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    IQuestionService iQuestionService;

    @Autowired
    IQuestionTypeService iQuestionTypeService;

    @ModelAttribute("questionTypeList")
    public Iterable<QuestionType> movieList(Model model) {
        return iQuestionTypeService.findAll();
    }

    @GetMapping("")
    public String displayBlog(Optional<Integer> movieId, Optional<String> name,
                              Model model,
                              @PageableDefault(size = 5) Pageable pageable) {

//        if (!name.isPresent() || name.get().equals("")) {
//            if (movieId.isPresent()) {
//                model.addAttribute("showCinemas", iQuestionService.findAllCinemaById(movieId.get(), pageable));
//                model.addAttribute("movieId", movieId.get());
//            } else {
        model.addAttribute("questionList", iQuestionService.findAllQuestion(pageable));
//
//            }
//        } else {
//            model.addAttribute("showCinemas", iQuestionService.findAllCinemaByMovie(name.get(), pageable));
//            model.addAttribute("name", name.get());
//        }
        return "/question/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id, Model model) {
        Optional<Question> question = iQuestionService.findById(id);
        iQuestionService.deleteById(question.get().getId());
        return "redirect:/question";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model) {
        model.addAttribute("question", new Question());
        return "/question/create";
    }

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute("question") Question question,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "/question/create";
        } else {
            iQuestionService.save(question);
            redirectAttributes.addFlashAttribute("message", "Create successfully");
            return "redirect:/question";
        }
    }

}
