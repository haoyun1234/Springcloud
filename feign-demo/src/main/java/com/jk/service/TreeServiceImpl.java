package com.jk.service;

import com.jk.mapper.TreeMapper;
import com.jk.model.Tree;
import com.jk.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TreeServiceImpl implements TreeService {
    @Autowired
    private TreeMapper treeMapper;
    public List<Tree> queryTree() {
        return treeMapper.queryTree();
    }
    //用户信息查询
    public List<User> queryYhHuTotal() {
        return treeMapper.queryYhHuTotal();
    }

    public List<User> queryYhHuPage(Integer page, Integer limit) {
        page = (page - 1) * limit;
        return treeMapper.queryYhHuPage(page,limit);
    }
    //新增用户信息
    public void insertYuHuJspAll(User user) {
        //user.setHeadimg("123");
        treeMapper.insertYuHuJspAll(user);
    }
    //删除用户信息
    public void deleteYuHu(String uid) {

        treeMapper.deleteYuHu(uid);
    }

    //修改
    public void updateYuHuJspAll(User user) {
        treeMapper.updateYuHuJspAll(user);
    }

    //批量删除用户信息
    public void deleteYuHuPsAll(String ids) {
        treeMapper.deleteYuHuPsAll(ids);
    }
}
