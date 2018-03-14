package com.jk.service;

import com.jk.Common.ResultBean;
import com.jk.model.LogBean;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@FeignClient(value = "provider-log")
public interface LogService {
    @RequestMapping("/log/saveLog")
    void saveLog(@RequestParam(value = "log") String  log);

    @RequestMapping("/log/getLogList")
    ResultBean selectLog(@RequestParam(value = "page")Integer page, @RequestParam(value = "rows")Integer rows);





}
