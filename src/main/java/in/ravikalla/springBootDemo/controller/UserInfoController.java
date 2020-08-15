package in.ravikalla.springBootDemo.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import in.ravikalla.springBootDemo.entity.UserInfo;
import in.ravikalla.springBootDemo.util.DemoUtil;

@RestController
@RequestMapping("/userInfo")
public class UserInfoController {

	private static final Logger l = LogManager.getLogger(UserInfoController.class);

	@RequestMapping(method = RequestMethod.GET)
	public List<UserInfo> get() {
		l.info("Start : UserInfoController.get()");

		List<UserInfo> userInfo = DemoUtil.getUserInfo();

		l.info("End : UserInfoController.get()");

		return userInfo;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public UserInfo get(@PathVariable Long id) {
		l.info("Start : UserInfoController.get() : id = {}", id);

		UserInfo userInfo = DemoUtil.getUserInfo(id);

		l.info("End : UserInfoController.get() : id = {} : UserInfo = {}", id, userInfo);

		return userInfo;
	}

	@RequestMapping(method = RequestMethod.POST)
	public void post(@RequestBody UserInfo userInfo) {
		l.info("Start : UserInfoController.post() : (null == userInfo) = {}", (null == userInfo));

		DemoUtil.createUserInfo(userInfo);

		l.info("End : UserInfoController.post() : (null == userInfo) = {}", (null == userInfo));
	}	

	@RequestMapping(method = RequestMethod.DELETE)
	public void delete() {
		l.info("Start : UserInfoController.delete()");

		DemoUtil.deleteUserInfo();

		l.info("End : UserInfoController.delete()");
	}	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Long id) {
		l.info("Start : UserInfoController.delete() : id = {}", id);

		DemoUtil.deleteUserInfo(id);

		l.info("End : UserInfoController.delete() : id = {}", id);
	}	
	@RequestMapping(method = RequestMethod.PUT)
	public void put(@RequestBody UserInfo userInfo) {
		l.info("Start : UserInfoController.put() : (null == userInfo) = {}", (null == userInfo));

		DemoUtil.updateUserInfo(userInfo);

		l.info("End : UserInfoController.put() : (null == userInfo) = {}", (null == userInfo));
	}	
}
