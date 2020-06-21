package Filter;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class Authentication
 */
@WebFilter("/Authentication")
public class Authentication implements Filter {
	private String sessionKey;
    private String redirectUrl;
    private String uncheckedUrls;
    /**
     * Default constructor. 
     */
    public Authentication() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		 // ��������������Ҫ�õ�request,response,session����
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        //1.��ȡ����URL
        String servletPath = httpRequest.getServletPath();    

        //2.���1�л�ȡ��servletPath�Ƿ�Ϊ����Ҫ����URl�е�һ��.����,����
        List<String> urls = Arrays.asList(uncheckedUrls.split(","));
        for(int i=0;i<urls.size();i++) {
        	if(servletPath.contains(urls.get(i))) {
        		chain.doFilter(httpRequest, httpResponse);
                return;
        	}
        }

        //3.��session�л�ȡSessionKey��Ӧֵ,��ֵ������,���ض���redirectUrl
        Object user = httpRequest.getSession().getAttribute("account");
        if ((user == null)) {
           httpResponse.sendRedirect(httpRequest.getContextPath() +"/jsp"+redirectUrl);            
           return;
        }

        //4.������,�����
        chain.doFilter(httpRequest, httpResponse);
}
	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		ServletContext servletContext = fConfig.getServletContext();
        //��ȡXML�ļ������ò���
        sessionKey = servletContext.getInitParameter("userSessionKey");
        redirectUrl = servletContext.getInitParameter("redirectPage");
        uncheckedUrls = servletContext.getInitParameter("uncheckedUrls");
	}

}
