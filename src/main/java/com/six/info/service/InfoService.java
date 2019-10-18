package com.six.info.service;

import com.six.info.dao.userMapper;
import com.six.info.entity.Info;
import com.six.info.entity.Point;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Max;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class InfoService {
    private userMapper userMapper;

    @Autowired
    public InfoService(userMapper userMapper) {
        this.userMapper = userMapper;
    }

    public static int MaxByfunction(int numberlist[]) {
        int max = numberlist[0];
        for (int i = 0; i < numberlist.length; i++) {
            if (numberlist[i] > max)
                max = numberlist[i];
        }
        return max;
    }
    public int addUserInfo(Info info){
        double sumPoint=0;
        double professionPoint=0;
        double professionWeight=0;
        if(info.getProfession()!=null){
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
        if(info.getEducation()!=null){
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
        if(info.getHonor()!=null){
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
        if(info.getSkill()!=null){
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
        if(info.getTechnology()!=null){
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
        if(info.getPatent()!=null){
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
        if(info.getPaper()!=null){
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
        if(info.getProfessor()!=null){
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
        System.out.println("1:"+professionPoint);
        System.out.println("2:"+educationPoint);
        System.out.println("3:"+honorPoint);
        System.out.println("4:"+skillPoint);
        System.out.println("5:"+tecPoint);
        System.out.println("6:"+patentPoint);
        System.out.println("7:"+paperPoint);
        System.out.println("8:"+proPoint);
        System.out.println(sumPoint);
        info.setPoint(sumPoint);
        return userMapper.addUserInfo(info);
    }

//    public Info findUserPoint(int id){
//
//    }
}
