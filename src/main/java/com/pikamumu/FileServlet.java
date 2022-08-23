package com.pikamumu;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

@WebServlet(name = "FileServlet", value = "/FileServlet")
public class FileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
        *   1、要获取下载文件的路径
        *   2、下载的文件名
        *   3、设置让浏览器能够支持下载
        *   4、获取下载文件的输入流
        *   5、创建缓冲区
        *   6、获取OutputStream对象
        *   7、将FileOutputStream流写入到buffer缓冲区
        *   8、使用OutputStream将缓冲区中的数据输出到客户端
        *
        * */
        
        // 1、要获取下载文件的路径
        String realPath = this.getServletContext().getRealPath("/files/saberlily1.jpg");
        //String realPath = "D:\\Users\\mumu\\Java\\mavenDemo1\\src\\main\\resources\\saberlily1.jpg";
        
        // 2、下载的文件名 (使用字符串的方法来截取路径获得文件名)
        String filename =  realPath.substring(realPath.lastIndexOf("\\") + 1);
        
        // 3、设置让浏览器能够支持下载
        response.setHeader("Content-Disposition","attachment;filename=" + URLEncoder.encode(filename, "UTF-8")); ;
        
        // 4、获取下载文件的输入流
        FileInputStream in = new FileInputStream(realPath);
        
        // 5、创建缓冲区
        int len = 0;
        byte[] buffer = new byte[1024];
        
        // 6、获取OutputStream对象
        ServletOutputStream out = response.getOutputStream();
        
        // 7、将FileOutputStream流写入到buffer缓冲区
        while ((len = in.read(buffer)) > 0) {
            out.write(buffer, 0, len);
        }
        
        // 流关闭收尾
        in.close();
        out.close();
        
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
    }
}
