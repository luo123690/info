package com.six.info.service;
import com.six.info.dao.userMapper;
import com.six.info.entity.Login;
import com.six.info.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

/**
 * Created by Cookie on 2019/1/24.
 */
@Service
public class UserService {
    private userMapper userMapper;

    @Autowired
    public UserService(userMapper userMapper) {
        this.userMapper = userMapper;
    }


    public String passwordToHash(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            digest.update(password.getBytes());
            byte[] src = digest.digest();
            StringBuilder stringBuilder = new StringBuilder();
            // 字节数组转16进制字符串
            // https://my.oschina.net/u/347386/blog/182717
            for (byte aSrc : src) {
                String s = Integer.toHexString(aSrc & 0xFF);
                if (s.length() < 2) {
                    stringBuilder.append('0');
                }
                stringBuilder.append(s);
            }
            return stringBuilder.toString();
        } catch (NoSuchAlgorithmException ignore) {
        }
        return null;
    }

    public User findById(int id) {
        User user = new User();
        user.setId(id);
        return userMapper.findOne(user);
    }
    public List<User> findExpert() {
        return userMapper.findExpert();
    }
//    public Login findByTokenId(Integer id) {
//        User user = new User();
//        Login login = new Login();
//        login.setUserid(user.getId());
//        return tokenMapper.findOne(login);
//    }
    public int addUser(User user) {
        String passwordHash =  passwordToHash(user.getPassword());
        user.setPassword(passwordHash);
        return userMapper.addUser(user);
    }





    public int addExperts(User user) {
        String passwordHash =  passwordToHash(user.getPassword());
        user.setPassword(passwordHash);
        return userMapper.addExperts(user);
    }
    public int addToken(Login login) {
       // User user = new User();
        login.setToken(login.getToken());
        return userMapper.addToken(login);
    }
//    public int changeUnReadQuestion(Invite invite){
//        return userMapper.changeUnReadQuestion(invite);
//    }
//    public Invite remindTheNews(int expertId){
//        Invite invite =new Invite();
//        invite.setExpertId(expertId);
//        invite.setIsread(0);
//        return userMapper.remindTheNews(invite);
//    }
    public int updateUser(User user){
        return userMapper.update(user);
    }
    public User findByUsername(String username) {
        User user = new User();
        user.setUsername(username);

        return userMapper.findOne(user);
    }
    public  Login findByUserId(int id){
        Login login =new Login();
        login.setUserid(id);
        return userMapper.findByUserId(login);
    }
    public Login findUseridByToken(String token) {
        Login login = new Login();
        login.setToken(token);
        return userMapper.findUseridByToken(login);
    }
    public Login findIdByToken(String token) {
        Login login = new Login();
        login.setToken(token);
        return userMapper.findIdByToken(login);
    }
    public int updateToken(Login login) {
        return userMapper.updateToken(login);
    }

    public User findByUser(String username) {
        User param = new User();
        param.setUsername(username);
        return userMapper.findOne(param);
    }
    public boolean compareUsername(User user, User userInDataBase) {
        return user.getUsername()
                .equals(userInDataBase.getUsername());
    }
    public boolean comparePassword(User user, User userInDataBase) {
        return passwordToHash(user.getPassword())      // 将用户提交的密码转换为 hash
                .equals(userInDataBase.getPassword()); // 数据库中的 password 已经是 hash，不用转换
    }

    public int changePassword(User user){

        return userMapper.changePassword(user);
    }

    public User findByUserPhoneNum(String mobile) {
        return userMapper.findByUserPhoneNum(mobile);
    }

    public void isRead(@Param("questionId")int questionId,@Param("expertId")int expertId) {
        userMapper.isRead(questionId,expertId);
    }


//    public Invite[] queryExpertId(int questionId) {
//       return userMapper.queryExpertId(questionId);
//    }
}
