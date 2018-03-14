package com.jk.service;

import com.jk.mapper.TestMapper;
import com.jk.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestServiceImpl implements TestService {
    @Autowired
    private TestMapper testMapper;
    //测试项目
    @Override
    public int getCount() {
        return testMapper.getCount();
    }

    @Override
    public List<FreeProject> queryProject(Integer userid) {

        return testMapper.queryProject(userid);
    }

    @Override
    public List<FreeUser> queryUser() {
        return testMapper.queryUser();
    }

    @Override
    public List<FreeSkill> querySkill(Integer userid) {
        return testMapper.querySkill(userid);
    }

    @Override
    public List<FreeExperience> queryExperience(Integer userid) {
        return testMapper.queryExperience(userid);
    }

    @Override
    public List<FreeEducation> queryEducation(Integer userid) {

        return testMapper.queryEducation(userid);
    }


}
