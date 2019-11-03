package com.config;

import com.entity.MenuRole;
import com.service.MenuRoleService;
import com.service.MenuService;
import com.service.RoleService;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import org.springframework.util.StringUtils;

@Component
public class CustomPermissionEvaluator implements PermissionEvaluator {
  @Autowired
  private MenuRoleService menuRoleService;
  @Autowired
  private RoleService roleService;
  @Autowired
  private MenuService menuService;

  @Override
  public boolean hasPermission(Authentication authentication, Object targetUrl, Object targetPermission)
  {
    // 获得loadUserByUsername()方法的结果
    User user = (User)authentication.getPrincipal();
    // 获得loadUserByUsername()中注入的角色
    Collection<GrantedAuthority> authorities = user.getAuthorities();

    // 遍历用户所有角色
    for(int i = 1; i <= authorities.size() - 1; i++)
    {
      String roleName = authorities.toArray()[i].toString();
      Long roleId = roleService.selectByName(roleName).getRoleId();
      // 得到角色所有的权限
      List<MenuRole> permissionList = menuRoleService.selectByRoleId(roleId);

      // 遍历permissionList
      for(MenuRole menuRole : permissionList)
      {
        // 获取权限集
        List permissions = menuRole.getPermissions();
        String url = menuService.selectByPrimaryKey(menuRole.getMenuId()).getUrl();
        // 如果访问的Url和权限用户符合的话，返回true
        if(targetUrl.equals(url) && !(StringUtils.isEmpty(targetPermission)))
        {
          for(String permission : Arrays.asList(targetPermission.toString().trim().split("&")))
          {
            if(!permissions.contains(permission))
            {
              return false;
            }
          }
          return true;
        }
      }

    }

    return false;
  }

  @Override
  public boolean hasPermission(Authentication authentication, Serializable serializable, String s, Object o)
  {
    return false;
  }
}
