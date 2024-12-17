package com.classIT.service;

import com.classIT.domain.MemberVO;

public interface MemberService {
    int userCheck(String user_id, String user_pw);
    MemberVO getMember(String user_id);
    boolean confirmID(String id);
    int insertMember(MemberVO mVo);
    int updateMember(MemberVO mVo);
}
