package servlet;

import Model.Task;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class ResultServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Task task = (Task) session.getAttribute("task");
        if(task != null) {
            String modified = doTask(task);
            System.out.println(modified);
            task.setResult(modified);
        }
        req.setAttribute("task", task);
        //PrintWriter writer = resp.getWriter();
        //writer.print("<h1>" + modified + "<h1>");

        RequestDispatcher dispatcher =  req.getRequestDispatcher("result.jsp");
        dispatcher.forward(req, resp);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    public String doTask(Task task){
        String s = task.getInputString();
        int num = task.getNum();
        String news =  s.substring(0, s.length()-num);
        return news;
    }
}
