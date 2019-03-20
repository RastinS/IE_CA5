package Extras;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebFilter("/*")
public class Filter implements javax.servlet.Filter {
    HashMap<String, String> services = new HashMap<>();
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //chain.doFilter(req, resp);

        HttpServletRequest httpReq = (HttpServletRequest)req;
        HttpServletResponse httpResp = (HttpServletResponse)resp;
        MyServletRequestWrapper reqWrapper = new MyServletRequestWrapper((HttpServletRequest)req);
        HttpSession session = httpReq.getSession();

        if(httpReq.getMethod().equals("OPTIONS")) {
            String serviceMethod = getServiceMethod(httpReq.getRequestURI());

            if(serviceMethod.equals("POST")) {
                reqWrapper.addHeader("Access-Control-Allow-Methods", "POST");
            }
            else if(serviceMethod.equals("GET")) {
                reqWrapper.addHeader("Access-Control-Allow-Methods", "GET");
            }
            else if(serviceMethod.equals("NOT FOUND")) {
                reqWrapper.addHeader("Access-Control-Allow-Methods", "POST, GET");
            }
        }

        reqWrapper.addHeader("Access-Control-Allow-Origin:", "*");
        reqWrapper.addHeader("Access-Control-Allow-Credentials", "true");

        System.out.println("here");
        chain.doFilter(httpReq, httpResp);

    }

    public void init(FilterConfig config) throws ServletException {
        services.put("/removeSkill", "POST");
        services.put("/users", "GET");
        services.put("/projects", "GET");
        services.put("/endorse", "POST");
        services.put("/addSkill", "POST");
        services.put("/addBid", "POST");
    }

    private String getServiceMethod(String reqURI) {
        String serv = reqURI.substring(0, reqURI.indexOf('/', 2));
        if(services.containsKey(serv))
            return services.get(serv);
        else
            return "NOT FOUND";
    }

}
