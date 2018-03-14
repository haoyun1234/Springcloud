package com.jk.service.test;

import com.jk.model.test.*;
import java.util.List;

public interface ResumeService {
    /**
     * 查询简历的用户信息
     * @param userid
     * @return
     */
    List<ResumeUser> selectResumeUser(Integer userid);

    List<SkillExpertise> selectSkillExpertise(Integer userid);

    List<WorkExperience> selectWorkExperience(Integer userid);

    List<EducationalExperience> selectEducationalExperience(Integer userid);

    List<Project> selectProject(Integer userid);
}
