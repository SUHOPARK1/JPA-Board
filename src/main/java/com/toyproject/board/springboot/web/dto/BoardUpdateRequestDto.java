package com.myelinsoft.board.springboot.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BoardUpdateRequestDto {
    private String bdSubject;
    private String bdContents;
    private String delYn;
    private String useYn;

    @Builder
    public BoardUpdateRequestDto(String bdSubject, String bdContents, String delYn, String useYn) {
        this.bdSubject = bdSubject;
        this.bdContents = bdContents;
        this.delYn = delYn;
        this.useYn = useYn; }
}