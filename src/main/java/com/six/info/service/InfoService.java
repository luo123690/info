package com.six.info.service;

import com.six.info.dao.ApplicationMapper;
import com.six.info.dao.userMapper;
import com.six.info.entity.Application;
import com.six.info.entity.Info;
import com.six.info.entity.Point;
import com.six.info.entity.Type;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Max;
import java.util.*;

@Service
public class InfoService {
    private userMapper userMapper;
    private ApplicationMapper applicationMapper;

    @Autowired
    public InfoService(userMapper userMapper,ApplicationMapper applicationMapper) {
        this.userMapper = userMapper;
        this.applicationMapper=applicationMapper;
    }

    public Info addUserInfo(Info info){
        userMapper.addUserInfo(info);
        return info;
    }

    public Info addInfo(Info info){
        double sumPoint=0;
        double professionPoint=0;
        double professionWeight=0;
        if(info.getProfession()!=null&&info.getProfession().length()!=0){
            //根据用户选择的专业的ID，按照“,”分割开，并查询数据库中对应的分数与权重
            ArrayList<Integer> professionPointList = new ArrayList<Integer>();
            String[] professionList=info.getProfession().split(",");
            for(int i=0;i<professionList.length;i++){
                Point point= userMapper.findPointByHonor(professionList[i]);
                if(!point.equals("")){
                    professionPointList.add(point.getPoint());
                    professionWeight=point.getWeight();
                }

            }
            professionPoint= Collections.max(professionPointList)*professionWeight;
        }

        //根据用户选择的教育的ID，按照“,”分割开，并查询数据库中对应的分数与权重
        double educationPoint=0.0;
        double educationWeight=0.0 ;
        if(info.getEducation()!=null&&info.getEducation().length()!=0){
            ArrayList<Integer> educationPointList = new ArrayList<Integer>();
            String[] educationList=info.getEducation().split(",");
            for(int i=0;i<educationList.length;i++){
                Point point= userMapper.findPointByHonor(educationList[i]);
                educationPointList.add(point.getPoint());
                educationWeight= point.getWeight();
            }
            educationPoint= Collections.max(educationPointList)*educationWeight;
        }
        //荣誉加分
        double honorSumPoint=0;
        double honorPoint=0;
        double honorWeight=0;
        if(info.getHonor()!=null&&info.getHonor().length()!=0){
            ArrayList<Integer> honorPointList = new ArrayList<Integer>();
            String[] honorList=info.getHonor().split(",");
            for(int i=0;i<honorList.length;i++){
                Point point= userMapper.findPointByHonor(honorList[i]);
                honorPointList.add(point.getPoint());
                honorSumPoint+=point.getPoint();
                if(honorSumPoint>100)
                    honorSumPoint=100;
                honorWeight= point.getWeight();
            }
            honorPoint=honorSumPoint*honorWeight;
        }

        //技能竞赛加分
        double skillSumPoint=0;
        double skillPoint=0;
        double skillWeight=0;
        if(info.getSkill()!=null&&info.getSkill().length()!=0){
            ArrayList<Integer> skillPointList = new ArrayList<Integer>();
            String[] skillList=info.getSkill().split(",");
            for(int i=0;i<skillList.length;i++){
                Point point= userMapper.findPointByHonor(skillList[i]);
                skillPointList.add(point.getPoint());
                skillSumPoint+=point.getPoint();
                if(skillSumPoint>100)
                    skillSumPoint=100;
                skillWeight= point.getWeight();
            }
            skillPoint=skillSumPoint*skillWeight;
        }


        //科技进步、创新奖
        double tecSumPoint=0;
        double tecPoint=0;
        double tecWeight=0;
        if(info.getTechnology()!=null&&info.getTechnology().length()!=0){
            ArrayList<Integer> tecPointList = new ArrayList<Integer>();
            String[] tecList=info.getTechnology().split(",");
            for(int i=0;i<tecList.length;i++){
                Point point= userMapper.findPointByHonor(tecList[i]);
                tecPointList.add(point.getPoint());
                tecSumPoint+=point.getPoint();
                if(tecSumPoint>100)
                    tecSumPoint=100;
                tecWeight= point.getWeight();
            }
            tecPoint=tecSumPoint*tecWeight;
        }


       // 专利
        double patentSumPoint=0;
        double patentPoint=0;
        double patentWeight=0;
        if(info.getPatent()!=null&&info.getPatent().length()!=0){
            ArrayList<Integer> patentPointList = new ArrayList<Integer>();
            String[] patentList=info.getPatent().split(",");
            for(int i=0;i<patentList.length;i++){
                Point point= userMapper.findPointByHonor(patentList[i]);
                patentPointList.add(point.getPoint());
                patentSumPoint+=point.getPoint();
                if(patentSumPoint>100)
                    patentSumPoint=100;
                patentWeight= point.getWeight();
            }
            patentPoint=patentSumPoint*patentWeight;
        }
        //论文著作

        double paperSumPoint=0;
        double paperPoint=0;
        double paperWeight=0;
        if(info.getPaper()!=null&&info.getPaper().length()!=0){
            ArrayList<Integer> paperPointList = new ArrayList<Integer>();
            String[] paperList=info.getPaper().split(",");
            for(int i=0;i<paperList.length;i++){
                Point point= userMapper.findPointByHonor(paperList[i]);
                paperPointList.add(point.getPoint());
                paperSumPoint+=point.getPoint();
                if(paperSumPoint>100)
                    paperSumPoint=100;
                paperWeight= point.getWeight();
            }
            paperPoint=paperSumPoint*paperWeight;
        }
        //论文著作

        double proSumPoint=0;
        double proPoint=0;
        double proWeight=0;
        if(info.getProfessor()!=null&&info.getProfession().length()!=0){
            ArrayList<Integer> proPointList = new ArrayList<Integer>();
            String[] proList=info.getProfessor().split(",");
            for(int i=0;i<proList.length;i++){
                Point point= userMapper.findPointByHonor(proList[i]);
                proPointList.add(point.getPoint());
                proSumPoint+=point.getPoint();
                if(proSumPoint>100)
                    proSumPoint=100;
                proWeight= point.getWeight();
            }
            proPoint=proSumPoint*proWeight;
        }

        sumPoint = professionPoint+educationPoint+honorPoint+skillPoint+tecPoint+patentPoint+paperPoint+proPoint;

        info.setPoint(sumPoint);
        userMapper.addInfo(info);
        return info;
    }
    public Application addUserApply(Application application){
        applicationMapper.addUserApply(application);
        return application;
    }
    public List findType(){
        List<Type> list= applicationMapper.findType();
        ArrayList<String> typeList = new ArrayList<String>();
        for(int i=0;i<list.size();i++){
            typeList.add(list.get(i).getType());
        }
        Set set =new HashSet(typeList);
        List type = new ArrayList(set);
        return type;
    }
    public List findProfessionF(String type){
        List<Type> list= applicationMapper.findProfessionF(type);
        ArrayList<String> proFList = new ArrayList<String>();
        for(int i=0;i<list.size();i++){
            proFList.add(list.get(i).getProfessionF());
        }
        Set set =new HashSet(proFList);
        List proF = new ArrayList(set);
        return proF;
    }
    public List findProfessionS(String type){
        List<Type> list= applicationMapper.findProfessionS(type);
        ArrayList<String> proSList = new ArrayList<String>();
        for(int i=0;i<list.size();i++){
            proSList.add(list.get(i).getProfessionS());
        }
        Set set =new HashSet(proSList);
        List proS = new ArrayList(set);
        return proS;
    }
    public int updateUserPoint(Info info){
        info.setIsread(1);
        return userMapper.updateUserPoint(info);
    }
    public Application findApplyInfoById(int id){
        return userMapper.findApplyInfoById(id);
    }

    public Type findTypeByProfession(Type type){
        Type type1=userMapper.findTypeByProfession(type);
        return type1;
    }

    public List<Info> findInfoList(Type type){
        Type type1=userMapper.findTypeByProfession(type);
        System.out.println(type1.getId());
        List<Info> InfoList =userMapper.findInfoList(type1.getId());
        return InfoList;
    }

    public Info findInfoById(int id){
        return userMapper.findInfoById(id);
    }
}
