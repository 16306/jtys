package com.service;

import com.entity.UserRole;
import com.mapper.UserRoleMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRoleService
{
  @Autowired
  private UserRoleMapper userRoleMapper;

  public List<UserRole> selectByUserId(Long userId)
  {
    return userRoleMapper.selectByUserId(userId);
  }

}
