package springboot.controller;

import org.apache.ibatis.session.SqlSession;
import org.springframework.web.bind.annotation.*;
import springboot.domain.User;
import springboot.request.SqlSessionLoader;
import springboot.request.UserRegisterRequest;
import springboot.response.ErrorResponse;
import springboot.response.LoginResponse;
import springboot.response.RegisterResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/user/register", method = RequestMethod.POST)
    public @ResponseBody
    Object register(@RequestBody (required=false)UserRegisterRequest request) throws IOException {

        SqlSession sqlSession = SqlSessionLoader.getSqlSession();
        User user = sqlSession.selectOne("springboot.dao.UserDao.findUserByUsername", request.getUsername());
        if (user != null) {
            sqlSession.close();
            return new ErrorResponse("The username is already used");
        } else {
            sqlSession.insert("springboot.dao.UserDao.addUser", new User(request.getUsername(), request.getPassword(), request.getEmail(), request.getPhone()));
            sqlSession.commit();
            sqlSession.close();
            return new RegisterResponse(request.getUsername(), request.getPassword(), request.getEmail(), request.getPhone()); // use your generated token here.
        }
    }
    /**
     * 用户登录
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public @ResponseBody
    Object login(@RequestBody UserRegisterRequest request) throws IOException {

        SqlSession sqlSession = SqlSessionLoader.getSqlSession();
        Map<String,String> map=new HashMap<String,String>();
        map.put("username",request.getUsername());
        map.put("password",request.getPassword());
        User user=sqlSession.selectOne("springboot.dao.UserDao.UserNamePassword",map);
        if (user == null) {
            sqlSession.close();
            return new ErrorResponse("The username is null");
        } else {
            sqlSession.close();//现在还不应该观关session
            return new LoginResponse(user.getUserName(),"*******","  login success!!");
        }
    }
    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public @ResponseBody
    List<User> findAllUser() throws IOException {
        SqlSession sqlSession = SqlSessionLoader.getSqlSession();
        List<User> uses = sqlSession.selectList("springboot.dao.UserDao.findAllUser");
        sqlSession.close();
        return uses;
    }
}
