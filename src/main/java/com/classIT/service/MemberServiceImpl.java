package com.classIT.service;

import com.classIT.domain.MemberVO;
import com.classIT.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberMapper memberMapper;

    @Override
    public int userCheck(String user_id, String user_pw) {
        Map<String, String> params = new HashMap<>();
        params.put("user_id", user_id);
        params.put("user_pw", user_pw);
        return memberMapper.userCheck(params);
    }

    @Override
    public MemberVO getMember(String user_id) {
        System.out.println("getMember ȣ��: user_id = " + user_id); // ����� �α� �߰�
        return memberMapper.getMember(user_id);
    }
    
    @Override
    public boolean confirmID(String id) {
        int count = memberMapper.confirmID(id);
        return count == 0; // 0�̸� ��� ����
    }

    @Override
    public int insertMember(MemberVO mVo) {
        return memberMapper.insertMember(mVo);
    }

    @Override
    public int updateMember(MemberVO mVo) {
        return memberMapper.updateMember(mVo);
    }
}
