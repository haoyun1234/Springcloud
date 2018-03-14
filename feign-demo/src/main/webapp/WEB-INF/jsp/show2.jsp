<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>图片展示</title>
    <script type="application/javascript" src="/jquery-1.9.1.min.js"></script>
    <link rel="stylesheet" href="/js/layui/css/layui.css"/>
    <script src="/js/layui/layui.js"></script>
</head>
<body>
<%--查询--%>
<div id="pTable" style="width: 99.9%;height:99.9%">
    <table class="layui-table" id="layui_table_id" lay-filter="test" style="width: 99.9%;height:99.9%">
    </table>
    <div id="laypage"></div>
</div>

<script>

    //列表查询方法
    layui.use('table', function(){
        var table = layui.table;
        table.render({
            elem: '#layui_table_id'
            ,height: 315
            ,url: '../log/queryStaff.do' //数据接口
            ,page: true //开启分页
            //每页条数
            ,limit:3
            ,limits:[3,5,10]
            ,cols: [[ //表头
                {field:'id',title:'复选框',type:'checkbox'}
                ,{field: 'log', title: '登录日志', width:80}
                ,{field: 'logTime', title: '密码', width:80}
                ,{field: 'ip', title: 'ip', width: 177}
                ,{field: 'logTime', title: '时间', width: 177}
                ,{field: 'requestMsg', title: '请求', width: 177}
                ,{field: 'responseMsg', title: '请求', width: 177}
                ,{field: 'ipAddress', title: 'ip', width: 177}


            ]]
        });
    });

</script>
</body>
</html>
