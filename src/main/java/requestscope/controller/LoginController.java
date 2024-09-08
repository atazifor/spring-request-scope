package requestscope.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import requestscope.processor.LoginProcessor;

@Controller
public class LoginController {

    private final LoginProcessor loginProcessor;

    public LoginController(LoginProcessor loginProcessor) {
        this.loginProcessor = loginProcessor;
    }

    @GetMapping("/")
    public String loginGet() {
        return  "login.html";
    }

    @PostMapping("/")
    public String loginPost(@RequestParam String username, @RequestParam String password, Model page) {
        loginProcessor.setUsername(username);
        loginProcessor.setPassword(password);
        boolean success = loginProcessor.login();
        if(success) {
            page.addAttribute("message", "Login Successful");
        }else {
            page.addAttribute("message", "Login FAILED");
        }
        return "login.html";
    }
}
