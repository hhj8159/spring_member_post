package com.hjham.member_post. servlet.post;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.hjham.member_post.dto.Criteria;
import com.hjham.member_post.service.PostService;
import com.hjham.member_post.service.PostServiceImpl;
import com.hjham.member_post.utils.Commons;

@WebServlet("/post/view")
public class View extends HttpServlet{
	// private PostService service = new PostServiceImpl();
	// @Override
	// protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// 	Criteria cri = new Criteria(req);
		
	// 	String pnoString = req.getParameter("pno");
//		if(pnoString == null) {
//			Commons.printMsg("비정상적인 접근입니다", "list", resp);
//			return;
//		}		
		// Long pno = pnoString == null ? 1L : Long.valueOf(pnoString);
		
		// req.setAttribute("post", service.view(pno));
		// req.setAttribute("cri", cri);
		// req.getRequestDispatcher("/WEB-INF/jsp/post/view.jsp").forward(req, resp);
		
	// }
	
}