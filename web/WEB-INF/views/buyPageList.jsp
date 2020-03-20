<%--
  Created by IntelliJ IDEA.
  User: life95
  Date: 2020/3/18
  Time: 10:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>购买页面</title>
</head>
<script type="text/javascript" src="/static/jquery-2.1.3.min.js"></script>
<body>
购买页面${id}
<br><br><br><br><br><br><br><br><br><br>
<table border="1" width="60%" align="center">
<tr>
    <td  id="id">321312</td>
    <td  id="productName">313122</td>
    <td  id="poductPrice">321321</td>
    <td  id="productNum">321321</td>
    <td  id="type">312312</td>
    <td  id="state">312312</td>
</tr>
    <td colspan="6">
        购买数量:<input id="BuyNum" name="BuyNum" value="1">
        <button onclick="listData()">点击购买</button>
    </td>
</table>
</body>
<script type="text/javascript">
    function listData() {
        var BuyNum=$("#BuyNum").val();
        var productId=$("#id").html();
        var params = {
            productId:productId,
            BuyNum:BuyNum
        };
        var url = '/order/listData';
        jQuery.ajax({
            type: 'POST',
            contentType: 'application/x-www-form-urlencoded',
            url: url,
            data: params,
            dataType: 'json',
            success: function (data) {
                alert("成功啦");
                //购买完成后跳转到产品列表
                window.location.href="/tick/list";
            },
            error: function (data) {
                alert("失败啦");
            }
        });
    }


    function BuyPageData() {
        var params = {
            id:${id}
        };
        var url = '/order/BuyPageData';
        jQuery.ajax({
            type: 'POST',
            contentType: 'application/x-www-form-urlencoded',
            url: url,
            data: params,
            dataType: 'json',
            success: function (data) {
                alert("成功啦");

                var data=data.data;
                var id=data.id;
                var productName=data.productName;
                var poductPrice=data.poductPrice;
                var productNum=data.productNum;
                var type=data.type;
                var state=data.state;

                $("#id").html(id);
                $("#productName").html(productName);
                $("#poductPrice").html(poductPrice);
                $("#productNum").html(productNum);
                $("#type").html(type);
                $("#state").html(state);

            },
            error: function (data) {
                alert("失败啦");
            }
        });
    }
    BuyPageData();
</script>
</html>
