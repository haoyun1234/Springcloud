package com.jk.service;



import com.alibaba.fastjson.JSONObject;
import com.jk.model.LogBean;

public class LogThread implements Runnable {
    private LogService logService;
    private LogBean logBean;
    @Override
    public void run() {
        String log = JSONObject.toJSONString(logBean);
        logService.saveLog(log);
    }

    public LogService getLogService() {
        return logService;
    }

    public void setLogService(LogService logService) {
        this.logService = logService;
    }

    public LogBean getLogBean() {
        return logBean;
    }

    public void setLogBean(LogBean logBean) {
        this.logBean = logBean;
    }

    public LogThread(LogService logService, LogBean logBean) {
        this.logService = logService;
        this.logBean = logBean;
    }

    public LogThread() {
    }
}
