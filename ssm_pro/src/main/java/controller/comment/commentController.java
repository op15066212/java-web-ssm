package controller.comment;

import dao.bean.comment;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import service.list.comments;
import service.list.sqlsess;

import java.io.IOException;

@Controller
@RequestMapping("/controller")
public class commentController {
    @RequestMapping("/commentupdate")
    public String comment_update(Model model, String update, HttpSession session) throws IOException {
        comment it = comments.get(update);
        System.out.println(it);
        session.setAttribute("activeLink", "controller/comment");
        model.addAttribute("commentUpdate", it);
        return "comment/commentupdate";
    }

    @RequestMapping("/comment")
    public String doPost(HttpServletRequest request, HttpSession session) throws IOException {
        session.setAttribute("activeLink", "controller/comment");
        String search = request.getParameter("search");
        String clear = request.getParameter("clear");
        String add = request.getParameter("add");
        String delete = request.getParameter("delete");
        if (search != null) {
            String searchInput = request.getParameter("search-input");
            if (searchInput != null && !searchInput.isEmpty()) {
                session.setAttribute("searchInput", searchInput);
                comments.search(searchInput);
            } else {
                session.setAttribute("searchInput", null);
                comments.selectAll();
            }
            return "comment/comment";
        }
        if (clear != null) {
            session.setAttribute("searchInput", null);
            sqlsess.searchAll();
            return "comment/comment";
        }
        if (add != null) {
            // 如果点击了添加按钮，则跳转到添加书籍页面
            return "comment/commentadd";
        }
        if (delete != null) {
            comments.remove(delete);
            return "comment/comment";
        }
        return "comment/comment";
    }
}
