<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Guestbook list</title>
</head>
<body>

    <h1>Guestbook</h1>
    The total count of guestbook: ${count}<br/>
    <br/>
    <br/>

    <c:forEach items="${list}" var="guestbook">
        ${guestbook.id}<br/>
        ${guestbook.name}<br/>
        ${guestbook.content}<br/>
        ${guestbook.regdate}<br/>
    </c:forEach>
    <br/>
    <c:forEach items="${pageStartList}" var="pageIndex" varStatus="status">
        <a href="list?start=${pageIndex}">${status.index + 1}</a>&nbsp; &nbsp;
    </c:forEach>

    <br>
    <br>
    <form method="post" action="write">
        name : <input type="text" name="name"><br>
        <textarea name="content" cols="60" rows="6"></textarea>
        <br> <input type="submit" value="등록">
    </form>

</body>
</html>
