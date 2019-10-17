package com.service;

import com.entity.MenuRole;
import com.mapper.MenuRoleMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuRoleService
{
  @Autowired
  private MenuRoleMapper menuRoleMapper;

  public List<MenuRole> selectByRoleId(Long roleId)
  {
    return menuRoleMapper.selectByRoleId(roleId);
  }

}
