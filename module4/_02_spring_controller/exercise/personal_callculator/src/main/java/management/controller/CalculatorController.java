package management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Controller
@RequestMapping("")
public class CalculatorController {

    @GetMapping(value = "")
    public String getPageIndex() {
        return "info";
    }

    @RequestMapping("/calculate")
    public String saveToCondimentList(@RequestParam("num1") String num1, @RequestParam("num2") String num2, @RequestParam("calculation") String calculation, Model model) {
        String result = "";
        try {
            double firstNum = Double.parseDouble(num1);
            double secondNum = Double.parseDouble(num2);

            switch (calculation) {
                case "Addition(+)":
                    result += (firstNum + secondNum);
                    break;
                case "Subtraction(-)":
                    result += (firstNum - secondNum);
                    break;
                case "Mutiplication(X)":
                    result += (firstNum * secondNum);
                    break;
                case "Division(/)":
                    if (secondNum == 0) {
                        result += "cannot devise by zero";
                    }else
                    result += (firstNum / secondNum);
                    break;

            }
        } catch (NumberFormatException e) {
            result += "It's not a number";
        }

        model.addAttribute("result", result);
        return "info";
    }

}
