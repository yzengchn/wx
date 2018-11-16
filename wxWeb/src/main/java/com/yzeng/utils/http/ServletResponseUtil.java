package com.yzeng.utils.http;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

/**
 * 将数据用流写到响应中返回
 * @author  yzblog.xyz
 * @version  [1.0, 2018年11月16日]
 * @Email yzengchn@163.com
 * @since  [产品/模块版本]
 */
public class ServletResponseUtil {
	public static void print(String content, HttpServletResponse response) {
        PrintWriter out = null;

        try {

            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/html;charset=UTF-8");
            response.setHeader("Pragma", "No-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expires", 0);
            out = response.getWriter();
            out.write(content);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != out) {
                    out.close();
                    out = null;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
