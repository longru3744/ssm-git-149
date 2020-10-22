package cn.smbms.controller;

import cn.smbms.pojo.User;
import cn.smbms.service.user.UserService;
import cn.smbms.tools.Constants;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController {


            @Resource
            private UserService userService;
            @RequestMapping("/login.html")
            public String login(){
                return "login";
            }

            @RequestMapping(value = "login.html",method = RequestMethod.POST)
            public String doLogin(String userCode, String userPassword, HttpSession session){
                User user=userService.login(userCode,userPassword);
                if (user!=null){
                    session.setAttribute(Constants.USER_SESSION,user);
                    return "frame";
                }


                return "login";

            }
            @RequestMapping("/user/main.html")
            public String main(){
                return "frame";
            }

}
