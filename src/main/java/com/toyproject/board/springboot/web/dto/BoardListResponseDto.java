package com.toyproject.board.springboot.web.dto;

import com.toyproject.board.springboot.domain.borad.Board;

import java.time.LocalDateTime;

import lombok.Getter;

@Getter
public class BoardListResponseDto {
    private Long bdId;
    private String bdSubject;
    private String createdId;
    private int bdViewCnt;
    private LocalDateTime createDate;
    private LocalDateTime modifiedDate;
    private String delYn;
    private String useYn;

    public BoardListResponseDto(Board entity) {
        this.bdId = entity.getBdId();
        this.bdSubject = entity.getBdSubject();
        this.createdId = entity.getCreatedId();
        this.bdViewCnt = entity.getBdViewCnt();
        this.createDate = entity.getCreateDate();
        this.modifiedDate = entity.getModifiedDate();
        this.delYn = entity.getDelYn();
        this.useYn = entity.getUseYn();  }

}