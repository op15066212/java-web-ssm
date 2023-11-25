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
public class commentupdate {
    @RequestMapping("/commentOutput")
    public String doPost(comment it, Model model, HttpServletRequest request) throws IOException {
        model.addAttribute("commentUpdate", it);
        if (it.isEmpty()) {
            request.setAttribute("error", "0");
            return "comment/commentupdate";
        }
        comments.update(it);
        request.setAttribute("error", "-1");
        return "comment/comment";
    }
}
