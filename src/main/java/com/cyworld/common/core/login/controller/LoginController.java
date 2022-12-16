package com.cyworld.common.core.login.controller;

import com.cyworld.common.core.login.payload.SuccessResponse;
import com.cyworld.common.core.login.payload.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Slf4j
@RestController
@RequestMapping(value="/core", produces = "application/json")
public class LoginController {

    @RequestMapping(value="/login", method = RequestMethod.POST)
    public SuccessResponse login(UserDto.UserInfo user, Model model, HttpServletRequest request, HttpServletResponse response) {
//        if("user".equals(user.getUserid()) && "q1w2e3r4".equals(user.getUserpw())){
//            return "/login_success";
//        }else{
//            request.setAttribute("login_fl", "fail");
//            return "/login";
//        }
        log.debug("====id : password ==== {} : {} ", user.getUserid(), user.getUserpw());
        return new SuccessResponse(response.SC_OK, "정상적으로 성공하였습니다.", null);
    }
}
