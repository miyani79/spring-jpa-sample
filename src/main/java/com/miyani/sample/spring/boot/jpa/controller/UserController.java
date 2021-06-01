package com.miyani.sample.spring.boot.jpa.controller;

import com.miyani.sample.spring.boot.jpa.dto.UserInfoDTO;
import com.miyani.sample.spring.boot.jpa.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController
{
    private Logger logger = LoggerFactory.getLogger(this.getClass().getCanonicalName());
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ResponseBody
    @RequestMapping(value="userCheck.do")
    public String userCheck(HttpServletRequest request)
    {
        UserInfoDTO dto = new UserInfoDTO();
        dto.setUserId("99999999");

        this.userService.checkUser(dto);

        return "success";
    }
}
