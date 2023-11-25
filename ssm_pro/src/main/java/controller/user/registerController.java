package controller.user;

import dao.bean.user;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import service.list.users;

import java.io.IOException;

@Controller
@RequestMapping("/controller")
public class registerController {


    @RequestMapping("/register")
    public String register(user it, Model model, HttpServletRequest request, HttpSession session) throws IOException {
        model.addAttribute("register", it);
        String username = it.getUname();
        String password = it.getPassword();
        if (username != null && password != null && !username.isEmpty() && !password.isEmpty()) {
            if (users.containsName(username)) {
                request.setAttribute("error", "0");
                return "user/register";
            } else {
                user user = new user(username, password);
                users.addUser(user);
                session.setAttribute("password", null);
                return "user/login";
            }
        } else {
            return "user/register";
        }
    }
}
