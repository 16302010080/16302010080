package springboot.dao;


import springboot.domain.User;

import java.util.List;
import java.util.Map;

/**
 * 学生接口
 */

public interface UserDao {


    /**
     * 获取学生信息列表
     *
     * @return
     */
    List<User> findAllUser();

    String addUser(User user);

    User UserNamePassword(Map<String,String> map);
}
