package com.interceptor.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.Logger;

@Component
public class TimerInterceptor implements HandlerInterceptor {
    //private  static  final Logger logger = Logger.getLogger(String.valueOf(TimerInterceptor.class));
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        long startTime = System.currentTimeMillis();
        request.setAttribute("startTime", startTime);
        System.out.println("Entered preHandle interceptor.");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) {
        Long startTime = (Long) request.getAttribute("startTime");
        Long endTime = System.currentTimeMillis();
        Long executeTime = endTime - startTime;
        modelAndView.addObject("executeTime", executeTime);
        System.out.println("[" + handler + "] excuteTime" + executeTime + "ms");
        System.out.println("Entered postHandle interceptor.");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                                Exception exception) {
        System.out.println("Entered afterCompletion iterceptor");
    }
}

