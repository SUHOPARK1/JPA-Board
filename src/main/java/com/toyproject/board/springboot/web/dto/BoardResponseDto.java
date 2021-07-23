package com.toyproject.board.springboot.web.dto;


import com.toyproject.board.springboot.domain.borad.Board;
import lombok.Getter;

@Getter
public class BoardResponseDto {
    private Long bdId;
    private String bdSubject;
    private int bdViewCnt;
    private String createdId;
    private String bdContents;

    public BoardResponseDto(Board entity) {
        this.bdId = entity.getBdId();
        this.bdSubject = entity.getBdSubject();
        this.bdViewCnt = entity.getBdViewCnt();
        this.createdId = entity.getCreatedId();
        this.bdContents = entity.getBdContents(); }
}




