package springboot.service;

import org.springframework.stereotype.Repository;
import springboot.domain.User;

import java.util.List;
import java.util.Map;

@Repository
public interface UserService {


    List<User> findAllUser();

    String addUser(User user);
    User UserNamePassword(Map<String,String> map);
}
