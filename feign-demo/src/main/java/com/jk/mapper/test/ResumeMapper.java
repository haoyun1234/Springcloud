package com.jk.mapper.test;

import com.jk.model.test.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import java.util.List;


@Mapper
@Component
public interface ResumeMapper {

    @Select("SELECT * FROM t_resumeUser where id = #{userid}")
    List<ResumeUser> selectResumeUser(@Param("userid") Integer userid);

    @Select("SELECT * FROM t_skillExpertise where userid = #{userid}")
    List<SkillExpertise> selectSkillExpertise(Integer userid);

    @Select("SELECT * FROM t_workExperience where userid = #{userid}")
    List<WorkExperience> selectWorkExperience(Integer userid);

    @Select("SELECT * FROM t_educationalExperience where userid = #{userid}")
    List<EducationalExperience> selectEducationalExperience(Integer userid);

    @Select("SELECT * FROM t_project where userid = #{userid}")
    List<Project> selectProject(Integer userid);
}
