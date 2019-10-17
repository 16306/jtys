package com.service;

import com.entity.Role;
import com.entity.RoleExample;
import com.mapper.RoleMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService
{
  @Autowired
  private RoleMapper roleMapper;

  public int countByExample(RoleExample example)
  {
    return roleMapper.countByExample(example);
  }

  public int deleteByExample(RoleExample example)
  {
    return roleMapper.deleteByExample(example);
  }

  public int deleteByPrimaryKey(Long roleId)
  {
    return roleMapper.deleteByPrimaryKey(roleId);
  }

  public int insert(Role record)
  {
    return roleMapper.insert(record);
  }

  public int insertSelective(Role record)
  {
    return roleMapper.insertSelective(record);
  }

  public List<Role> selectByExampleWithBLOBs(RoleExample example)
  {
    return roleMapper.selectByExampleWithBLOBs(example);
  }

  public List<Role> selectByExample(RoleExample example)
  {
    return roleMapper.selectByExample(example);
  }

  public Role selectByPrimaryKey(Long roleId)
  {
    return roleMapper.selectByPrimaryKey(roleId);
  }

  public Role selectByName(String name)
  {
    return roleMapper.selectByName(name);
  }

  public int updateByExampleSelective(Role record, RoleExample example)
  {
    return roleMapper.updateByExampleSelective(record, example);
  }

  public int updateByExampleWithBLOBs(Role record, RoleExample example)
  {
    return roleMapper.updateByExampleWithBLOBs(record,example);
  }

  public int updateByExample(Role record, RoleExample example)
  {
    return roleMapper.updateByExample(record,example);
  }

  public int updateByPrimaryKeySelective(Role record)
  {
    return roleMapper.updateByPrimaryKeySelective(record);
  }

  public int updateByPrimaryKeyWithBLOBs(Role record)
  {
    return roleMapper.updateByPrimaryKeyWithBLOBs(record);
  }

  public int updateByPrimaryKey(Role record)
  {
    return roleMapper.updateByPrimaryKey(record);
  }

}
