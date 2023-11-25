package controller.order_detail;

import dao.bean.order_detail;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import service.list.order_details;
import service.list.sqlsess;

import java.io.IOException;

@Controller
@RequestMapping("/controller")
public class order_detailController {
    @RequestMapping("/order_detailupdate")
    public String  order_detail_update(Model model, String update, HttpSession session) throws IOException {
        session.setAttribute("activeLink", "controller/order_detail");
        order_detail it = order_details.get(update);
        model.addAttribute("order_detailUpdate", it);
        return "order_detail/order_detailupdate";
    }

    @RequestMapping("/order_detail")
    public String doPost(HttpServletRequest request, HttpSession session) throws IOException {
        session.setAttribute("activeLink", "controller/order_detail");
        String search = request.getParameter("search");
        String delete = request.getParameter("delete");
        String clear = request.getParameter("clear");
        String add = request.getParameter("add");
        if (search != null) {
            String searchInput = request.getParameter("search-input");
            if (searchInput != null && !searchInput.isEmpty()) {
                session.setAttribute("searchInput", searchInput);
                order_details.search(searchInput);
            } else {
                session.setAttribute("searchInput", null);
                order_details.selectAll();
            }
            return "order_detail/order_detail";
        }
        if (clear != null) {
            sqlsess.searchAll();
            session.setAttribute("searchInput", null);
            return "order_detail/order_detail";
        }
        if (add != null) {
            return "order_detail/order_detailadd";
        }
        if (delete != null) {
            order_details.remove(delete);
            return "order_detail/order_detail";
        }
        return "order_detail/order_detail";
    }
}
