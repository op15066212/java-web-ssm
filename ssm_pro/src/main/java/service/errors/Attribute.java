package service.errors;

import jakarta.servlet.http.HttpServletRequest;

public class Attribute {
    public static String getLoginError(HttpServletRequest request) {
        String errorMsg = "";
        Object error = request.getAttribute("error");
        if (error != null) {
            errorMsg = (String) error;
            if (error.toString().equals("0")) {
                errorMsg = "账号不存在";
            } else if (error.toString().equals("1")) {
                errorMsg = "账号或密码错误";
            }
        }
        return errorMsg;
    }

    public static String getRegisterError(HttpServletRequest request) {
        String errorMsg = "";
        Object error = request.getAttribute("error");
        if (error != null) {
            errorMsg = (String) error;
            if (error.toString().equals("0")) {
                errorMsg = "账号已存在";
            }
        }
        return errorMsg;
    }

    public static String getAddError(HttpServletRequest request) {
        String errorMsg = "";
        Object error = request.getAttribute("error");
        if (error != null) {
            errorMsg = (String) error;
            if (error.toString().equals("-1")) {
                errorMsg = "运行成功";
            } else if (error.toString().equals("0")) {
                errorMsg = "不可以留空白";
            } else if (error.toString().equals("1")) {
                errorMsg = "id已存在";
            }
        }
        return errorMsg;
    }
}
