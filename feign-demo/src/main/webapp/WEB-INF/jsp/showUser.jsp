<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>图片展示</title>
    <script type="application/javascript" src="/jquery-1.9.1.min.js"></script>
    <link rel="stylesheet" href="/js/layui/css/layui.css"/>
    <script src="/js/layui/layui.js"></script>
    <style type="text/css">.layui-table-fixed-r td{height:100px!important;}
    .layui-table-fixed-r th{height:100px!important;}
    .layui-table img {
        max-width: 100px;min-height: 100px;
    }
    </style>
</head>
<body>

<%--查询--%>
<div id="pTable" style="width: 99.9%;height:99.9%">
    <a class="layui-btn layui-btn-mini" onclick="addBook()" lay-event="edit">添加</a>
    <a class="layui-btn layui-btn-danger layui-btn-mini" lay-event="del" onclick="deleteAllBook()">批量删除</a>
    <a class="layui-btn layui-btn-mini"  onclick="erwei()">点击生成二维码</a>

    <table class="layui-table" id="layui_table_id" lay-filter="test" style="width: 99.9%;height:99.9%">
    </table>
    <div id="laypage"></div>
</div>

<%--添加的Div弹框 与from表单--%>
<div id="addDiv" style="display: none">
    <form class="layui-form" id="addBookForm">
        <input type="hidden" name="uid" id="uid">
        <div class="layui-form-item">
            <label class="layui-form-label">用户名</label>
            <div class="layui-input-block">
                <input type="text" name="uname"  id="uname" required  lay-verify="required" placeholder="请输入书籍名称" autocomplete="off" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">密码</label>
            <div class="layui-input-block">
                <input type="password" name="upassword" id="upassword" required  lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">性别</label>
            <div class="layui-input-block">
                <label><input type="radio" name="sex" value="1" title="男"></label>
                <label><input type="radio" name="sex" value="2" title="女" checked></label>
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">邮箱</label>
            <div class="layui-input-block">
                <input type="text" name="receiveName" id="receiveName" required  lay-verify="required" placeholder="请输入邮箱" autocomplete="off" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">时间</label>
            <div class="layui-inline"> <!-- 注意：这一层元素并不是必须的 -->
                <input type="text"  class="layui-input" id="test1" name="createTime">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">类型</label>
            <div class="layui-input-block">
                <select name="usertype" lay-verify="required" id="usertype">
                    <option value=""></option>
                    <option value="普通">普通</option>
                    <option value="VIP">VIP</option>
                    <option value="管理员">管理员</option>
                </select>
            </div>
        </div>

       <div class="layui-form-item layui-form-text">
            <label class="layui-form-label">详情</label>
            <div class="layui-input-block">
                <textarea name="userinfo"  id="demo2"></textarea>
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">爱好</label>
            <div class="layui-input-block">
                <input type="checkbox" name="userhobby" value="学习" title="学习">
                <input type="checkbox" name="userhobby" value="敲代码" title="敲代码">
                <input type="checkbox" name="userhobby" value="思考" title="思考">
                <input type="checkbox" name="userhobby" value="励志" title="励志">
            </div>
        </div>

        <div class="layui-form-item layui-form-text">
            <label class="layui-form-label">图片</label>
            <div style="width: 400px">
                <div id="demo3"></div>
                <div style="padding-left: 105px">
                    <input type="hidden" name="headimg" id="image">
                    <button type="button" class="layui-btn" id="test2">
                        <i class="layui-icon">&#xe67c;</i>上传图片
                    </button>
                </div>
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-input-block">
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </form>
</div>

<%--操作--%>
<script type="text/html" id="madebtn">
    <a class="layui-btn layui-btn-xs" lay-event="edit">修改</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>

