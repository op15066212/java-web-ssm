package controller.order_detail;

import dao.bean.order_detail;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import service.list.order_details;

import java.io.IOException;

@Controller
@RequestMapping("/controller")
public class order_detailadd {

    @RequestMapping("/order_detailadd")
    public String doPost(order_detail it, Model model, HttpServletRequest request) throws IOException {
        model.addAttribute("order_detailadd", it);
        if (it.isEmpty()) {
            request.setAttribute("error", "0");
            return "order_detail/order_detailadd";
        }
        if (order_details.contains(it.getId())) {
            request.setAttribute("error", "1");
            return "order_detail/order_detailadd";
        }
        order_details.add(it);
        request.setAttribute("error", "-1");
        return "order_detail/order_detailadd";
    }
}
