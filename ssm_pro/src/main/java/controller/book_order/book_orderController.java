package controller.book_order;

import dao.bean.book_order;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import service.list.book_orders;
import service.list.sqlsess;

import java.io.IOException;

@Controller
@RequestMapping("/controller")
public class book_orderController {

    @RequestMapping("/book_orderupdate")
    public String update(Model model, String update, HttpSession session) throws IOException {
        book_order it = book_orders.get(update);
        model.addAttribute("book_orderUpdate", it);
        session.setAttribute("activeLink", "controller/book_order");
        return "book_order/book_orderupdate";
    }

    @RequestMapping("/book_order")
    public String doPost(HttpServletRequest request, HttpSession session) throws IOException {
        session.setAttribute("activeLink", "controller/book_order");
        String search = request.getParameter("search");
        String add = request.getParameter("add");
        String clear = request.getParameter("clear");
        String delete = request.getParameter("delete");
        if (search != null) {
            String searchInput = request.getParameter("search-input");
            if (searchInput != null && !searchInput.isEmpty()) {
                session.setAttribute("searchInput", searchInput);
                book_orders.search(searchInput);
            } else {
                session.setAttribute("searchInput", null);
                book_orders.selectAll();
            }
            return "book_order/book_order";
        }
        if (clear != null) {
            session.setAttribute("searchInput", null);
            sqlsess.searchAll();
            return "book_order/book_order";
        }
        if (add != null) {
            return "book_order/book_orderadd";
        }
        if (delete != null) {
            book_orders.remove(delete);
            return "book_order/book_order";
        }
        return "book_order/book_order";
    }
}
