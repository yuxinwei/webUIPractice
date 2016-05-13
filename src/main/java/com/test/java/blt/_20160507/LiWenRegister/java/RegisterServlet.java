package com.test.java.blt._20160507.LiWenRegister.java;

import com.day7.LiWenRegister.java.domain.User;
import com.util.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by wen.li on 16/5/10.
 */
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        User user = new User();

        user.setUsername(req.getParameter("username"));
        user.setPassword(req.getParameter("password"));
        user.setSex(req.getParameter("sex"));
        user.setProvince(req.getParameter("province"));

        String url = "jdbc:mysql://127.0.0.1:3307/test";
        String username = "root";
        String password = "password";
        String sql = "insert into users(username, password, sex, province) values(?,?,?,?)";
        String qSql = "select * from users where username = ?";


        try {
            DBUtil.getConnection(url, username, password);
            System.out.println("DBUtil" + user.getUsername() + user.getPassword() + user.getProvince());
            List list = DBUtil.query(qSql, user.getUsername());
            if (list.size() == 0) {
                DBUtil.insertOrUpdate(sql, user.getUsername(), user.getPassword(), user.getSex(), user.getProvince());
            }
            req.setAttribute("message", "注册成功");
            req.setAttribute("username",user.getUsername());
            req.setAttribute("sex",user.getSex());
            req.setAttribute("province",user.getProvince());
            req.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(req, resp);

        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("message", "注册失败");
            req.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(req, resp);

        } finally {
            DBUtil.close();
        }
    }
}
