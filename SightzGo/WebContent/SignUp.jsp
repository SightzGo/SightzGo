    <%@ page language="java" 
    import="java.util.*" pageEncoding="UTF-8"%>  
    <script type="text/javascript" src="js/jquery-1.5.1.min.js"></script>  

<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <script type="text/javascript">  
     function test(){  
         var loginname=document.getElementById("loginname").value;           
         var password=document.getElementById("password").value;
         var type=1;  
    
        $.ajax({       
                type:"post", 
                url:"/SightzGo/AddUser",               
                cache: false,     
                data:{loginname:loginname,password:password,type:type},//传参  
                dataType: "json",   //返回值类型  
                success:function(data){     
                	if(data.success=="1")
                   	 alert("注册成功");
                	if(data.success=="2")
                      	 alert("未输入用户名");
                	if(data.success=="3")
                		alert("未输入密码");
                	if(data.success=="4")
                		alert("未输入用户类型");
                   },  
                error:function(){  
                    alert("error");  
                }   
                } ); 
   
      }  
</script>  
    <meta charset="UTF-8">
    <title>赛事Go-注册</title>
    <link rel="stylesheet" href="css/SignUp.css" type="text/css">
</head>
<body>

<div id="table">
    <div class="tableBack">
        <div class="title">
            <a href="Home.html">
                <div class="logo">
                    <img src="images/Logo_purple.png">
                    <h1>赛事GO</h1>
                </div>
            </a>
    </div>
        <div class="input">
            <p>注册</p><hr/>
            <form action="#" method="post">
                <input placeholder="输入用户名或邮箱" id="loginname">
                <input type="password" placeholder="6~32位密码" maxlength="32" id="password">
                <input type="password" placeholder="确认密码" maxlength="32">
            </form>
            <span><input type="checkbox" class="check">我已阅读并同意<a href="">《赛事GO服务条款》</a></span>

        </div>
        <div class="next"><input type="button" class="submit" value="下一步" onclick=test()><hr/></div>
        <div class="bottomText">
            <p>已经有账户？<a href="SignIn.html">点击登陆</a></p>
        </div>
    </div>

</div>

</body>
</html>