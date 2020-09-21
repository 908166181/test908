package filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class OneFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

                    HttpServletRequest request=(HttpServletRequest)servletRequest;
                    String uri=request.getRequestURI();
                    HttpSession session=null;

                    if(uri.contains("login")||"/myWeb/".equals(uri)){
                        filterChain.doFilter(servletRequest,servletResponse);
                        return;
                    }
                    //HttpServletResponse response=(HttpServletResponse)servletResponse;
                    session =request.getSession(false);

                    if(session!=null){
                        //response.sendRedirect("/myWeb/login.error");
                        filterChain.doFilter(servletRequest,servletResponse);

                        return;
                    }else {

                        request.getRequestDispatcher("/myWeb/login_error.html").forward(servletRequest, servletResponse);
                    }

    }
}
