package com.bb.voyage.dao;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.bb.voyage.dto.PkgDto;
import com.bb.voyage.dto.ReservDto;

@Mapper
public interface ReservDao {
    public int insertReserv(ReservDto reservDto);
    public int insertPkg(PkgDto pkgDto);
    public List<PkgDto> getFilteredPkg(PkgDto pkgDto);
}
