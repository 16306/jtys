package com.service;

import com.entity.UserExample;
import com.entity.UserRole;
import com.entity.UserRoleExample;
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

  public List<UserRole> selectByExample(UserRoleExample example)
  {
    return userRoleMapper.selectByExample(example);
  }

  public int insert(UserRole record)
  {
    return userRoleMapper.insert(record);
  }

  public Long getMaxId()
  {
    UserRoleExample example = new UserRoleExample();
    example.setOrderByClause("user_role_id desc");
    Long id= selectByExample(example).get(0).getUserRoleId() + 1;
    return id;
  }


}
