package com.app.member.controller;

import java.io.IOException;

import com.app.Action;
import com.app.Result;
import com.app.domain.member.vo.MemberVO;
import com.app.repository.member.dao.MemberDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginOkController implements Action{
	@Override
	public Result execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MemberVO memberVO = new MemberVO();
		MemberDAO memberDAO = new MemberDAO();
		Result result = new Result();
		
		memberVO.setMemberEmail(req.getParameter("memberEmail"));
		memberVO.setMemberPassword(req.getParameter("memberPassword"));
		
		MemberVO member = memberDAO.selectForLogin(memberVO);
		
		result.setPath("/");
		result.setRedirect(true);
		
		return result;
	}
}













