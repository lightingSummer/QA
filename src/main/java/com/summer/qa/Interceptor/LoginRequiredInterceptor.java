package com.summer.qa.Interceptor;

import com.summer.qa.model.HostHolder;
import com.summer.qa.util.SettingUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author ：lightingSummer
 * @date ：2019/6/4 0004
 * @description：
 */
@Component
public class LoginRequiredInterceptor implements HandlerInterceptor {

  @Autowired private HostHolder hostHolder;

  @Override
  public boolean preHandle(
      HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o)
      throws Exception {
    if (hostHolder.getUser() == null) {
      httpServletResponse.sendRedirect(
          SettingUtil.QA_DOMAIN
              + "/reglogin?next="
              + SettingUtil.QA_DOMAIN
              + httpServletRequest.getRequestURI());
      return false;
    }
    return true;
  }

  @Override
  public void postHandle(
      HttpServletRequest httpServletRequest,
      HttpServletResponse httpServletResponse,
      Object o,
      ModelAndView modelAndView)
      throws Exception {}

  @Override
  public void afterCompletion(
      HttpServletRequest httpServletRequest,
      HttpServletResponse httpServletResponse,
      Object o,
      Exception e)
      throws Exception {}
}
