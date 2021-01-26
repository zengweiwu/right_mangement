package com.zww.ssm.service.impl;

import com.zww.ssm.dao.IUserDao;
import com.zww.ssm.domain.Role;
import com.zww.ssm.domain.UserInfo;
import com.zww.ssm.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service("userService")
@Transactional
public class IUserServiceImpl implements IUserService {
    @Autowired
    private IUserDao userDao;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //根据用户名查询出userInfo
        UserInfo userInfo = null;
        try {
            userInfo = userDao.findUserByUserName(username);
        }catch (Exception e){
            e.printStackTrace();
        }
        //封装UserDetails对象
        //UserDetails userDetails = new User(userInfo.getUsername(),userInfo.getPassword(), getAuthorities(userInfo.getRoles()));
        //封装作用更强大的userDetails 如果用户状态为0则用户不可用
        UserDetails userDetails = new User(userInfo.getUsername(),userInfo.getPassword(), userInfo.getStatus() == 0 ? false : true,true,true,true,getAuthorities(userInfo.getRoles()));
        return userDetails;
    }

    private List<SimpleGrantedAuthority> getAuthorities(List<Role> roles) {
        List<SimpleGrantedAuthority> grantedAuthorityList = new ArrayList<>();
        //将询出的role构造成SimpleGrantedAuthority对象
        if (roles != null){
            for (Role role:roles) {
                grantedAuthorityList.add(new SimpleGrantedAuthority("ROLE_"+role.getRoleName()));
            }
        }
        return grantedAuthorityList;
    }
}
