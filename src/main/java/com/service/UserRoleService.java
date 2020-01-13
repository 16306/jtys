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

  /**
   * 通过UserId查找UserRole列表
   * @param userId
   * @return
   */
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

  /**
   * 得到最后一条UserRoleId + 1
   * @return
   */
  public Long getMaxId()
  {
    UserRoleExample example = new UserRoleExample();
    example.setOrderByClause("user_role_id desc");
    Long id= selectByExample(example).get(0).getUserRoleId() + 1;
    return id;
  }


}
