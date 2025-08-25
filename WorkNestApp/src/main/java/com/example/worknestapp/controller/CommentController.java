package com.example.worknestapp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.worknestapp.model.Comment;
import com.example.worknestapp.model.Task;
import com.example.worknestapp.model.User;
import com.example.worknestapp.service.CommentService;
import com.example.worknestapp.service.TaskService;

public class CommentController extends HttpServlet {
    
    private CommentService commentService;
    private TaskService taskService;
    
    public CommentController() {
        commentService = new CommentService();
        taskService = new TaskService();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action.equals("create")) {
            Long taskId = Long.parseLong(request.getParameter("taskId"));
            Task task = taskService.getTaskById(taskId);
            request.setAttribute("task", task);
            request.getRequestDispatcher("create_comment.jsp").forward(request, response);
        } else if (action.equals("list")) {
            Long taskId = Long.parseLong(request.getParameter("taskId"));
            request.setAttribute("comments", commentService.getCommentsByTaskId(taskId));
            request.getRequestDispatcher("comment_list.jsp").forward(request, response);
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action.equals("create")) {
            Long taskId = Long.parseLong(request.getParameter("taskId"));
            Task task = taskService.getTaskById(taskId);
            User user = (User) request.getSession().getAttribute("user");
            String commentText = request.getParameter("comment");
            Comment comment = new Comment();
            comment.setTask(task);
            comment.setUser(user);
            comment.setComment(commentText);
            commentService.saveComment(comment);
            response.sendRedirect("task_details.jsp?taskId=" + taskId);
        }
    }
}
