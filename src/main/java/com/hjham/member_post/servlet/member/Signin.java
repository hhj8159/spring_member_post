package com.hjham.member_post. servlet.member;

import java.io.IOException;
import java.net.URLDecoder;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.hjham.member_post.service.MemberService;
import com.hjham.member_post.service.MemberServiceImpl;
import com.hjham.member_post. vo.Member;

@WebServlet("/signin")
public class Signin extends HttpServlet{
// 	private MemberService service = new MemberServiceImpl();

// 	@Override
// 	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
// 		req.getRequestDispatcher("/WEB-INF/jsp/member/signin.jsp").forward(req, resp);
// 	}

// 	@Override
// 	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
// 		req.setCharacterEncoding("utf-8");
// 		String id = req.getParameter("id");
// 		String pw = req.getParameter("pw");
// 		String remember = req.getParameter("remember-id");
// 		System.out.println(id);
// 		System.out.println(pw);
// 		System.out.println(remember);
		
		
// //		service.register(member);
// 		if(service.login(id, pw)) {
// 			// 로그인 성공
// 			HttpSession session = req.getSession();
// 			session.setAttribute("member", service.findBy(id));
		
// 			// 쿠키 아이디 기억 여부 처리
// 			if(remember != null) {
// 				Cookie cookie = new Cookie("remember-id", id);
// 				cookie.setMaxAge(60 * 60 * 24 * 7); //일주일
// 				resp.addCookie(cookie);
// 			} else {
// 				// 아이디 기억 안할 때 처리할 일
// 				Cookie[] cookies = req.getCookies();
// 				for(Cookie c : cookies) {
// 					if(c.getName().equals("remember-id")) {
// 						c.setMaxAge(0);
// 						resp.addCookie(c);
// 						break;
// 					}
// 				}
// 			}
			
// 			// url파라미터 여부에 따른 리디렉션 페이지 지정
// 			String redirectURL = req.getContextPath()+"/index";
// 			String url = req.getParameter("url");
// 			if(url != null && !url.equals("")) {
// 				redirectURL = URLDecoder.decode(url, "utf-8");
// 			}
// 			resp.sendRedirect(redirectURL);
// 		}
// 		else {
// 			// 로그인 실패
// 			resp.sendRedirect("login?msg=fail");
			
// 		}
		
// 	}	
}
			
		
