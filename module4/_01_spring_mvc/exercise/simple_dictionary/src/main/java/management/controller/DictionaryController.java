package management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class DictionaryController {
    @GetMapping("")
    public String showForm() {
        return "dictionary/show";
    }

//    @PostMapping("")
//    public String showList(@RequestParam String vietnamese, Model model) {
//        String english;
//        switch (vietnamese) {
//            case "mot":
//                english = "one";
//                break;
//            case "hai":
//                english = "two";
//                break;
//            case "ba":
//                english = "three";
//                break;
//            default:
//                english = "cant not translate";
//                break;
//        }
//        model.addAttribute("toEnglish", english);
//        return "show";
//    }
}
