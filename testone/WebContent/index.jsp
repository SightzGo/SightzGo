    <%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>  
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
    <%  
        String path = request.getContextPath();  
        String basePath = request.getScheme() + "://"  
                + request.getServerName() + ":" + request.getServerPort()  
                + path + "/";  
    %>  
      
    <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">  
    <html>  
    <head>  
    <base href="<%=basePath%>">  
      
    <title>My JSP 'index.jsp' starting page</title>  
    <meta http-equiv="pragma" content="no-cache">  
    <meta http-equiv="cache-control" content="no-cache">  
    <meta http-equiv="expires" content="0">  
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">  
    <meta http-equiv="description" content="This is my page">  
    <!-- 
        <link rel="stylesheet" type="text/css" href="styles.css"> 
        -->  
    <style type="text/css">  
    table {  
        width: 600px;  
        height: 300px;  
    }  
    td{ text-align:center;}  
    </style>  
    </head>  
      
    <body>  
        <h1>主页</h1>  
        <table border="1px">  
            <tr>  
                <th>id</th>  
                <th>姓名</th>  
                <th>年龄</th>  
                <th>操作</th>  
            </tr>  
            <c:forEach items="${ulist }" var="data">  
                <tr>  
                    <td>${data.id }</td>  
                    <td>${data.name }</td>  
                    <td>${data.age }</td>  
                    <td><a href="ServletUsers?do=editbefore&id=${data.id }">修改</a> <a  
                        href="ServletUsers?do=del&id=${data.id }" onclick="javascript:return confirm('确认删除吗？');">删除</a></td>  
                </tr>  
            </c:forEach>  
        </table>  
          
    <a href="add.jsp">新增</a>  
    </body>  
    </html>  