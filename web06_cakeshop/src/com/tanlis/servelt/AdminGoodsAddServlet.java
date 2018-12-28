package com.tanlis.servelt;

import java.awt.event.ItemEvent;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.tanlis.model.Goods;
import com.tanlis.service.GoodsService;

/**
 * Servlet implementation class AdminGoodsAddServlet
 */
@WebServlet("/admin/goods_add")
public class AdminGoodsAddServlet extends HttpServlet {
	
	private GoodsService gService=new GoodsService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DiskFileItemFactory factory=new DiskFileItemFactory();
		ServletFileUpload upload=new ServletFileUpload(factory);//文件解析器
		
		try {
			List<FileItem> list=upload.parseRequest(request);
			Goods g=new Goods();
			for (FileItem fileItem : list) {
				if(fileItem.isFormField()) {
					switch (fileItem.getFieldName()) {
					case "name":
						g.setName(fileItem.getString("utf-8"));
						break;
					case "price":
						g.setPrice(Integer.parseInt(fileItem.getString("utf-8")));
						break;
					case "intro":
						g.setIntro(fileItem.getString("utf-8"));
						break;
					case "stock":
						g.setStock(Integer.parseInt(fileItem.getString("utf-8")));						
						break;
					case "typeid":
						g.setTypeid(Integer.parseInt(fileItem.getString("utf-8")));
						break;
					default:
						break;
					}
				}else {
					//文件上传
						//判断是否存在，如果没有上传 跳过
					if(fileItem.getInputStream().available()<=0) continue;
						//取得后缀
					String fileName=fileItem.getName();
					fileName=fileName.substring(fileName.lastIndexOf("."));//获得后缀
					fileName="/"+new Date().getTime()+fileName; //要存入数据库的 路径
					String path=this.getServletContext().getRealPath("/picture")+fileName;//保存路径  真实路径+/+时间+/后缀.xx
					//输入输出流
					InputStream in=fileItem.getInputStream();
					FileOutputStream out=new FileOutputStream(path);
					byte[] buffer=new byte[1024];//设定一个缓存  1024只是每次读的大小。如果超过1024 就多读几次
					int len=0;
					while ((len=in.read(buffer))>0) {//返回缓存长度  -1为读取完毕
						out.write(buffer);
						
					}
					in.close();
					out.close();
					fileItem.delete();
					switch (fileItem.getFieldName()) {
					case "cover":
						g.setCover("/picture"+fileName);
						break;
					case "image1":
						g.setImage1("/picture"+fileName);						
						break;
					case "image2":
						g.setImage2("/picture"+fileName);						
						break;
					default:
						break;
					}
				}
			}
			gService.insert(g);
			request.getRequestDispatcher("/admin/goods_list").forward(request, response);
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
