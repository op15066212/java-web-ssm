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
public class loginController {


    @RequestMapping("/login")
    public String login(user it, Model model, HttpServletRequest request, HttpSession session) throws IOException {
        model.addAttribute("Login", it);
        session.setAttribute("keyname", it.getUname());
        String username = it.getUname();
        String password = it.getPassword();
        if (username != null && password != null && !username.isEmpty() && !password.isEmpty()) {
            user user = users.getUser(username);
            if (user == null) {
                request.setAttribute("error", "0");
                return "user/login";
            } else if (user.getPassword().equals(password)) {
                session.setAttribute("activeLink", "controller/book");
                return "book/book";
            } else {
                request.setAttribute("error", "1");
                return "user/login";
            }
        } else {
            return "user/login";
        }
    }
}
