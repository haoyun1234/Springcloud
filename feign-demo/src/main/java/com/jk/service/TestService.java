package com.jk.service;

import com.jk.model.*;

import java.util.List;

public interface TestService {
    //测试项目
    int getCount();

    List<FreeProject> queryProject(Integer userid);

    List<FreeUser> queryUser();

    List<FreeSkill> querySkill(Integer userid);

    List<FreeExperience> queryExperience(Integer userid);

    List<FreeEducation> queryEducation(Integer userid);


}
