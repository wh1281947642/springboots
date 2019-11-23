package com.example.springboots.controller.base;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.example.springboots.entity.framework.AuthUserEntity;
import com.example.springboots.utils.SessionKey;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;



@Controller
public class FrameworkBaseController {
	
	protected final Logger log = Logger.getLogger(this.getClass());
	
	//protected PropertiesUtils pu  = new PropertiesUtils("/api.properties");
	
	protected HttpServletRequest getRequest() {
		RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
		return ((ServletRequestAttributes)requestAttributes).getRequest();
	}
	
	protected HttpSession getSession() {
		return getRequest().getSession();
	}
	
	protected ServletContext getApplication() {
		return getSession().getServletContext();
	}
	
    protected String getSessionString(String key) {
		Object obj = getSession().getAttribute(key);
		return obj != null ? obj.toString() : null;
	}

	protected Object getSessionObject(String key) {
		return getSession().getAttribute(key);
	}

	protected void setSession(String key, Object value) {
		getSession().setAttribute(key, value);
	}

	protected void setRequest(String key, Object value) {
		getRequest().setAttribute(key, value);
	}
	
	protected String getParameter(String key) {
		return getRequest().getParameter(key);
	}

	protected int getPageIndex() {
		String v = getParameter("page");
		if (StringUtils.isNotBlank(v)) {
			return Integer.parseInt(v);
		}
		return 1;
	}

	protected int getPageSize() {
		String v = getParameter("pageSize");
		if (StringUtils.isNotBlank(v)) {
			return Integer.parseInt(v);
		}
		return 5;
	}
	
	protected String getRealPath(String path) {
		return getSession().getServletContext()
		.getRealPath(path);
	}
	
	/**
     * 获取当前登录用户
     * 
     * @return
     */
    public AuthUserEntity getCurrentLoginUser() {
        Object obj = getSessionObject(SessionKey.SESSION_USER);
        if (obj != null) {
            AuthUserEntity en = (AuthUserEntity) obj;
            return en;
        }
        return null;
    }
}
