package com.myelinsoft.board.springboot.domain.borad;

import com.myelinsoft.board.springboot.domain.BaseTimeEntity;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;


@NoArgsConstructor
@ToString
@Getter
@Setter
@Entity
@Table(name = "board")
public class Board extends BaseTimeEntity implements Serializable {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bdId;

    @Column(nullable = false, columnDefinition = "varchar(100) COMMENT '게시물 제목'")
    private String bdSubject;

    @Column(nullable = false, columnDefinition = "TEXT COMMENT '내용'")
    private String bdContents;

    @Column(nullable = false, columnDefinition = "int COMMENT '조회수'")
    private int bdViewCnt;

    @Column(nullable = false, columnDefinition = "varchar(10) COMMENT '생성자 ID'")
    private String createdId;

    @Column(columnDefinition = "varchar(1) COMMENT '삭제유무' default 'N'", insertable = false)
    private String delYn;

    @Column(columnDefinition = "varchar(1) COMMENT '사용유무' default 'Y'", insertable = false)
    private String useYn;

    @Column(columnDefinition = "varchar(10) COMMENT '수정자 ID'")
    private String updatedId;

    @Builder
    public Board(String bdSubject, String bdContents, int bdViewCnt, String createdId,
                 String updatedId, String delYn, String useYn ) {
        this.bdSubject = bdSubject;
        this.bdContents = bdContents;
        this.bdViewCnt = bdViewCnt;
        this.createdId = createdId;
        this.updatedId = updatedId;
        this.delYn = delYn;
        this.useYn = useYn; }

    public void update(String bdSubject, String bdContents){
        this.bdSubject = bdSubject;
        this.bdContents = bdContents; }
}
