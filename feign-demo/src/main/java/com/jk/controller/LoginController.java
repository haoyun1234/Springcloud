package com.jk.controller;


import com.alibaba.fastjson.JSON;
import com.jk.Common.ResultBean;
import com.jk.model.LogBean;
import com.jk.pool.ThreadPool;
import com.jk.service.LogService;
import com.jk.service.LogThread;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
 import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
@RequestMapping("log")
public class LoginController {
    @Autowired
    private LogService logService;

    @Autowired
    private AmqpTemplate amqpTemplate;

    //RabbitMQ消息队列
    @RequestMapping("sendSms")
    @ResponseBody
    public Boolean sendSms(String phoneNumber){
        //hello = "{'phonenumber':'17710950275','content':'您的短信验证码为666666'}";
        HashMap<Object, Object> params = new HashMap<>();
        params.put("phonenumber",phoneNumber);
        params.put("content",new Random().nextInt(10000));
        amqpTemplate.convertAndSend("sms", JSON.toJSONString(params));
        return true;
    }




    @RequestMapping("login")
    @ResponseBody
    public Boolean login(String loginnumber,String password){
        //假设登录成功
        LogBean logBean = new LogBean();
        logBean.setIp("127.0.0.1");
        logBean.setIpAddress("中国");
        logBean.setLog("登录日志"+ UUID.randomUUID().toString());
        logBean.setLogTime(new Date());
        logBean.setName("login");
        logBean.setRequestMsg("loginnumber="+loginnumber+"password="+password);
        logBean.setResponseMsg("{'loginnumber':'admin','password':'admin'}");
        ThreadPool.executor(new LogThread(logService,logBean));
        return true;
    }


    //跳页面
    @RequestMapping("queryStaffJsp")
    public String queryStaffJsp(){
        return "show2";
    }

    /*@RequestMapping("queryStaff")
    @ResponseBody
    public  HashMap   queryStaff(Integer page, Integer rows){
        HashMap<String,Object> map = new HashMap<>();
        logService.queryYhHuPage(page, rows);
        return  map;
    }*/
    @RequestMapping(value = "queryStaff")
    @ResponseBody
    public HashMap<String, Object> queryStaff(Integer page, Integer pageSize){
        page =1;
        pageSize = 10;
        Integer rows = pageSize;
        ResultBean resultBean = logService.selectLog(page, rows);
        HashMap<String, Object> stringObjectHashMap = new HashMap<String, Object>();
        stringObjectHashMap.put("code",resultBean.getCode());
        stringObjectHashMap.put("msg",resultBean.getMsg());
        Map<String, Object> qwe = (Map<String, Object>) resultBean.getData();
        stringObjectHashMap.put("count",qwe.get("total"));
        stringObjectHashMap.put("data",qwe.get("rows"));
        return stringObjectHashMap;
    }
}
