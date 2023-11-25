package controller.book_order;

import dao.bean.book_order;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import service.list.book_orders;

import java.io.IOException;


@Controller
@RequestMapping("/controller")
public class book_orderupdate {
    @RequestMapping("/book_orderOutput")
    public String doPost(book_order it, Model model, HttpServletRequest request) throws IOException {
        model.addAttribute("book_orderUpdate", it);
        if (it.isEmpty()) {
            request.setAttribute("error", "0");
            return "book_order/book_orderupdate";
        }
        book_orders.update(it);
        request.setAttribute("error", "-1");
        return "book_order/book_order";
    }
}
