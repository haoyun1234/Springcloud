package com.jk.controller;

import com.itextpdf.text.pdf.BaseFont;
import com.jk.model.*;
import com.jk.service.TestService;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.xhtmlrenderer.pdf.ITextFontResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;


import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.jk.test.GenerateQRCode.generateQRCode;
import static com.jk.test.GenerateQRCode.parseQRCode;

@Controller
public class TestController {
    @Autowired
    private TestService testService;

    //测试项目
    @RequestMapping("toIndex")
    public String  toIndex() {
        int count = testService.getCount();
        System.out.println(count);
        return "test";
    }

    @RequestMapping("queryInfo")
    @ResponseBody
    public HashMap<String,Object> queryInfo() throws Exception {
        HashMap<String,Object> params=new HashMap<String,Object>();
        params.put("title","测试freemarker");
        List<FreeUser> userList=testService.queryUser();
        Integer userid=1;
        List<FreeSkill> skillList=testService.querySkill(userid);
        List<FreeExperience> experienceList=testService.queryExperience(userid);
        List<FreeEducation> educationList=testService.queryEducation(userid);
        List<FreeProject> projectList = testService.queryProject(userid);

        params.put("userlist",userList);
        params.put("skilllist",skillList);
        params.put("experienceList",experienceList);
        params.put("educationList",educationList);
        params.put("projectList",projectList);
        Configuration config = new Configuration();
        String ftlPath="E:\\freemarkertest\\";
        config.setDirectoryForTemplateLoading(new File(ftlPath));
        Template template = config.getTemplate("test.ftl");

        // 合并模板文件以及数据将其进行输出
        Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("E:\\freemarkertest\\test.html"), "utf-8"));
        template.process(params, out);
        return params;
    }

       /**
     * 转pdf页面
     * @return
     */
    @RequestMapping(value = "freeMarkerPdf.do")
    @ResponseBody
    public Boolean freeMarkerPdf() throws Exception, TemplateException {

         /* 创建数据模型 */
        HashMap<String,Object> params=new HashMap<String,Object>();
        params.put("title","测试freemarker");
        List<FreeUser> userList=testService.queryUser();
        Integer userid=1;
        List<FreeSkill> skillList=testService.querySkill(userid);
        List<FreeExperience> experienceList=testService.queryExperience(userid);
        List<FreeEducation> educationList=testService.queryEducation(userid);
        List<FreeProject> projectList = testService.queryProject(userid);

        params.put("userlist",userList);
        params.put("skilllist",skillList);
        params.put("experienceList",experienceList);
        params.put("educationList",educationList);
        params.put("projectList",projectList);
        /* 创建配置 */
       /* Configuration cfg = new Configuration();
        *//* 指定模板存放的路径 *//*
        cfg.setDirectoryForTemplateLoading(new File("E:\\pdf\\"));
        cfg.setDefaultEncoding("UTF-8");
        *//* 从上面指定的模板目录中加载对应的模板文件 *//*
        Template temp = cfg.getTemplate("resumepdf.ftl");*/

        Configuration config = new Configuration();
        String ftlPath="E:\\pdf\\";
        config.setDirectoryForTemplateLoading(new File(ftlPath));
        Template template = config.getTemplate("resumepdf.ftl");
        /* 将生成的内容写入hello .html中 */

        String file1 = "E:\\pdf\\myFreemarkerPdf.html";
        File file = new File(file1);
        if (!file.exists())
            file.createNewFile();
        Writer out = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(file), "UTF-8"));
        template.process(params, out);
        out.flush();

        String url = new File(file1).toURI().toURL().toString();
        String outputFile = "E:\\pdf\\myFreemarkerPDF.pdf";
        OutputStream os = new FileOutputStream(outputFile);

        ITextRenderer renderer = new ITextRenderer();

        renderer.setDocument(url);

        // 解决中文问题
        ITextFontResolver fontResolver = renderer.getFontResolver();
        try {
           /* simsun.ttc*/
            fontResolver.addFont("E:\\pdf\\wordFont\\simsun.ttc", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
           /* fontResolver.addFont("D:\\freemarker\\wordFont\\simsun.ttc", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            fontResolver.addFont("D:\\freemarker\\wordFont\\simsun.ttc", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);*/
        } catch (Exception e) {
            e.printStackTrace();
        }
           /* fontResolver.addFont("C:/Windows/Fonts/ARIALUNI.TTF", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);*/

        renderer.layout();
        try {
            renderer.createPDF(os);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("pdf转换成功！");
        os.close();
        return true;
    }



    @RequestMapping("queryProject")
    @ResponseBody
    public List<FreeProject> queryProject(){
        Integer userid=1;
        return testService.queryProject(userid);
    }


    @RequestMapping("erweima")
    public Map erweima(){
        Map<Object, Object> map = new HashMap<>();
        //String text = generateNumCode(12);  //随机生成的12位验证码
        String text = "https://www.baidu.com";  //随机生成的12位验证码
        //System.out.println("随机生成的12位验证码为： " + text);
        System.out.println("内容为： " + text);
        int width = 200;    //二维码图片的宽
        int height = 200;   //二维码图片的高
        String format = "png";  //二维码图片的格式

        try {
            //生成二维码图片，并返回图片路径
            String pathName = generateQRCode(text, width, height, format);
            System.out.println("生成二维码的图片路径： " + pathName);

            String content = parseQRCode(pathName);
            System.out.println("解析出二维码的图片的内容为： " + content);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  map;
    }

}
