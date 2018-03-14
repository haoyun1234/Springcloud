package com.jk.model.test;

 import com.jk.service.test.ResumeService;
 import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class Test {

    @Autowired
    public ResumeService resumeService;

  /*  public static void main(String[] args) {
        //查询出简历的用户信息
        List<ResumeUser> resumeUsers = aa();


    }*/

    /**
     *
     * @return 查询出简历的用户信息
     */
    public List<ResumeUser> aa2(){
    Integer userid = 1;
    List<ResumeUser> resumeUsers =  resumeService.selectResumeUser(userid);
        return resumeUsers;
    }
}
