package com.config;

import com.service.RoleService;
import com.service.UserRoleService;
import com.service.UserService;
import com.entity.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userDetailsService")
public class UserConfig implements UserDetailsService
{

  @Autowired
  private UserService userService;

  @Autowired
  private RoleService roleService;

  @Autowired
  private UserRoleService userRoleService;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
  {
    //查询用户
    com.entity.User user = userService.selectByName(username);
    if(user == null) {
      throw new UsernameNotFoundException("用户名不存在");
    }
    //查询权限
    List<com.entity.UserRole> RoleList = userRoleService.selectByUserId(user.getUesrId());
    Collection<GrantedAuthority> authorities = new ArrayList<>();
    for (UserRole userRole : RoleList) {
      Role role = roleService.selectByPrimaryKey(userRole.getRoleId());
      authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
    }
    authorities.add(new SimpleGrantedAuthority(user.getUesrId().toString()));
    // 封装用户信息，并返回。参数分别是：用户名，密码，用户权限
    return new User(user.getUserName(), user.getPassword(), authorities);
  }
}