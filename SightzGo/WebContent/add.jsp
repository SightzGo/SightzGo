    <%@ page language="java" 
    import="java.util.*" pageEncoding="UTF-8"%>  
    <script type="text/javascript" src="js/jquery-1.5.1.min.js"></script>  
    


    <html>  
    <head>
    <script type="text/javascript">  
     function test(){  
         var loginname=document.getElementById("loginname").value;           
         var password=document.getElementById("password").value;
         var type=document.getElementById("type").value;  
        $.ajax({        
                type:"post", 
                url:"http://localhost:8080/SightzGo/AddUser",               
                cache: false,     
                data:{loginname:loginname,password:password,type:type},//传参  
                dataType: "json",   //返回值类型  
                success:function(data){ 
            	   
                // var data=eval("("+data+")");  为什么不用这句，出来已经是object对象？？
                	if(data.success=="1")
                   	 alert("注册成功");
                	if(data.success=="2")
                      	 alert("未输入用户名");
                	if(data.success=="3")
                		alert("未输入年龄");
                	if(data.success=="4")
                		alert("未输入用户类型");
                   },  
                error:function(){  
                    alert("error");  
                }   
                } ); 
   
      }  
</script>  
      </head>  
        
      <body>  
        <h1>新增页面</h1>  
        <form>  
        姓名：<input id="loginname"><br>  
        年龄：<input id="password" ><br> 
        类型：<input id="type" ><br>
          <input type="button" value="新增" onclick=test()>
        </form>  
      </body>  
    </html>  
    