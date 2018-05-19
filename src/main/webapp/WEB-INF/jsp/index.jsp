<%--
  Created by IntelliJ IDEA.
  User: LJ0000275
  Date: 2018/5/9
  Time: 14:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
   <h4>欢迎来来到主页面</h4>
    上传单个文件:<br/>
   <form action="/common/upload.do" method="post" enctype="multipart/form-data">
       <input type="file"  name="fileData"/>
       <input type="submit" value="上传">
   </form>

    上传多个文件:<br/>
    <form action="/common/uploads.do" method="post" enctype="multipart/form-data">
      文件1:  <input type="file"  name="fileData"/><br>
      文件2:  <input type="file"  name="fileData"/><br>
      文件3:  <input type="file"  name="fileData"/><br>
        <input type="submit" value="上传">
    </form>
</center>
</body>

</html>
