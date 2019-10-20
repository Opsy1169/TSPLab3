package servlet;

import Model.InvalidTask;
import Model.Task;
import com.sun.deploy.trace.LoggerTraceListener;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HomeServlet extends HttpServlet {

    public static Logger logger = Logger.getLogger(servlet.HomeServlet.class.getName());
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       logger.info("doGet");
        System.out.println("doGet");
        RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
        req.setAttribute("s", "from doGet");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("doPost");
//        Logger logger = Logger.getLogger(HomeServlet.class.getName());
//        logger.info("doPost");
//        System.out.println("doPost");
       String s = req.getParameter("string");
       s = new String(s.getBytes("ISO-8859-1"),"UTF8");
        int num  = -1;
        try {
            num = Integer.parseInt(req.getParameter("num"));
        }catch (NumberFormatException ex){
           log("numberformat err");
            req.setAttribute("error", "Wrong Number format");
            InvalidTask task = new InvalidTask(s, req.getParameter("num"));
            req.setAttribute("invalidtask", task);
            doGet(req, resp);
        }
        if( (num < 0 )) {
           log("business err");
            req.setAttribute("error", "Number is negative");
            InvalidTask task = new InvalidTask(s, req.getParameter("num"));
            req.setAttribute("invalidtask", task);
            doGet(req, resp);
        }
        if(num > s.length()){
            req.setAttribute("error", "Number is larger than strings length");
            InvalidTask task = new InvalidTask(s, req.getParameter("num"));
            req.setAttribute("invalidtask", task);
            doGet(req, resp);
        }
        Task task = new Task(s, num);
        HttpSession session = req.getSession();
        session.setAttribute("task", task);
        resp.sendRedirect("/web_war_exploded/result");



        //super.doPost(req, resp);
    }
}
