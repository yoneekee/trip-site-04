package com.bb.voyage.service;

import com.bb.voyage.dto.MemberDto;

public interface MemberService {
  public int insertMember(MemberDto memberDto);
  public MemberDto loginMember(MemberDto memberDto);
  public int modifyMember (MemberDto memberDto);
  public MemberDto getMemberInfo(int no);
  public int deleteMember (MemberDto memberDto);
}
