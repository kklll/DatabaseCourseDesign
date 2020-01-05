package com.deep.dbdesign.interceptor;

import com.deep.dbdesign.pojo.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author DeepBlue
 * @date 2019/11/5  17:10
 */
public class StudentInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        User user = (User) request.getSession().getAttribute("session");
        //判断登陆是否有效
        if (user == null || !user.getIdentity().equals("学生")) {
            response.sendError(403);
            return false;
        }
        return user.getIdentity().equals("学生");
    }
}
