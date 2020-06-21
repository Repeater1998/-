package Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jspsmart.upload.File;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

/**
 * Servlet implementation class UploadServlet
 */
@WebServlet("/UploadServlet")
public class UploadServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		SmartUpload smartupload=new SmartUpload();
		ServletConfig config=this.getServletConfig();
		smartupload.initialize(config, request, response);
		try {
			smartupload.upload();
			File smartFile=smartupload.getFiles().getFile(0);
			smartFile.saveAs("/FILES/"+smartFile.getFileName(), SmartUpload.SAVE_VIRTUAL);
			String src="/FILES/"+smartFile.getFileName();
			String name=smartFile.getFileName();
			HttpSession session=request.getSession();
			session.setAttribute("name", name);
			session.setAttribute("src", src);
		} catch (SmartUploadException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		String msg="Upload Success!";
		request.setAttribute("msg", msg);
		RequestDispatcher rd=request.getRequestDispatcher("/jsp/register.jsp");
		rd.forward(request, response);
	}

}
