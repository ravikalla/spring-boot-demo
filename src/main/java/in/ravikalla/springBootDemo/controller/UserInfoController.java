package in.ravikalla.springBootDemo.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import in.ravikalla.springBootDemo.document.UserInfo;
import in.ravikalla.springBootDemo.service.UserInfoService;

@RestController
@RequestMapping("/userInfo")
public class UserInfoController {

	private static final Logger l = LogManager.getLogger(UserInfoController.class);

	private UserInfoService userInfoService;

	public UserInfoController(UserInfoService userInfoService) {
		this.userInfoService = userInfoService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<UserInfo> get() {
		l.info("Start : UserInfoController.get()");

		List<UserInfo> lstUserInfo = userInfoService.get();

		l.info("End : UserInfoController.get()");

		return lstUserInfo;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public UserInfo get(@PathVariable Long id) {
		l.info("Start : UserInfoController.get() : id = {}", id);

		UserInfo userInfo = userInfoService.get(id);

		l.info("End : UserInfoController.get() : id = {} : UserInfo = {}", id, userInfo);

		return userInfo;
	}

	@RequestMapping(method = RequestMethod.POST)
	public void post(@RequestBody UserInfo userInfo) {
		l.info("Start : UserInfoController.post() : (null == userInfo) = {}", (null == userInfo));

		userInfoService.createUserInfo(userInfo);

		l.info("End : UserInfoController.post() : (null == userInfo) = {}", (null == userInfo));
	}

	@RequestMapping(method = RequestMethod.DELETE)
	public void delete() {
		l.info("Start : UserInfoController.delete()");

		userInfoService.deleteAll();

		l.info("End : UserInfoController.delete()");
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Long id) {
		l.info("Start : UserInfoController.delete() : id = {}", id);

		userInfoService.delete(id);

		l.info("End : UserInfoController.delete() : id = {}", id);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public void put(@RequestBody UserInfo userInfo) {
		l.info("Start : UserInfoController.put() : (null == userInfo) = {}", (null == userInfo));

		userInfoService.update(userInfo);

		l.info("End : UserInfoController.put() : (null == userInfo) = {}", (null == userInfo));
	}
}
