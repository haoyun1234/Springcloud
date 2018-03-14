<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>${title}</title>
</head>
<body>

<div>
    <div style="margin-left: 150px;width: 90%">
        <table border="1" width="900px">

            <tr style="background-color: lightgray">
                <th colspan="4" align="center" >
                    <h2>简历</h2>
                </th>
            </tr>
        <#list userlist as user>
            <tr>
                <td align="center">姓名:</td>
                <td align="center">${user.username}</td>
                <td align="center">性别:</td>
                <td align="center">${user.usersex}</td>
            </tr>

            <tr>
                <td align="center">出生年月:</td>
                <td align="center">${user.createtime}</td>
                <td align="center">籍    贯:</td>
                <td align="center">${user.jiguan}</td>
            </tr>

            <tr>
                <td align="center">年    龄:</td>
                <td align="center">${user.userage}</td>
                <td align="center">工作年限:</td>
                <td align="center">${user.worktime}</td>
            </tr>

            <tr>
                <td align="center">学   历:</td>
                <td align="center">${user.usereducation}</td>
                <td align="center">专    业:</td>
                <td align="center">${user.userprofessional}</td>
            </tr>

            <tr>
                <td align="center">移动电话:</td>
                <td align="center">${user.userphone}</td>
                <td align="center">电子邮箱:</td>
                <td align="center">${user.useremail}</td>
            </tr>
        </#list>
        </table>
    </div>

    <div style="margin-left: 150px;width: 90%">
        <table border="1" width="900px" >

            <tr style="background-color: lightgray">
                <th colspan="4" align="left">
                    求职意向
                </th>
            </tr>

        <#list userlist as user>
            <tr>
                <td align="center">工作性质:</td>
                <td align="center">${user.workdefined}</td>
                <td align="center">目标职位:</td>
                <td align="center">${user.workposition}</td>
            </tr>


            <tr>
                <td align="center">期望薪资:</td>
                <td align="center">${user.worksalary}</td>
                <td align="center">工作地:</td>
                <td align="center">${user.workaddress}</td>
            </tr>
        </#list>
        </table>
    </div>
    <div style="margin-left: 150px;width: 90%">
        <table border="1" width="900px" >

            <tr style="background-color: lightgray">
                <th colspan="4" align="left">
                    技能专长
                </th>
            </tr>
        <#list skilllist as skill>
            <tr>
                <td colspan="4">
                    <p>${skill.skillinfo}</p>
                </td>
            </tr>
        </#list>
        </table>
    </div>

    <div style="margin-left: 150px;width: 90%">
        <table border="1" width="900px" >
            <tr style="background-color: lightgray">
                <th colspan="4" align="left">
                    工作经历
                </th>
            </tr>
        <#list experienceList as experience>

            <tr>
                <td align="center">${experience.worktime}</td>
                <td align="center">${experience.companyname}</td>
                <td align="center">${experience.workskill}</td>
            </tr>
        </#list>
        </table>
    </div>

    <div style="margin-left: 150px;width: 90%">
        <table border="1" width="900px" >
            <tr style="background-color: lightgray">
                <th colspan="4" align="left">
                    教育经历
                </th>
            </tr>
        <#list educationList as education>


            <tr>
                <td align="center">${education.educationtime}</td>
                <td align="center">${education.companyname}</td>
                <td align="center">${education.educationposition}</td>
            </tr>
        </#list>
        </table>
    </div>
    <div style="margin-left: 150px;width: 90%">
        <table border="1" width="900px" >
        <#assign x=0 />
        <#list projectList as project>
            <#assign x= x+1 />
            <tr style="background-color: lightgray">
                <th align="left">
                    项目${x}
                </th>
                <th align="center" colspan="3">
                ${project.title}
                </th>
            </tr>
            <tr>
                <td align="center">开发环境:</td>
                <td align="center" colspan="3">${project.huanjing}</td>
            </tr>
            <tr>
                <td align="center">项目框架：</td>
                <td align="center" colspan="3">${project.kuangjia}</td>
            </tr>
            <tr>
                <td align="center">项目描述:</td>
                <td align="center" colspan="3">${project.miaoshu}</td>
            </tr>
            <tr>
                <td align="center">功能模块:</td>
                <td align="center" colspan="3">${project.mukuai}</td>
            </tr>
            <tr>
                <td align="center">责任描述:</td>
                <td align="center" colspan="3">${project.zmiaoshu}</td>
            </tr>
        </#list>
        </table>
    </div>
    <div style="margin-left: 150px;width: 90%">
        <table border="1" width="900px" height="130px">

            <tr style="background-color: lightgray">
                <th colspan="4" align="left">
                    自我评价
                </th>
            </tr>

        <#list userlist as user>
            <tr>
                <td align="center" colspan="4">${user.userintroduce}</td>
            </tr>

        </#list>
        </table>
    </div>


</div>

</body>
</html>