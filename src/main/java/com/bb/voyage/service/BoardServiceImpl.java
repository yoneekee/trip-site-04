package com.bb.voyage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bb.voyage.dao.BoardDao;
import com.bb.voyage.dto.FreeBoardDto;
import com.bb.voyage.dto.MemberDto;
import com.bb.voyage.dto.VipBoardDto;

@Service
public class BoardServiceImpl implements BoardService {
    @Autowired
    BoardDao boardDao;

  // =================FreeBoard Related
    public int insertFreeBoard(FreeBoardDto freeBoardDto) {
        return boardDao.insertFreeBoard(freeBoardDto);
    }
    public List<FreeBoardDto> getAllFree() {
        return boardDao.getAllFree();
    }
    public FreeBoardDto getOneFree(int no) {
        return boardDao.getOneFree(no);
    }
    public MemberDto getMemberInfo(int no) {
        return boardDao.getMemberInfo(no);
    }
    public int modifyFreeBoard(FreeBoardDto freeBoardDto) {
        return boardDao.modifyFreeBoard(freeBoardDto);
    }
    public int deleteFreeBoard(int freeNo) {
        return boardDao.deleteFreeBoard(freeNo);
    }

  // =================VipBoard Related
    
  public int insertVipBoard(VipBoardDto VipBoardDto) {
    return boardDao.insertVipBoard(VipBoardDto);
}
public List<VipBoardDto> getAllVip() {
    return boardDao.getAllVip();
}
public VipBoardDto getOneVip(int no) {
    return boardDao.getOneVip(no);
}
public int modifyVipBoard(VipBoardDto VipBoardDto) {
    return boardDao.modifyVipBoard(VipBoardDto);
}
public int deleteVipBoard(int VipNo) {
    return boardDao.deleteVipBoard(VipNo);
}
@Override
public MemberDto getMemberInfo02(int no) {
    return boardDao.getMemberInfo02(no);
}
}
