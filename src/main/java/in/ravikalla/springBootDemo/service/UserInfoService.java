package in.ravikalla.springBootDemo.service;

import java.util.List;
import java.util.Optional;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import in.ravikalla.springBootDemo.document.UserInfo;
import in.ravikalla.springBootDemo.repository.UserInfoRepository;

@Service
public class UserInfoService {
	private static final Logger l = LogManager.getLogger(UserInfoService.class);

	private UserInfoRepository userInfoRepository;

	public UserInfoService(UserInfoRepository userInfoRepository) {
		this.userInfoRepository = userInfoRepository;
	}

	public void createUserInfo(UserInfo userInfo) {
		l.debug("Start : UserInfoService.createUserInfo(...)");
		
		userInfoRepository.save(userInfo);
		
		l.debug("End : UserInfoService.createUserInfo(...)");
	}

	public List<UserInfo> get() {
		l.debug("Start : UserInfoService.get(...)");

		List<UserInfo> findAll = userInfoRepository.findAll();

		l.debug("End : UserInfoService.get(...) : findAll.size() = {}", (CollectionUtils.isEmpty(findAll)?0:findAll.size()));
		return findAll;
	}
	public UserInfo get(Long id) {
		l.debug("Start : UserInfoService.get(...) : id = {}", id);

		Optional<UserInfo> optUserInfo = userInfoRepository.findById(id);

		l.debug("End : UserInfoService.get(...) : id = {}, UserExist = {}", id, optUserInfo.isPresent());
		return optUserInfo.get();
	}
	public void delete(Long id) {
		l.debug("Start : UserInfoService.delete(...) : id = {}", id);

		userInfoRepository.deleteById(id);

		l.debug("End : UserInfoService.delete(...) : id = {}", id);
	}	
	public void deleteAll() {
		l.debug("Start : UserInfoService.deleteAll()");

		userInfoRepository.deleteAll();

		l.debug("End : UserInfoService.deleteAll()");
	}	
	public void update(UserInfo userInfo) {
		l.debug("Start : UserInfoService.Update(...) : userInfo = {}", userInfo);

		userInfoRepository.save(userInfo);

		l.debug("End : UserInfoService.Update(...) : userInfo = {}", userInfo);
	}	
}
