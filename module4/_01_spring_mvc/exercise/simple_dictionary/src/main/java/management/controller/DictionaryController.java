package management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DictionaryController {
    @GetMapping("")
    public String showForm() {
        return "show";
    }

    @PostMapping("")
    public String showList(@RequestParam String vietnamese, Model model) {
        String english;
        switch (vietnamese) {
            case "mot":
                english = "one";
                break;
            case "hai":
                english = "two";
                break;
            case "ba":
                english = "three";
                break;
            default:
                english = "cant not translate";
                break;
        }
        model.addAttribute("toEnglish", english);
        return "show";
    }
}
