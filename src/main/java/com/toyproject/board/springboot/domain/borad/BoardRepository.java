package com.myelinsoft.board.springboot.domain.borad;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long>{
    @Query("select b from Board b where b.delYn = 'N' order by b.bdId desc")
    List<Board> findAllDesc();

    @Modifying
    @Query("update Board b set b.bdViewCnt = b.bdViewCnt + 1 where b.bdId = :bdId")
        //query:  update board      set bd_view_cnt = bd_view_cnt + 1 where bd_id  = 1;
    int bdViewCnt(Long bdId);

    @Modifying //delete상태값 수정 쿼리
    @Query("update Board b set b.delYn = 'Y', b.useYn = 'N' where b.bdId = :bdId")
        //query:  update board      SET   del_yn = "Y", use_yn = "N" where bd_id = 1;
    int deleteStatus(Long bdId);
}