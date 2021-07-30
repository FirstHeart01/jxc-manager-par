package com.lzj.admin.interceptors;

import com.lzj.admin.pojo.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ProjectName: [jxc-manager-par]
 * @Package: [com.lzj.admin.interceptors]
 * @ClassName: [NoLoginInterceptor]
 * @Description:
 * @Author: [ZengQi]
 * @CreateDate: [2021-07-30  21:53]
 * @UpdateUser: [ZengQi]
 * @UpdateDate: [2021-07-30  21:53]
 * @UpdateRemark: [说明本次修改内容]
 * @Version: [v1.0]
 */
public class NoLoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        User user = (User)request.getSession().getAttribute("user");

        if(null == user) {
            /**
             * 用户未登录或者session过期
             */
            response.sendRedirect("index");
            return false;
        }

        return true;
    }
}
