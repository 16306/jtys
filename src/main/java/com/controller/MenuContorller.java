package com.controller;

import com.entity.Menu;
import com.entity.MenuRole;
import com.service.MenuRoleService;
import com.service.MenuService;
import com.service.UserRoleService;
import com.service.UserService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/menu")
public class MenuContorller
{
  @Autowired
  private MenuRoleService menuRoleService;

  @Autowired
  private MenuService menuService;

  @Autowired
  private UserRoleService userRoleService;

  @Autowired
  private UserService userService;

  @ResponseBody
  @PostMapping("/findMenuByRole")
  public List<Menu> findMenuByRole()
  {
    User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    Long Id = Long.parseLong(user.getAuthorities().toArray()[0].toString());
    Long roleId = userRoleService.selectByUserId(Id).get(0).getRoleId();
    List<MenuRole> menuList = menuRoleService.selectByRoleId(roleId);
    List<Menu> menus = new ArrayList<>();
    for(MenuRole menuRole : menuList)
    {
      Menu menu = menuService.selectByPrimaryKey(menuRole.getMenuId());
      menus.add(menu);
    }
    return menus;
  }
}
