package controller.user;

import dao.bean.user;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import service.list.users;

import java.io.IOException;

@Controller
@RequestMapping("/controller")
public class userupdate {

    @RequestMapping("/userOutput")
    public ModelAndView user_outPut(user it, Model model, HttpServletRequest request) throws IOException {
        model.addAttribute("userUpdate", it);
        if (it.isEmpty()) {
            request.setAttribute("error", "0");
            return new ModelAndView("user/userupdate");
        }
        if (!it.getGender().equals("男") && !it.getGender().equals("女")) {
            request.setAttribute("error", "性别输入错误");
            return new ModelAndView("user/userupdate");
        }
        users.update(it);
        request.setAttribute("error", "-1");
        return new ModelAndView("redirect:user");
    }
}
