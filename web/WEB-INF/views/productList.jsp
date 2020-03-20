<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>我是产品界面</title>
</head>
<script type="text/javascript" src="/static/jquery-2.1.3.min.js"></script>
<style type="text/css">
    *{
        margin: 0px;
        padding: 0px;
    }
    #table1{
        margin-left: 250px;
    }
    #table1 tr td{
        font-family: 微软雅黑;
        font-size: 18px;
        text-align: center;
    }
</style>
<body>
<br><br>
<button onclick="personalCenter()">个人中心</button><br><br>
<button  onclick="login()">登录</button>
<button  onclick="register()">注册</button>
<button onclick="loginOut()">注销</button>
<br>
<div align="center">
    <input id="currentPage" name="currentPage" type="hidden" VALUE="1">
    <input id="pageSize" name="pageSize" type="hidden" value="3">
    <br>
    类型:<input id="type" name="type" value="">
    产品名称:<input id="productName" name="productName" value="">
    <br>
    最小价格:<input id="minSalePrice" name="minSalePrice" value="">
    最大价格:<input id="maxSalePrice" name="maxSalePrice" value="">
    <br>
    <button onclick="listData()">查询数据</button>
</div>
<table id="table1" border="1" width="70%" >

    <tr>
        <td>编号</td>
        <td>产品名称</td>
        <td>产品价格</td>
        <td>产品数量</td>
        <td>类型</td>
        <td>状态</td>
        <td>操作</td>
    </tr>

    <tr>
        <td>001</td>
        <td>xxx</td>
        <td>xxx</td>
        <td>xxx</td>
        <td>xxx</td>
        <td>xxx</td>
        <td>购买</td>
    </tr>

</table>
</body>
<script type="text/javascript">

    function personalCenter() {
        location.href="/order/personalCenter";
    }

    function login() {
        location.href="/login/page";
    }

    function register() {
        location.href="/login/register";
    }

    function loginOut() {
        location.href="/login/loginOut";
    }

    function BuyPage(id) {
        location.href="/order/BuyPage?id="+id;
    }

    function goPage(currentPage) {
        $("#currentPage").val(currentPage);
        listData();
    }

    function listData() {
        var currentPage=$("#currentPage").val();
        var pageSize=$("#pageSize").val();
        var type=$("#type").val();
        var productName=$("#productName").val();
        var minSalePrice=$("#minSalePrice").val();
        var maxSalePrice=$("#maxSalePrice").val();


        var params = {
            currentPage:currentPage,
            pageSize:pageSize,
            type:type,
            productName:productName,
            minSalePrice:minSalePrice,
            maxSalePrice:maxSalePrice
        };
        var url = '/tick/listData';
        jQuery.ajax({
            type: 'POST',
            contentType: 'application/x-www-form-urlencoded',
            url: url,
            data: params,
            dataType: 'json',
            success: function (data) {
                alert("成功啦");
                var code=data.code;
                if (code=="0000"){
                    var data=data.data;
                    var list=data.list;
                    var currentPage=data.currentPage;
                    var pageSize= data.pageSize;
                    var totalNum=data.totalNum;
                    var totalPage=data.totalPage;

                    var html= '<tr>'+
                        '<td>编号</td>'+
                        '<td>产品名称</td>'+
                        '<td>产品价格</td>'+
                        '<td>产品数量</td>'+
                        '<td>类型</td>'+
                        '<td>状态</td>'+
                        '<td>操作</td>'+
                        '</tr>';

                    for (var i=0;i<list.length;i++){
                        var productList=list[i];
                        var id=productList.id;
                        var productName=productList.productName;
                        var productPrice=productList.productPrice;
                        var productNum=productList.productNum;
                        var type=productList.type;
                        var state=productList.state;

                        html=html+
                            '<tr>'+
                            '<td>'+id+'</td>'+
                            '<td>'+productName+'</td>'+
                            '<td>'+productPrice+'</td>'+
                            '<td>'+productNum+'</td>'+
                            '<td>'+type+'</td>'+
                            '<td>'+state+'</td>'+
                            '<td><button onclick="BuyPage('+id+')">购买</button></td>'+
                            '</tr>';
                    }
                    html=html+'<td colspan="7">'+
                        '<a href="#" onclick="goPage(1)">首页</a>'+
                        '<a href="#" onclick="goPage('+currentPage+'-1)">上页</a>'+
                        '<a href="#"  onclick="goPage('+currentPage+'+1)">下页</a>'+
                        '<a href="#" onclick="goPage('+totalPage+')">末页</a>'+
                        '每页显示'+pageSize+'条,共'+currentPage+'/'+totalPage+'页'+
                        '共'+totalNum+'条数据'+
                        '</td>';
                    $("#table1").html(html);
                }
            },
            error: function (data) {
                alert("失败啦");
            }
        });
    }
    listData();
</script>
</html>
