package controller.comment;

import dao.bean.comment;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import service.list.comments;

import java.io.IOException;

@Controller
@RequestMapping("/controller")
public class commentadd {
    @RequestMapping("/commentadd")
    public String doPost(comment it, Model model, HttpServletRequest request) throws IOException {
        model.addAttribute("commentadd", it);
        if (it.isEmpty()) {
            request.setAttribute("error", "0");
            return "comment/commentadd";
        }
        if (comments.contains(it.getCid())) {
            request.setAttribute("error", "1");
            return "comment/commentadd";
        }
        comments.add(it);
        request.setAttribute("error", "-1");
        return "comment/commentadd";
    }
}
