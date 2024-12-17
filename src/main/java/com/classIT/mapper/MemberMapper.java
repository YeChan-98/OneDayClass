package com.classIT.mapper;

import java.util.Map;

import com.classIT.domain.MemberVO;

public interface MemberMapper {
    int userCheck(Map<String, String> params);
    MemberVO getMember(String user_id);
    int confirmID(String user_id);
    int insertMember(MemberVO mVo);
    int updateMember(MemberVO mVo);
}
