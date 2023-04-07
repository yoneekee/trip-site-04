package com.bb.voyage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bb.voyage.dao.ReservDao;
import com.bb.voyage.dto.PkgDto;
import com.bb.voyage.dto.ReservDto;

@Service
public class ReservServiceImpl implements ReservSerivce{

    @Autowired
    ReservDao reservDao;

    public int insertReserv(ReservDto reservDto) {
        return reservDao.insertReserv(reservDto);
    }
    public int insertPkg(PkgDto pkgDto) {
        return reservDao.insertPkg(pkgDto);
    }
    public List<PkgDto> getFilteredPkg(PkgDto pkgDto) {
        return reservDao.getFilteredPkg(pkgDto);
    }


}
