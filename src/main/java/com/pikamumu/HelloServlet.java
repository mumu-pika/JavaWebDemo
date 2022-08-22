package com.pikamumu;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

public class HelloServlet extends HttpServlet {
    // 快捷键 ctrl + O (英文字母O) 可以快速打开需要实现的接口方法
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);
        
        // 响应的类型
        resp.setContentType("text/html");
        
        // 设置字符编码，避免中文显示有误
        resp.setCharacterEncoding("UTF-8");
        
        // 获取响应的输出流
        PrintWriter out = resp.getWriter();
        
        out.println("<html>");
        out.println("<head>");
        out.println("<title>hello pika!</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>哈哈哈！ pika!</h1>");
        out.println("</body>");
        out.println("</html>");
        
    }
    
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
