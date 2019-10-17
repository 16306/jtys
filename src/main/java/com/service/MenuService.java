package com.service;

import com.entity.Menu;
import com.mapper.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuService
{
  @Autowired
  private MenuMapper menuMapper;

  public Menu selectByPrimaryKey(Long menuId)
  {
    return menuMapper.selectByPrimaryKey(menuId);
  }
}
