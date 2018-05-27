package cn.mldn.util.web;

import java.util.HashMap;
import java.util.Map;

public class PrivilegeUtil {
	private static final Map<String,Object> PRIVILEGE = new HashMap<String,Object>();;
	private PrivilegeUtil() {}
	public static Map<String, Object> getPrivilege() {
		return PRIVILEGE;
	}
	public static void setPrivilege(String mid,Map<String,Object> info) {
		PRIVILEGE.put(mid, info) ;
	}
	
}
