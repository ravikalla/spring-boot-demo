package in.ravikalla.springBootDemo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import in.ravikalla.springBootDemo.document.UserInfo;

public interface UserInfoRepository extends MongoRepository<UserInfo, Long> {
}
