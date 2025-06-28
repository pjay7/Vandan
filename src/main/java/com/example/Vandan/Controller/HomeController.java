package com.example.Vandan.Controller;


import com.example.Vandan.model.Enquiry;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    @GetMapping("/Home")
    public String home(Model model) {
        model.addAttribute("index", "Welcome");
        return "index";
    }

    @GetMapping("/product")
    public String product(Model model) {
        model.addAttribute("product", "Groundnut Oil");
        return "product";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }
}
