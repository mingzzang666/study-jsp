package com.app.member.controller;

import java.io.IOException;

import com.app.Action;
import com.app.Result;
import com.app.domain.member.vo.MemberVO;
import com.app.repository.member.dao.MemberDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JoinOkController implements Action{
	@Override
	public Result execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MemberDAO memberDAO = new MemberDAO();
		MemberVO memberVO = new MemberVO();
		Result result = new Result();
		
		memberVO.setMemberEmail(req.getParameter("memberEmail"));
		memberVO.setMemberPassword(req.getParameter("memberPassword"));
		memberVO.setMemberName(req.getParameter("memberName"));
		memberVO.setMemberAge(Integer.parseInt(req.getParameter("memberAge")));
		memberVO.setMemberGender(req.getParameter("memberGender"));
		
		memberDAO.insert(memberVO);
		
		result.setPath(req.getContextPath() + "/login.member");
		result.setRedirect(true);
		
		return result;
	}
}

