<script>

      function erwei() {
          location.href="";
          $.ajax({
              url:"erweima.do",
              type:"post",
              success:function (map) {
                  if(map.success){
                       alert('成功');
                      location.href=location;
                  }else{
                       alert('失败');
                  }

              }
          })
      }

    //列表查询方法
    layui.use('table', function(){
        var table = layui.table;
            table.render({
                elem: '#layui_table_id'
                ,height: 315
                ,url: 'queryYhHu.do' //数据接口
                ,page: true //开启分页
                //每页条数
                ,limit:3
                ,limits:[3,5,10]
                ,cols: [[ //表头
                    {field:'uid',title:'复选框',type:'checkbox'}
                    ,{field: 'uname', title: '用户名', width:80}
                    ,{field: 'upassword', title: '密码', width:80}
                    ,{field: 'sex', title: '性别', width:80, sort: true,
                        templet: function(d){
                            if(d.sex==1){
                                return "男";
                            }
                            return "女";
                        }}
                    ,{field: 'receiveName', title: '邮箱', width: 177}
                    ,{field: 'createTime', title: '时间', width: 177}
                    ,{field: 'userhobby', title: '爱好', width: 177}

                    /* 图片展示第二种方法*/
                    /*,{field: 'headimg', title: '图片', width: 100,
                        templet:function(d){
                            return "<img width='600px' height='400px' src='"+d.headimg+"' alt='图片不存在'>" }}*/

                    ,{field: 'headimg', title: '图片', width: 120,
                        templet:'<div><img src="{{d.headimg}}"></div>',
                        style:'height:100px;width:100px;line-height:100px!important;'}

                    ,{field: 'xx', title: '操作',width:330,templet:'#madebtn'}

                ]]
            });

            //监听工具条
            table.on('tool(test)', function(obj){ //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
                $ = layui.jquery
                var data = obj.data //获得当前行数据
                    ,layEvent = obj.event; //获得 lay-event 对应的值
                if(layEvent === 'detail'){
                    viewLableInfo(data.attrId);
                    layer.msg(data.attrId);
                } else if(layEvent === 'del'){
                    layer.confirm("确认要删除吗，删除后不能恢复", { title: "删除确认" }, function (index) {
                        layer.close(index);
                        $.post("deleteYuHu.do?uid="+data.uid, function (data) {
                            location.reload();
                        });
                    });
                } else if(layEvent === 'edit'){
                    if(data.uid !=null){
                        updateBook();
                        layui.use('form', function(){
                            form = layui.form; //只有执行了这一步，部分表单元素才会自动修饰成功
                            $("#uid").val(data.uid);//Id
                            $("#uname").val(data.uname);//用户名
                            $("#upassword").val(data.upassword);//密码
                            $("input[name='sex'][value=" +data.sex+ "]").attr("checked", true);//性别
                            $("#receiveName").val(data.receiveName);//邮箱
                            $("#test1").val(data.createTime);//时间
                            //爱好
                            var arr = new Array([]);
                            arr  = data.userhobby.split(",");
                            $.each(arr,function(i,item){
                                $("input[name='userhobby'][value="+item+"]").attr("checked","checked");
                            });
                            $("#usertype").val(data.usertype);//类型
                            $("#demo2").val(data.userinfo);//详情
                            //图片
                            $("#image").val(data.headimg);
                            $('#demo3').html('<img src="' + data.headimg + '" width="100" height="100" alt="图片不存在">')

                            form.render();
                        });
                    }
                    }
            });

        });


    //时间
    layui.use('laydate', function(){
        var laydate = layui.laydate;
        //执行一个laydate实例
        laydate.render({
            elem: '#test1',//指定元素
        });
    });

    //上传图片
    layui.use('upload', function(){
        var upload = layui.upload;
        //执行实例
        var uploadInst = upload.render({
            elem: '#test2' //绑定元素
            ,url: 'queryuploadPhoto.do' //上传接口
            ,done: function(res){
                //上传完毕回调
                $ = layui.jquery;
                $("#image").val(res.path);
                $('#demo3').html('<img src="' + res.path + '" width="100" height="100" alt="图片不存在">')
            }
            ,error: function(res){

            }
        });
    });

    //Demo
    layui.use('form', function(){
        var form = layui.form;

        //监听提交
        form.on('submit(formDemo)', function(data){
            layer.msg(JSON.stringify(data.field));
            return false;
        });
    });

    //表单修改
    function updateBook(){
        addtab("修改");
    }

    //表单新增
    function addBook(){
        addtab("新增");
    }

    //表单ajax提交
    function addtab(msg) {
         $ = layui.jquery
         layui.use('layedit', function(){
            layedit = layui.layedit;
            indexs = layedit.build('info'); //建立编辑器
        });
            layer.open({
                type: 1,
                title: msg+"用户信息", //不显示标题栏
                skin: 'layui-layer-demo', //样式类名
                closeBtn: 1, //不显示关闭按钮
                shift: 2,
                area: ['800px', '650px'], //宽高
                shadeClose: true, //开启遮罩关闭
                content:$("#addDiv"),
                scrollbar: false, // 父页面 滚动条 禁止
                btnAlign: 'c',
                btn:['提交'],
                yes: function(index, layero){
                    layedit.sync(indexs);
                    $.ajax({
                        url:"insertYuHuJspAll.do",
                        type:"post",
                        data:$("#addBookForm").serialize(),
                        dataType:"json",
                        async:true,
                        success:function (data) {
                            layer.close(index);
                            location.reload();
                        }
                    })
                },
                end: function () {
                    location.reload();
                },

            });
        }

    //批量删除
    function deleteAllBook(){
        layui.use('table', function(){
            var table = layui.table;
            var ids ="";
            var checkStatus = table.checkStatus('layui_table_id');
            data = checkStatus.data;
            for (var i in data){
                ids+=","+data[i].uid;
            }

            if(ids==""){
                layer.alert('请选择需要删除的数据!', {icon: 2});
            }else{
                ids= ids.substr(1);

                layer.confirm('你确定要删除此条数据吗?', {icon: 3, title:'提示'}, function(index){
                    $.ajax({
                        url:"deleteYuHuPsAll.do",
                        type:"post",
                        data:{'ids':ids},
                        success:function (map) {
                            if(map.success){
                                layer.close(index);
                                layer.alert('删除成功', {icon: 1});
                                location.href=location;
                            }
                        }
                    })

                });
            }
        })
    }
</script>
</body>
</html>
