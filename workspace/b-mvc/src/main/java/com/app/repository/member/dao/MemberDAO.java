package com.app.repository.member.dao;

import java.util.Optional;

import org.apache.ibatis.session.SqlSession;

import com.app.domain.member.vo.MemberVO;
import com.app.mybatis.config.MyBatisConfig;

public class MemberDAO {
	public SqlSession sqlSession;
	
	public MemberDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
	
//	회원가입
	public void insert(MemberVO memberVO) {
		sqlSession.insert("member.insert", memberVO);
	}
	
//	로그인
	public MemberVO selectForLogin(MemberVO memberVO) {
		return sqlSession.selectOne("member.selectForLogin", memberVO);
	}
}

















