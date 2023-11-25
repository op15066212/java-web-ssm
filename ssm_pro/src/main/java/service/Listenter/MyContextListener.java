package service.Listenter;

import com.mysql.cj.jdbc.AbandonedConnectionCleanupThread;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;


@WebListener
public class MyContextListener implements ServletContextListener {

    private static final Logger LOGGER = Logger.getLogger(MyContextListener.class.getName());

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        LOGGER.log(Level.INFO, "正在初始化 MyContextListener 监听器");

//        registerJDBCDriver();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        LOGGER.log(Level.INFO, "正在销毁 MyContextListener 监听器");


        try {
            deregisterJDBCDriver();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    private void registerJDBCDriver() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            LOGGER.log(Level.INFO, "成功注册 JDBC 驱动程序");
        } catch (ClassNotFoundException e) {
            LOGGER.log(Level.SEVERE, "无法加载 JDBC 驱动程序", e);
        }
    }

    private void deregisterJDBCDriver() throws SQLException {
        //这里如果Web应用拥有多个数据库的连接，可以一并关闭
        Enumeration<Driver> drivers = DriverManager.getDrivers();
        Driver driver = null;
        while (drivers.hasMoreElements()) {
            try {
                driver = drivers.nextElement();
                DriverManager.deregisterDriver(driver);
            } catch (SQLException ex) {
                LOGGER.log(Level.INFO, "无法注销 JDBC 驱动程序" + driver);
            }
        }
        AbandonedConnectionCleanupThread.checkedShutdown();
        LOGGER.log(Level.INFO, "成功注销 JDBC 驱动程序");
    }
}
