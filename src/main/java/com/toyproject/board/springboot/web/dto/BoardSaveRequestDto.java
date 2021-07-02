package com.myelinsoft.board.springboot.web.dto;

import com.myelinsoft.board.springboot.domain.borad.Board;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BoardSaveRequestDto {
    private String bdSubject;
    private String bdContents;
    private String createdId;

    @Builder
    public BoardSaveRequestDto(String bdSubject, String bdContents,  String createdId) {
        this.bdSubject = bdSubject;
        this.bdContents = bdContents;
        this.createdId = createdId; }

    public Board toEntity(){
        return Board.builder()
                .bdSubject(bdSubject)
                .bdContents(bdContents)
                .createdId(createdId)
                .build(); }
    }




