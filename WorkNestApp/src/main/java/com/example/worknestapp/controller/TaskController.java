package com.example.worknestapp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.worknestapp.model.Task;
import com.example.worknestapp.service.TaskService;

public class TaskController extends HttpServlet {
    
    private TaskService taskService;
    
    public TaskController() {
        taskService = new TaskService();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action.equals("list")) {
            request.setAttribute("tasks", taskService.getAllTasks());
            request.getRequestDispatcher("task_list.jsp").forward(request, response);
        } else if (action.equals("create")) {
            request.getRequestDispatcher("create_task.jsp").forward(request, response);
        } else if (action.equals("details")) {
            Long taskId = Long.parseLong(request.getParameter("taskId"));
            Task task = taskService.getTaskById(taskId);
            request.setAttribute("task", task);
            request.getRequestDispatcher("task_details.jsp").forward(request, response);
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action.equals("create")) {
            String title = request.getParameter("title");
            String description = request.getParameter("description");
            Task task = new Task();
            task.setTitle(title);
            task.setDescription(description);
            taskService.saveTask(task);
            response.sendRedirect("task_list.jsp");
        }
    }
}
