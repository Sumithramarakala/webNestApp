jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Dashboard</title>
</head>
<body>
    <h2>Admin Dashboard</h2>
    <h3>Users:</h3>
    <table border="1">
        <tr>
            <th>User ID</th>
            <th>Username</th>
            <th>Action</th>
        </tr>
        <c:forEach items="${users}" var="user">
            <tr>
                <td>${user.id}</td>
                <td>${user.username}</td>
                <td><a href="userDetails?id=${user.id}">View Details</a></td>
            </tr>
        </c:forEach>
    </table>
    <h3>Tasks:</h3>
    <table border="1">
        <tr>
            <th>Task ID</th>
            <th>Task Name</th>
            <th>Status</th>
            <th>Action</th>
        </tr>
        <c:forEach items="${tasks}" var="task">
            <tr>
                <td>${task.id}</td>
                <td>${task.title}</td>
                <td>${task.status}</td>
                <td><a href="taskDetails?id=${task.id}">View Details</a></td>
            </tr>
        </c:forEach>
    </table>
