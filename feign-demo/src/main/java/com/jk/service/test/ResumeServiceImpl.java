package com.jk.service.test;

import com.jk.mapper.test.ResumeMapper;
import com.jk.model.test.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class ResumeServiceImpl implements ResumeService {


    @Autowired
    private ResumeMapper resumeMapper;

    @Override
    public List<ResumeUser> selectResumeUser(Integer userid) {
        return resumeMapper.selectResumeUser(userid);
    }

    @Override
    public List<SkillExpertise> selectSkillExpertise(Integer userid) {
        return resumeMapper.selectSkillExpertise( userid);
    }

    @Override
    public List<WorkExperience> selectWorkExperience(Integer userid) {
        return resumeMapper.selectWorkExperience( userid);
    }

    @Override
    public List<EducationalExperience> selectEducationalExperience(Integer userid) {
        return resumeMapper.selectEducationalExperience( userid);
    }

    @Override
    public List<Project> selectProject(Integer userid) {
        return resumeMapper.selectProject( userid);
    }
}
