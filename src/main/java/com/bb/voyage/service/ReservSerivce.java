package com.bb.voyage.service;

import java.util.List;

import com.bb.voyage.dto.PkgDto;
import com.bb.voyage.dto.ReservDto;

public interface ReservSerivce {
    public int insertReserv(ReservDto reservDto);    
    public int insertPkg(PkgDto pkgDto);
    public List<PkgDto> getFilteredPkg(PkgDto pkgDto);


}
