package com.linkpal.config;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.linkpal.domain.entity.SysRole;
import com.linkpal.domain.entity.SysUser;
import com.linkpal.domain.entity.SysUserRole;
import com.linkpal.mapper.SysRoleMapper;
import com.linkpal.mapper.SysUserMapper;
import com.linkpal.mapper.SysUserRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service("userDetailsService")
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private SysRoleMapper roleMapper;

    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        // 从数据库中取出用户信息

        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",username);
         SysUser sysUser = sysUserMapper.selectOne(queryWrapper);
        // 判断用户是否存在
        if(sysUser == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        QueryWrapper<SysUserRole> rolewapper = new QueryWrapper<>();
        rolewapper.eq("user_id",sysUser.getUserId());
        // 添加权限
        List<SysUserRole> sysUserRoles = sysUserRoleMapper.selectList(rolewapper);
        System.err.println("sysUserRoles:"+sysUserRoles);
        for (SysUserRole userRole : sysUserRoles) {
            QueryWrapper<SysRole> roleQueryWrapper = new QueryWrapper<>();
            roleQueryWrapper.eq("role_id",userRole.getRoleId());
            SysRole sysRole1 = roleMapper.selectOne(roleQueryWrapper);
            authorities.add(new SimpleGrantedAuthority(sysRole1.getRoleName()));
        }
        System.err.println("用户权限为:"+authorities);
        System.err.println(new User(sysUser.getUsername(), sysUser.getPassword(), authorities));
        // 返回UserDetails实现类
        return new User(sysUser.getUsername(), sysUser.getPassword(), authorities);
    }
}
