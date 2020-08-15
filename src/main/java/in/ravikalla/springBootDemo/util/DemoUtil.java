package in.ravikalla.springBootDemo.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import in.ravikalla.springBootDemo.entity.UserInfo;

public class DemoUtil {
	private static List<UserInfo> lstUserInfo = new ArrayList<UserInfo>();

	public static void createUserInfo(UserInfo userInfo) {
		if (null != userInfo)
			lstUserInfo.add(userInfo);
	}
	public static List<UserInfo> getUserInfo() {
		return lstUserInfo;
	}
	public static UserInfo getUserInfo(Long id) {
		Optional<UserInfo> findFirst = lstUserInfo.stream().filter(p -> p.getId().equals(id)).findFirst();
		return findFirst.get();
	}
	public static void deleteUserInfo() {
		lstUserInfo.clear();
	}
	public static void deleteUserInfo(Long id) {
		lstUserInfo.removeIf(p -> p.getId().equals(id));
	}
	public static void updateUserInfo(UserInfo userInfo) {
		deleteUserInfo(userInfo.getId());
		createUserInfo(userInfo);
	}
}
