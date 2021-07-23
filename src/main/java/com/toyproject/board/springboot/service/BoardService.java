package com.toyproject.board.springboot.service;

import com.toyproject.board.springboot.domain.borad.Board;
import com.toyproject.board.springboot.domain.borad.BoardRepository;
import com.toyproject.board.springboot.web.dto.BoardListResponseDto;
import com.toyproject.board.springboot.web.dto.BoardResponseDto;
import com.toyproject.board.springboot.web.dto.BoardSaveRequestDto;
import com.toyproject.board.springboot.web.dto.BoardUpdateRequestDto;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardRepository boardRepository;

    @Transactional //게시글 저장
    public Long save(BoardSaveRequestDto requestDto){
        return boardRepository.save(requestDto.toEntity()).getBdId(); }

    @Transactional(readOnly = true) //게시글 불러오기
    public List<BoardListResponseDto> findAllDesc(){
        return boardRepository.findAllDesc().stream()
                .map(BoardListResponseDto::new)
                .collect(Collectors.toList()); }

    @Transactional //게시글 상세보기
    public BoardResponseDto findById (Long bdId){
        Board entity = boardRepository.findById(bdId).orElseThrow(
                () -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + bdId));
        return new BoardResponseDto(entity); }

    @Transactional //게시글 수정
    public Long update (Long bdId, BoardUpdateRequestDto requestDto){
        Board board = boardRepository.findById(bdId).orElseThrow(
                ()-> new IllegalArgumentException("해당 게시글이 없습니다. id=" + bdId));
        board.update(requestDto.getBdSubject(), requestDto.getBdContents());
        return bdId; }

    @Transactional //조회수 카운터
    public int viewCount(Long bdId) {
        return boardRepository.bdViewCnt(bdId);
    }

    @Transactional //게시물 삭제여부(ver. del_yn, use_yn 값 바꾸기(Query)
    public int deleteStatus(Long bdId, BoardUpdateRequestDto requestDto) { return boardRepository.deleteStatus(bdId); }

    @Transactional //게시물 삭제(ver. DeleteMapping)
    public void delete (Long bdid) {
        Board board = boardRepository.findById(bdid)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + bdid));
        boardRepository.delete(board); }

}