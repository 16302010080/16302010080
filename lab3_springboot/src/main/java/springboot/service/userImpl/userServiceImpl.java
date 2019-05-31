package springboot.service.userImpl;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.dao.UserDao;
import springboot.domain.User;
import springboot.service.UserService;

import java.util.List;
import java.util.Map;

@Service
public class userServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public List<User> findAllUser() {
        return userDao.findAllUser();
    }

    @Override
    public String addUser(User user){ return userDao.addUser(user);}

    @Override
    public User UserNamePassword(@Param("params")Map<String,String> map){
//        System.out.println(map.get("username")+","+map.get("password"));
        return userDao.UserNamePassword(map);
    }
}
