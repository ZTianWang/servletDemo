package com.wnwn.servlet.formProcessing;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

//import javax.servlet.ServletContext;
import javax.servlet.ServletException;
//import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = -4162520164406924822L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
//		String name = req.getParameter("name");
//		String age = req.getParameter("age");
//		String file = req.getParameter("file");
//		resp.setContentType("text/html;charset=UTF-8");
//		resp.getWriter().write("name:"+name+"<br/>age:"+age+"<br/>file:"+file);
		
		process(req,resp);
	}

	/*获取文件输入流的方式处理上传文件;不常用！*/
//	private void process(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//		resp.setContentType("text/html;charset=UTF-8");
//		ServletInputStream sis = req.getInputStream();
//		byte[] buf = new byte[1024];
//		int  flag = 0;
//		while ((flag = sis.readLine(buf, 0, 1024)) != -1) {
//			String line = new String(buf, 0, flag);
//			resp.getWriter().write(line+"<br/>");
//		}
//		sis.close();
//	}
	
	/* 利用part接口处理文件
	 * 在页面中显示文件名和文件内容*/
//	private void process(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
//		resp.setContentType("text/html;charset=UTF-8");
//		String name = req.getParameter("name");
//		String age = req.getParameter("age");
//		resp.getWriter().write("name:"+name+"<br/>age:"+age+"<br/>");
//		Part part = req.getPart("file");
//		/*得到表单中元素的名称*/
////		String formElementName = part.getName();
////		resp.getWriter().write("formElementName:"+formElementName+"<br/>");
//		/*得到文件的名称*/
//		String fileName = getFileName(part);
//		resp.getWriter().write("file name:"+fileName+"<br/>");
//		InputStream is = part.getInputStream();
//		byte[] buf = new byte[1024];
//		int  flag = 0;
//		while ((flag = is.read(buf, 0, 1024)) != -1) {
//			String line = new String(buf, 0, flag);
//			resp.getWriter().write(line+"<br/>");
//		}
//		is.close();
//	}

	/*利用part接口处理上传文件*/
	private void process(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		resp.setContentType("text/html;charset=UTF-8");
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		resp.getWriter().write("name:"+name+"<br/>age:"+age+"<br/>");
		Part part = req.getPart("file");
		
		saveUpload(part);
		resp.getWriter().write("<h3>文件上传成功</h3><br/>");
	}
	
	/*获取文件*/
	private void saveUpload(Part part) {
		String fileName = getFileName(part);
		/*避免文件名重复*/
		fileName = "wnwn_"+System.nanoTime()+"_"+fileName;
		/*通过ServletContext获取当前应用程序路径*/
//		ServletContext sct = getServletContext();
		/*使真实路径相对于当前应用程序*/
//		String realPath = sct.getRealPath("/");
//		System.out.println(realPath);
		/* *
		 * 真实路径为
		 * /Users/apple/Documents/workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp2/wtpwebapps/JWebDemo/ 
		 * */
//		File file = new File(realPath+"upload");
		File file = new File("/Users/apple/Desktop/ftp");
		/*若文件路径不存在则创建目录*/
		if (!file.exists()) {
			file.mkdirs();
		}
		File upFile = new File(file,fileName);
		FileOutputStream fos = null;
		InputStream is = null;
		byte[] buf = new byte[1024];
		int flag = -1;
		try {
			fos = new FileOutputStream(upFile);
			is = part.getInputStream();
			while ((flag = is.read(buf, 0, 1024)) != -1) {
				fos.write(buf, 0, flag);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/*定义得到文件名的方法*/
	private String getFileName(Part part) {
		String header = part.getHeader("content-disposition");
		String[] arr = header.split("filename=");
		return arr[arr.length-1].replace("\"", "");
	}
	
}
