package com.jk.mapper;

import com.jk.model.Tree;
import com.jk.model.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface TreeMapper {
    //树
    @Select("select * from t_tree")
    List<Tree> queryTree();
    //用户信息查询
    @Select("select * from user")
    List<User> queryYhHuTotal();
    @Select("select * FROM  user LIMIT #{page},#{limit}")
    List<User> queryYhHuPage(@Param("page") Integer page, @Param("limit") Integer limit);
    //新增用户信息
    @Insert("insert into user (uname,upassword,sex,receiveName,createTime,usertype,userinfo,userhobby,headimg)\n" +
            "\t\tvalues\n" +
            "\t\t(#{uname},#{upassword},#{sex},#{receiveName},#{createTime},#{usertype},#{userinfo},#{userhobby},#{headimg})")
    void insertYuHuJspAll(User user);

    //删除用户信息
    @Delete("delete from user where uid=#{uid}")
    void deleteYuHu(String uid);

    //修改
    @Update("update user set\n" +
            "\t\tuname=#{uname},\n" +
            "\t\tupassword=#{upassword},\n" +
            "\t\tsex=#{sex},\n" +
            "\t\treceiveName=#{receiveName},\n" +
            "\t\tcreateTime=#{createTime},\n" +
            "\t\tusertype=#{usertype},\n" +
            "\t\tuserinfo=#{userinfo},\n" +
            "\t\tuserhobby=#{userhobby},\n" +
            "\t\theadimg=#{headimg}\n" +
            "\t\twhere uid=#{uid}")
    void updateYuHuJspAll(User user);

    //批量删除
    @Delete("Delete from user where uid in (${ids})")
    void deleteYuHuPsAll(@Param("ids") String ids);
}
