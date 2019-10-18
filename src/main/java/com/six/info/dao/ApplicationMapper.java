package com.six.info.dao;

import com.six.info.entity.Application;
import com.six.info.entity.Type;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ApplicationMapper {
    List<Application> findUserApplyList(int userid);
    Application findUserApply(int id);
    int addUserApply(Application application);
    List<Type> findType();
    List<Type> findProfessionF(String type);
    List<Type> findProfessionS(String professionF);
}
