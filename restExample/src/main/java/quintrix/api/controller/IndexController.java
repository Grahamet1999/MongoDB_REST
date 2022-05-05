package quintrix.api.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = "")
public class IndexController extends HttpServlet {

  private static final long serialVersionUID = -1949518130313607963L;

  private String index;

  public void init() throws ServletException {
    index = "/employees\n/users";
  }

  public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    response.setContentType("text/html");

    PrintWriter out = response.getWriter();
    out.println("<h1>" + index + "</h1>");

  }

  public void destroy() {}
}
