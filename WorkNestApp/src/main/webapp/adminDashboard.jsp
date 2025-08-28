<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <title>Admin Dashboard</title>
    <style>
        body { 
            font-family: Arial, sans-serif; 
            background: linear-gradient(to right, #a445b2, #d41872, #ff0066); 
            min-height: 100vh; 
            padding: 20px; 
        }
        .container { 
            max-width: 1200px; 
            margin: 0 auto; 
            background: #fff; 
            padding: 30px; 
            border-radius: 10px; 
            box-shadow: 0px 4px 10px rgba(0,0,0,0.2); 
        }
        h1 { 
            text-align: center; 
            margin-bottom: 30px; 
            color: #333; 
        }
        .dashboard-grid {
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(300px, 1fr));
            gap: 20px;
            margin-bottom: 30px;
        }
        .dashboard-card {
            background: #f8f9fa;
            padding: 20px;
            border-radius: 8px;
            border-left: 4px solid #ff0066;
        }
        .dashboard-card h3 {
            margin-top: 0;
            color: #ff0066;
        }
        .stats {
            font-size: 24px;
            font-weight: bold;
            color: #333;
        }
        .nav-menu {
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(200px, 1fr));
            gap: 15px;
            margin-top: 30px;
        }
        .nav-btn {
            display: block;
            padding: 15px;
            background: #ff0066;
            color: white;
            text-align: center;
            text-decoration: none;
            border-radius: 6px;
            font-weight: bold;
            transition: background 0.3s;
        }
        .nav-btn:hover {
            background: #d41872;
            transform: translateY(-2px);
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Admin Dashboard</h1>
        
        <!-- Statistics Cards -->
        <div class="dashboard-grid">
            <div class="dashboard-card">
                <h3>Pending Tasks</h3>
                <div class="stats">${pendingTasks != null ? pendingTasks.size() : 0}</div>
            </div>
            <div class="dashboard-card">
                <h3>In Progress</h3>
                <div class="stats">${inProgressTasks != null ? inProgressTasks.size() : 0}</div>
            </div>
            <div class="dashboard-card">
                <h3>Completed</h3>
                <div class="stats">${completedTasks != null ? completedTasks.size() : 0}</div>
            </div>
            <div class="dashboard-card">
                <h3>Delayed</h3>
                <div class="stats">${delayedTasks != null ? delayedTasks.size() : 0}</div>
            </div>
        </div>

        <!-- Navigation Menu -->
        <div class="nav-menu">
            <a href="${pageContext.request.contextPath}/admin/tasks" class="nav-btn">Manage Tasks</a>
            <a href="${pageContext.request.contextPath}/admin/comments" class="nav-btn">View All Comments</a>
            <a href="${pageContext.request.contextPath}/logout" class="nav-btn">Logout</a>
        </div>

        <!-- Task Status Sections -->
        <c:if test="${not empty pendingTasks}">
            <h2>Pending Tasks</h2>
            <table style="width: 100%; border-collapse: collapse; margin-bottom: 20px;">
                <tr style="background: #ff0066; color: white;">
                    <th style="padding: 12px; text-align: left;">Title</th>
                    <th style="padding: 12px; text-align: left;">Description</th>
                    <th style="padding: 12px; text-align: left;">Assigned To</th>
                    <th style="padding: 12px; text-align: left;">Due Date</th>
                </tr>
                <c:forEach var="task" items="${pendingTasks}">
                    <tr style="border-bottom: 1px solid #ddd;">
                        <td style="padding: 12px;">${task.title}</td>
                        <td style="padding: 12px;">${task.description}</td>
                        <td style="padding: 12px;">${task.assignedTo.name}</td>
                        <td style="padding: 12px;">${task.dueDate}</td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>

        <c:if test="${not empty inProgressTasks}">
            <h2>Tasks In Progress</h2>
            <table style="width: 100%; border-collapse: collapse; margin-bottom: 20px;">
                <tr style="background: #ff0066; color: white;">
                    <th style="padding: 12px; text-align: left;">Title</th>
                    <th style="padding: 12px; text-align: left;">Assigned To</th>
                    <th style="padding: 12px; text-align: left;">Due Date</th>
                </tr>
                <c:forEach var="task" items="${inProgressTasks}">
                    <tr style="border-bottom: 1px solid #ddd;">
                        <td style="padding: 12px;">${task.title}</td>
                        <td style="padding: 12px;">${task.assignedTo.name}</td>
                        <td style="padding: 12px;">${task.dueDate}</td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
    </div>
</body>
</html>
<jsp:include page="header.jsp"/>

<link rel="stylesheet" href="<c:url value='/assets/css/style.css'/>">

<h2>Admin Dashboard</h2>

<h3>Users</h3>
<table border="1" cellpadding="5" cellspacing="0">
  <thead>
    <tr>
      <th>ID</th>
      <th>Name</th>
      <th>Email</th>
      <th>Role</th>
      <th>Actions</th>
    </tr>
  </thead>
  <tbody>
    <c:forEach var="u" items="${users}">
      <tr>
        <td>${u.id}</td>
        <td>${u.name}</td>
        <td>${u.email}</td>
        <td>${u.role}</td>
        <td>
          
          <!-- Delete User -->
          <form method="post" action="<c:url value='/admin/users/delete'/>" style="display:inline;">
            <input type="hidden" name="userId" value="${u.id}"/>
            <button type="submit" onclick="return confirm('Delete this user?')">Delete</button>
          </form>
        </td>
      </tr>
    </c:forEach>
  </tbody>
</table>




<h3>Allocate Task</h3>
<form method="post" action="<c:url value='/admin/tasks/allocate'/>">
  <label>Title</label>
  <input name="title" required/>
  <label>Description</label>
  <textarea name="description"></textarea>
  <div class="row">
    <div>
      <label>Start Date</label>
      <input type="date" name="startDate"/>
    </div>
    <div>
      <label>Due Date</label>
      <input type="date" name="dueDate"/>
    </div>
  </div>
  <label>Assign To (User ID)</label>
  <input type="number" name="userId" required/>
  <button class="btn" type="submit">Allocate</button>
</form>


<h3>All Tasks</h3>
<table>
  <thead>
    <tr><th>ID</th><th>Title</th><th>Assignee</th><th>Status</th><th>Due</th><th>Comments</th></tr>
  </thead>
  <tbody>
    <c:forEach var="t" items="${tasks}">
      <tr>
        <td>${t.id}</td>
        <td>${t.title}</td>
        <td><c:out value='${t.user != null ? t.user.name : "Unassigned"}'/></td>
        <td>${t.status}</td>
        <td>${t.dueDate}</td>
        <td>
        <a href="<c:url value='/admin/tasks/edit?taskId=${t.id}'/>">Edit</a>
         <!-- Delete Task -->
      <form method="post" action="<c:url value='/admin/tasks/delete'/>" style="display:inline;">
        <input type="hidden" name="taskId" value="${t.id}"/>
        <button type="submit" onclick="return confirm('Delete this task?')">Delete</button>
      </form>
          <c:forEach var="c" items="${taskComments[t.id]}">
            <div>
              <strong>${c.user.name}:</strong> ${c.content}
              <br/><small>${c.createdAt}</small>
            </div>
          </c:forEach>
        </td>
      </tr>
    </c:forEach>
  </tbody>
</table>





 <div>




</div>
<jsp:include page="footer.jsp"/>