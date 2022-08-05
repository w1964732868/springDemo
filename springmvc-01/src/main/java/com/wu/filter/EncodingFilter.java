package com.wu.filter;


import javax.servlet.*;
import java.io.IOException;

/**
 * @author huijie.wu
 * @version 1.0.0
 * @date 2022/8/5
 * @description
 * @copyright COPYRIGHT © 2014 - 2022 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public class EncodingFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //servletRequest.setCharacterEncoding("utf-8");
        //servletResponse.setCharacterEncoding("utf-8");
        //filterChain.doFilter(servletRequest, servletResponse);
        //get解决了乱码 post没有解决
        //web.xml
        //<filter>
        //    <filter-name>encoding</filter-name>
        //    <filter-class>com.wu.filter.EncodingFilter</filter-class>
        //</filter>
        //<filter-mapping>
        //    <filter-name>encoding</filter-name>
        //    <url-pattern>/</url-pattern>
        //</filter-mapping>
    }

    public void destroy() {

    }
}
