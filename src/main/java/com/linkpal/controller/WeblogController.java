package com.linkpal.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.linkpal.domain.entity.*;
import com.linkpal.mapper.SysRoleMapper;
import com.linkpal.mapper.SysUserMapper;
import com.linkpal.mapper.SysUserRoleMapper;
import com.linkpal.mapper.WeblogMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 樊浩
 * @since 2021-07-05
 */
@Controller
public class WeblogController {
    private final static Logger logger = LoggerFactory.getLogger(WeblogController.class);
    @Autowired
    private WeblogMapper weblogMapper;
    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private SysRoleMapper roleMapper;

    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;
    @GetMapping("webloglist")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Response weblogList() {
      List<Weblog> weblogs = weblogMapper.selectList(null);
        return Response.succ(weblogs);
    }
    @GetMapping("weblogpage")
    public Response weblogpage() {
        IPage<Weblog> page = new Page<>(1, 5);
        QueryWrapper<Weblog> wrapper = new QueryWrapper<>();
        IPage<Weblog> weblogIPage = weblogMapper.selectPage(page, wrapper);
        return Response.succ(weblogIPage);
    }
    @RequestMapping("/")
    public String showHome() {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        logger.info("当前登陆用户：" + name);
        System.err.println("test12");
        return "home";
    }

    @RequestMapping("/login")
    public String showLogin() {
        return "login";
    }
    @RequestMapping("/admin")
    @ResponseBody
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String printAdmin() {
        return "如果你看见这句话，说明你有ROLE_ADMIN角色";
    }

    @RequestMapping("/user")
    @ResponseBody
    @PreAuthorize("hasRole('ROLE_USER')")
    public String printUser() {
        return "如果你看见这句话，说明你有ROLE_USER角色";
    }
    @RequestMapping("/useradd")
    @ResponseBody
    @PreAuthorize("hasRole('ROLE_USER_ADD')")
    public String printUseradd() {
        return "如果你看见这句话，说明你有ROLE_USER_ADD角色";
    }
}
