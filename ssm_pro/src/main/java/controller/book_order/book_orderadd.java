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
public class book_orderadd {
    @RequestMapping("/book_orderadd")
    public String doPost(book_order it, Model model, HttpServletRequest request) throws IOException {
        model.addAttribute("book_orderadd",it);
        if (it.isEmpty()) {
            request.setAttribute("error", "0");
            return "book_order/book_orderadd";
        }
        if (book_orders.contains(it.getOid())) {
            request.setAttribute("error", "1");
            return "book_order/book_orderadd";
        }
        book_orders.add(it);
        request.setAttribute("error", "-1");
        return "book_order/book_orderadd";
    }
}
