package com.service;

import com.entity.User;
import com.entity.UserExample;
import com.mapper.UserMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService
{
  @Autowired
  private UserMapper userMapper;

  public int countByExample(UserExample example)
  {
    return userMapper.countByExample(example);
  }

  public int deleteByExample(UserExample example)
  {
    return userMapper.deleteByExample(example);
  }

  public int deleteByPrimaryKey(Long uesrId)
  {
    return userMapper.deleteByPrimaryKey(uesrId);
  }

  public int insert(User record)
  {
    return userMapper.insert(record);
  }

  public int insertSelective(User record)
  {
    return userMapper.insertSelective(record);
  }

  public List<User> selectByExample(UserExample example)
  {
    return userMapper.selectByExample(example);
  }

  public User selectByPrimaryKey(Long uesrId)
  {
    return userMapper.selectByPrimaryKey(uesrId);
  }

  public User selectByNameAndPassword(String name,String password)
  {
    return userMapper.selectByNameAndPassword(name,password);
  }

  /**
   * 通过用户名查找user
   * @param name
   * @return
   */
  public User selectByName(String name)
  {
    return userMapper.selectByName(name);
  }

  public int updateByExampleSelective(User record, UserExample example)
  {
    return userMapper.updateByExampleSelective(record, example);
  }

  public int updateByExample(User record, UserExample example)
  {
    return userMapper.updateByExample(record,example);
  }

  public int updateByPrimaryKeySelective(User record)
  {
    return userMapper.updateByPrimaryKeySelective(record);
  }

  public int updateByPrimaryKey(User record)
  {
    return userMapper.updateByPrimaryKey(record);
  }

  public  Long getMaxId()
  {
    UserExample example = new UserExample();
    example.setOrderByClause("uesr_id desc");
    Long userId= selectByExample(example).get(0).getUesrId() + 1;
    return userId;
  }
}
