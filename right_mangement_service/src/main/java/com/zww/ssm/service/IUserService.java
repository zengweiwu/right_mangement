package com.zww.ssm.service;

import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * 用户权限操作的服务层接口，该接口需要继承UserDetails接口
 */
public interface IUserService  extends UserDetailsService {
}
