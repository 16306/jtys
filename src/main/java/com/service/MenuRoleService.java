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

  /**
   * 通过roleid得到MenuRole列表
   * @param roleId
   * @return MenuRole列表
   */
  public List<MenuRole> selectByRoleId(Long roleId)
  {
    return menuRoleMapper.selectByRoleId(roleId);
  }

}
