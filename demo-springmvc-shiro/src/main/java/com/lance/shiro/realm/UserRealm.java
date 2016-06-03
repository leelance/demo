package com.lance.shiro.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.lance.shiro.model.UserInfo;
import com.lance.shiro.service.UserService;

/**
 * 验证用户登录
 * @author Administrator
 */
public class UserRealm extends AuthorizingRealm{
	@Autowired
	private UserService userService;
	
	public UserRealm() {
		setName("UserRealm");
		//采用MD5加密
		setCredentialsMatcher(new HashedCredentialsMatcher("md5"));
	}

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken upt = (UsernamePasswordToken)token;
		String userName = upt.getUsername();
		UserInfo user = userService.findByAccount(userName);
		
		if(user == null) {
			throw new UnknownAccountException();
		}
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(userName, user.getPassword(), getName());
		return info;
	}
}