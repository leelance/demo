package com.lance.shiro.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * 验证用户登录
 * @author Administrator
 */
public class UserRealm extends AuthorizingRealm{
	
	public UserRealm() {
		setName("UserRealm");
	}

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken upt = (UsernamePasswordToken)token;
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(upt.getUsername(), upt.getPassword(), getName());
		return info;
	}
}