package com.example.springboots.controller;


import com.example.springboots.controller.base.FrameworkBaseController;
import com.example.springboots.entity.utore.UtoStorageEntity;
import com.example.springboots.service.framework.IAuthUserPwdService;
import com.example.springboots.service.utore.IUtoStorageService;
import com.example.springboots.utils.ResultData;
import com.example.springboots.utils.SessionKey;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * 登录
 * 
 * @author rain
 */

@RestController
@EnableAutoConfiguration
public class LoginController extends FrameworkBaseController {

    @Resource
    private IAuthUserPwdService authUserPwdService;

    @Resource
    private IUtoStorageService utoStorageService;


    @RequestMapping("/ceshi1")
    public String ceshi(){
        String a = "aaa";
        return "ceshii1";

    }

    @RequestMapping("/utore")
    public List<UtoStorageEntity> utore(){
        List<UtoStorageEntity> list = null;
        list =utoStorageService.queryList();
        System.out.println(list.size());
        return list;
    }

    /**
     * 用户登录
     * 
     * @return
     * @throws IOException
     */
    @SuppressWarnings({"unused", "restriction"})
    @RequestMapping(value = "/login-data")
    public ResultData loginData(@RequestParam(required=true)String username, @RequestParam(value="password",required=true) String password, HttpServletRequest request, HttpServletResponse response) throws IOException {
    	ResultData data = new ResultData();
    	String loginname = username ;
    	try {
            if (StringUtils.isBlank(loginname)) {
                data.setMessage("请输入用户名！");
                return data;
            }
            if (StringUtils.isBlank(password)) {
                data.setMessage("请输入密码！");
                return data;
            }

            	//BASE64Decoder base64 = new BASE64Decoder();
            	//password = new String(base64.decodeBuffer(password));
            	data = authUserPwdService.login(loginname, password);
                HttpSession session = request.getSession();
                session.setAttribute("user",data.getObj());
                setSession(SessionKey.SESSION_USER, data.getObj());
                Object user = (Object) session.getAttribute("user"); //获取登录的session信息

            return data;
        }
        catch (Exception e) {
        	e.printStackTrace();
            data.setMessage("登录失败。");
        }
        return data;
    }
}
