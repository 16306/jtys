package com.util;


import com.service.UserService;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

@Service
public class FindUser
{
  @Autowired
  private UserService userService;

  /**
   * 查找当前用户
   */
  public  static FindUser findUser ;
  @PostConstruct //通过@PostConstruct实现初始化bean之前进行的操作
  public void init() {
    findUser = this;
    findUser.userService = this.userService;
  }

  public com.entity.User getuser()
  {
    User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    Long Id = Long.parseLong(user.getAuthorities().toArray()[0].toString());
    com.entity.User user1 = findUser.userService.selectByPrimaryKey(Id);
    user1.setPassword("[protected]");
    return user1;
  }
}
