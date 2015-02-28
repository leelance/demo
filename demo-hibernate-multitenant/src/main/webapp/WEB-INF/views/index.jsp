<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>demo</title>

    <!-- Bootstrap -->
    <link href="static/css/bootstrap.css" rel="stylesheet">
    <style>
        select{
            margin: 10px 0;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-2">
            <select class="form-control">
                <option value="qhdevelop18">qhdevelop18</option>
                <option value="qihangedu">qihangedu</option>
                <option value="qhdevelop18">qhdevelop18</option>
                <option value="qhdevelop102">qhdevelop102</option>
                <option value="qhdevelop106">qhdevelop106</option>
            </select>
        </div>
        <div class="col-md-10"></div>
    </div>
</div>
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <table class="table table-bordered table-striped">
                <c:forEach items="${marries}" var="marry">
                    <tr>
                        <td>${marry.id}</td>
                        <td>${marry.instanceSeqId}</td>
                        <td>${marry.companyName}</td>
                        <td>${marry.enumValue}</td>
                        <td>${marry.description}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>

<script src="static/js/jquery-1.7.2.min.js"></script>
<script>
    $(function(){
        $('select').on('change',function(e) {
            window.location.href = "change/"+this.value;
        });
    });
</script>
</body>
</html>