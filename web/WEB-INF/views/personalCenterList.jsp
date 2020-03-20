<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<html>
<head>
    <title>个人中心</title>
</head>
<script type="text/javascript" src="/static/jquery-2.1.3.min.js"></script>
<body>
<div>
    <button onclick="goList()">首页</button>
</div>
<div align="center">
    <input id="currentPage" name="currentPage" type="hidden" value="1">
    <input id="pageSize" name="pageSize" type="hidden" value="3">
    <br>
    类型:<input id="type" name="type" value="">
    产品名称:<input id="productName" name="productName" value="">
    <br>
    最小购买量:<input id="minBuyNum" name="minBuyNum" value="">
    最大购买量:<input id="maxBuyNum" name="maxBuyNum" value="">
    <br>
    <button onclick="personalCenterData()">查询数据</button>
</div>
<table id="table1" border="1" width="70%" align="center">

    <tr>
        <td>编号</td>
        <td>产品名称</td>
        <td>产品价格</td>
        <td>购买数量</td>
        <td>状态</td>
        <td>类型</td>
    </tr>
    <tr>
        <td>01</td>
        <td>黄瓜</td>
        <td>6.9元</td>
        <td>1</td>
        <td>已支付</td>
        <td>水果</td>
    </tr>
</body>
<script type="text/javascript">

    function goList() {
        location.href="/tick/list";
    }

    function goPage(currentPage) {
        $("#currentPage").val(currentPage);
        personalCenterData();
    }


    function personalCenterData() {
        var currentPage=$("#currentPage").val();
        var pageSize=$("#pageSize").val();
        var type=$("#type").val();
        var productName=$("#productName").val();
        var minBuyNum=$("#minBuyNum").val();
        var maxBuyNum=$("#maxBuyNum").val();

        var params = {
            currentPage:currentPage,
            pageSize:pageSize,
            type:type,
            productName:productName,
            minSalePrice:minBuyNum,
            maxSalePrice:maxBuyNum
        };
        var url = '/order/personalCenterData';
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
                    var listcenter=data.list;
                    var currentPage=data.currentPage;
                    var pageSize= data.pageSize;
                    var totalNum=data.totalNum;
                    var totalPage=data.totalPage;

                    var html=  '<tr>'+
                               '<td>编号</td>'+
                               '<td>产品名称</td>'+
                               '<td>产品价格</td>'+
                               '<td>购买数量</td>'+
                               '<td>状态</td>'+
                               '<td>类型</td>'+
                               '</tr>';

                    for (var i=0;i<listcenter.length;i++){
                        var PersonalCenterList=listcenter[i];
                        var id=PersonalCenterList.id;
                        var productName=PersonalCenterList.productName;
                        var productPrice=PersonalCenterList.productPrice;
                        var buyNum=PersonalCenterList.buyNum;
                        var type=PersonalCenterList.type;
                        var state=PersonalCenterList.state;
                        html=html+
                            '<tr>'+
                            '<td>'+id+'</td>'+
                            '<td>'+productName+'</td>'+
                            '<td>'+productPrice+'</td>'+
                            '<td>'+buyNum+'</td>'+
                            '<td>'+state+'</td>'+
                            '<td>'+type+'</td>'+
                            '</tr>';
                    }
                    html=html+'<td colspan="6">'+
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
    personalCenterData();
</script>
</html>
