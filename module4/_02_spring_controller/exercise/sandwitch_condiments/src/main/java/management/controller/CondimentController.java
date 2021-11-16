package management.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("")
public class CondimentController {

    @GetMapping(value = "")
    public String getPageIndex(){
        return "info";
    }

    @RequestMapping("/save")
    public String saveToCondimentList(@RequestParam("condiment") String[] condiment, Model model) {
        model.addAttribute("condimentList", condiment);
        return "list";
    }

//    @GetMapping("/{id}")
//    public ModelAndView showInformation(@PathVariable Long id) {
//        ModelAndView modelAndView = new ModelAndView("customers/info");
//        Customer customer = customerService.findOne(id);
//        modelAndView.addObject("customer", customer);
//        return modelAndView;
//    }

//    @PostMapping
//    public String updateCustomer(
//            @RequestParam Long id,
//            @RequestParam String name,
//            @RequestParam String email,
//            @RequestParam String address
//
//    ) {
//        Customer customer = new Customer(id, name, email, address);
//        customerService.save(customer);
//        return "redirect:/customers";
//    }
}
