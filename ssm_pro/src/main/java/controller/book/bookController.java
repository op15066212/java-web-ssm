package controller.book;

import dao.bean.book;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import service.list.books;
import service.list.sqlsess;

import java.io.IOException;

@Controller
@RequestMapping("/controller")
public class bookController {
    @RequestMapping("/bookupdate")
    public String update(Model model, String update, HttpSession session) throws IOException {
        session.setAttribute("activeLink", "controller/book");
        book it = books.get(update);
        model.addAttribute("bookUpdate", it);
        return "book/bookupdate";
    }

    @RequestMapping("/book")
    public String doPost(HttpServletRequest request, HttpSession session) throws IOException {
        session.setAttribute("activeLink", "controller/book");
        String clear = request.getParameter("clear");
        String add = request.getParameter("add");
        String search = request.getParameter("search");
        String delete = request.getParameter("delete");
        if (search != null) {
            String searchInput = request.getParameter("search-input");
            if (searchInput != null && !searchInput.isEmpty()) {
                session.setAttribute("searchInput", searchInput);
                books.search(searchInput);
            } else {
                session.setAttribute("searchInput", null);
                books.selectAll();
            }
            return "book/book";
        }
        if (clear != null) {
            session.setAttribute("searchInput", null);
            sqlsess.searchAll();
            return "book/book";
        }
        if (add != null) {
            return "book/bookadd";
        }
        if (delete != null) {
            books.remove(delete);
            return "book/book";
        }
        return "book/book";
    }
}
