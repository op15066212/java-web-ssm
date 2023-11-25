package controller.book;

import dao.bean.book;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import service.list.books;

import java.io.IOException;


@Controller
@RequestMapping("/controller")
public class bookupdate {
    @RequestMapping("/bookOutput")
    public String doPost(book it, Model model, HttpServletRequest request) throws IOException {
        model.addAttribute("bookUpdate", it);
        if (it.isEmpty()) {
            request.setAttribute("error", "0");
            return "book/bookupdate";
        }
        books.update(it);
        request.setAttribute("error", "-1");
        return "book/book";
    }
}
