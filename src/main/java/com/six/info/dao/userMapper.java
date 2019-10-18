package com.six.info.dao;

import com.six.info.entity.Info;
import com.six.info.entity.Login;
import com.six.info.entity.Point;
import com.six.info.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface userMapper {
    User findOne(User user);
    List<User> findExpert();
    int addUser(User user);
    int addUserInfo(Info info);
    Info findUserInfo();
    Point findPointByHonor(String string);
    int addExperts(User user);
    int update(User user);
    int addToken(Login login);
    int updateToken(Login login);
    Login findIdByToken(Login login);
    Login findUseridByToken(Login login);
    Login findByUserId(Login login);
    int findUserIdByToken(String token);


    int changePassword(User user);

    User findByUserPhoneNum(String mobile);

    void isRead(@Param("questionId")int questionId, @Param("expertId")int expertId);

    /**
     * 插入一条数据
     * @param data Map中包含id,username,password
     */
}
