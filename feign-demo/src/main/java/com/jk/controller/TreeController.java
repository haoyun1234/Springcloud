package com.jk.controller;

import com.jk.ConstantsBean;
import com.jk.model.Tree;
import com.jk.model.User;
import com.jk.service.TreeService;
import com.jk.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class TreeController {
    @Autowired
    private TreeService treeService;

    //树
    @RequestMapping("queryTree")
    @ResponseBody
    public List<Map<String,Object>> queryTree(){
        List<Tree> lis = treeService.queryTree();
        return treeStr(lis,0);
    }

    public List<Map<String,Object>> treeStr(List<Tree> list, Integer pid){
        List<Map<String,Object>> newlist = new ArrayList<Map<String,Object>>();
        for (int i = 0; i < list.size(); i++) {
            //获取单个tree对象
            Tree tree = list.get(i);
            Map<String,Object> map = null;
            //判断当前tree对象的pid是否和传过来的pid相等，相等的保存到map中
            if(tree.getPid() == pid){
                map = new HashMap<String, Object>();
                map.put("id", tree.getId());
                map.put("text", tree.getText());
                map.put("state", tree.getState());
                map.put("url", tree.getUrl());
                map.put("iconCls", tree.getIconCls());
                map.put("children", treeStr(list,tree.getId()));
                map.put("name",tree.getName());
            }
            if(map != null){
                List<Map<String,Object>> li = (List<Map<String, Object>>) map.get("children");
                if(li.size()<=0){
                    map.remove("children");
                }
                newlist.add(map);
            }
        }
        return newlist;
    }

    //跳用户信息页面
    @RequestMapping("queryUserJsp")
    public String queryUserJsp(){
        return "showUser";
    }
    //用户信息查询
    @RequestMapping("queryYhHu")
    @ResponseBody
    public Map<String,Object> queryStaff(Integer page,Integer limit){
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("code",0);
        map.put("msg","");
        map.put("count",treeService.queryYhHuTotal().size());
        map.put("data",treeService.queryYhHuPage(page,limit));
        return map;
    }

    //新增用户信息
    @RequestMapping("insertYuHuJspAll")
    @ResponseBody
    public Map<String,Object>  insertYuHuJspAll(User user){
        Map<String,Object> map = new HashMap<String, Object>();
        try {
            //判断id是否为空 不为空走修改
            if (user.getUid()!=null&&user.getUid()>0) {
                map.put("success", true);
                treeService.updateYuHuJspAll(user);
            }else{
                map.put("success", true);
                treeService.insertYuHuJspAll(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success", false);
        }
        return map;
    }

    //删除用户信息
    @RequestMapping("deleteYuHu")
    @ResponseBody
    public Map<String,Object>  deleteYuHu(String uid){
        Map<String,Object> map = new HashMap<String, Object>();
        try {
            map.put("success", true);
            treeService.deleteYuHu(uid);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success", false);
        }
        return map;
    }

    //批量删除用户信息
    @RequestMapping("deleteYuHuPsAll")
    @ResponseBody
    public  Map<String,Object> deleteYuHuPsAll(String ids){
        Map<String,Object> map = new HashMap<String, Object>();
        try {
            map.put("success", true);
            treeService.deleteYuHuPsAll(ids);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success", false);
        }
        return map;
    }


    //图片上传
    @RequestMapping(value = "queryuploadPhoto", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> queryuploadPhoto(MultipartFile file){
        Map<String,Object> map = new HashMap<String, Object>();
        try {
            String photoName = FileUtil.upFile(file, ConstantsBean.IMG_PATH);
            String path = ConstantsBean.IMG_SERVER_PATH+photoName;
            map.put("success", true);
            map.put("path", path);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success", false);
        }
        return map;
    }
}
