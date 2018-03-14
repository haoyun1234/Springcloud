package com.jk.controller.test;

import com.itextpdf.text.pdf.BaseFont;
import com.jk.model.test.*;
import com.jk.service.test.ResumeService;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import org.xhtmlrenderer.pdf.ITextFontResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;

@Controller
public class ResumeController {

    @Autowired
    public ResumeService resumeService;


    /*@RequestMapping("test666")
    @ResponseBody
    public void aa(){
        Integer userid = 1;
        //查询简历中的用户信息
        List<ResumeUser> resumeUsers =  resumeService.selectResumeUser(userid);
        //查询简历中的技能专长
        List<SkillExpertise> selectSkillExpertise =  resumeService.selectSkillExpertise(userid);
        //查询简历中的工作经历
        List<WorkExperience> workExperiences =  resumeService.selectWorkExperience(userid);
        //查询简历中的教育经历
        List<EducationalExperience> educationalExperiences =  resumeService.selectEducationalExperience(userid);
        //查询简历中的项目信息
        List<Project> projects =  resumeService.selectProject(userid);

        System.out.println("OK");

        // 制造数据
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("resumeUsers", resumeUsers);
        map.put("selectSkillExpertise", selectSkillExpertise);
        map.put("workExperiences", workExperiences);
        map.put("educationalExperiences", educationalExperiences);
        map.put("projects", projects);
        map.put("text", "freemaker展示fffff页面");

        // 找到模板文件*.ftl
        Configuration freemarker_cfg = new Configuration();
        String ftlppath = "d:\\freemarker\\";
        try {
            freemarker_cfg.setDirectoryForTemplateLoading(new File(ftlppath));
            Template template = freemarker_cfg.getTemplate("product.ftl");

            // 合并模板文件以及数据将其进行输出
            Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("d:\\freemarker\\myFreemarker.html"), "utf-8"));

            //进行处理
            template.process(map, out);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }*/
    @RequestMapping("test2")
    @ResponseBody
    public String aa2(){
        Integer userid = 1;
        // 这个变量用来返回数据
        String strResult = "";
        try {
            //查询简历中的用户信息
            List<ResumeUser> resumeUsers =  resumeService.selectResumeUser(userid);
            resumeUsers.get(0).setName("您好啊");
            //查询简历中的技能专长
            List<SkillExpertise> selectSkillExpertise =  resumeService.selectSkillExpertise(userid);
            //查询简历中的工作经历
            List<WorkExperience> workExperiences =  resumeService.selectWorkExperience(userid);
            //查询简历中的教育经历
            List<EducationalExperience> educationalExperiences =  resumeService.selectEducationalExperience(userid);
            //查询简历中的项目信息
            List<Project> projects =  resumeService.selectProject(userid);

            System.out.println("12");

            // 制造数据
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("resumeUsers", resumeUsers);
            map.put("selectSkillExpertise", selectSkillExpertise);
            map.put("workExperiences", workExperiences);
            map.put("educationalExperiences", educationalExperiences);
            map.put("projects", projects);
            map.put("text", "freemaker展示fffff页面");

            // 找到模板文件*.ftl
            Configuration freemarker_cfg = new Configuration();
            String ftlppath = "E:\\test\\freemarker\\";

            freemarker_cfg.setDirectoryForTemplateLoading(new File(ftlppath));
            Template template = freemarker_cfg.getTemplate("222.ftl");


            // 合并模板文件以及数据将其进行输出
            Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("E:\\test\\freemarker\\222.doc"), "utf-8"));

            //进行处理
            template.process(map, out);
            strResult = "生成Word简历成功了，去E:\\test\\freemarker\\myFreemarker5.doc查看";
        } catch (Exception e) {
            strResult = "生成Word简历失败了";
            e.printStackTrace();
        }

        return strResult;
    }


}
