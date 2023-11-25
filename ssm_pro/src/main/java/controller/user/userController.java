package controller.user;

import dao.bean.user;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.list.*;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/controller")
public class userController {

    @RequestMapping("/user/test")
    @ResponseBody
    public List<user> test() throws IOException {
        users.selectAll();
        return users.getList();
    }

    @RequestMapping("/userupdate")
    public String user_update(Model model, String update, HttpSession session) throws IOException {
        session.setAttribute("activeLink", "controller/user");
        user temp = users.get(update);
        model.addAttribute("userUpdate", temp);
        return "user/userupdate";
    }

    @RequestMapping("/user")
    public String doPost(HttpServletRequest request, HttpSession session) throws IOException {
        session.setAttribute("activeLink", "controller/user");
        String search = request.getParameter("search");
        String clear = request.getParameter("clear");
        String add = request.getParameter("add");
        String delete = request.getParameter("delete");
        if (search != null) {
            String searchInput = request.getParameter("search-input");
            if (searchInput != null && !searchInput.isEmpty()) {
                session.setAttribute("searchInput", searchInput);
                users.search(searchInput);
            } else {
                session.setAttribute("searchInput", null);
                users.selectAll();
            }
            return "user/user";
        }
        if (clear != null) {
            sqlsess.searchAll();
            session.setAttribute("searchInput", null);
            return "user/user";
        }
        if (add != null) {
            return "user/useradd";
        }
        if (delete != null) {
            users.remove(delete);
            return "user/user";
        }
        return "user/user";
    }
}
