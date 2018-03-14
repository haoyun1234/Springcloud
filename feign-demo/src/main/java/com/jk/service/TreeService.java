package com.jk.service;

import com.jk.model.Tree;
import com.jk.model.User;

import java.util.List;

public interface TreeService  {
    List<Tree> queryTree();
    //用户信息查询
    List<User> queryYhHuTotal();
    List<User> queryYhHuPage(Integer page, Integer limit);
    //新增用户信息
    void insertYuHuJspAll(User user);
    //删除用户信息
    void deleteYuHu(String uid);
    //修改
    void updateYuHuJspAll(User user);
    //批量删除用户信息
    void deleteYuHuPsAll(String ids);
}
