package com.myelinsoft.board.springboot.web;

import com.myelinsoft.board.springboot.service.BoardService;
import com.myelinsoft.board.springboot.web.dto.BoardResponseDto;
import com.myelinsoft.board.springboot.web.dto.BoardSaveRequestDto;
import com.myelinsoft.board.springboot.web.dto.BoardUpdateRequestDto;

import lombok.RequiredArgsConstructor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Controller
@RequestMapping("/board")
public class BoardController {
    Logger logger = LoggerFactory.getLogger(getClass());
    private final BoardService boardService;

    @ResponseBody
    @PostMapping("/api/v1/board")
    public Long save(@RequestBody BoardSaveRequestDto requestDto) {
        logger.info("게시글 저장");
        return boardService.save(requestDto); }

    @ResponseBody
    @PutMapping("/api/v1/board/{bdId}")
    public Long update(@PathVariable Long bdId, @RequestBody BoardUpdateRequestDto requestDto) {
        logger.info("게시글 수정");
        return boardService.update(bdId, requestDto); }

    @ResponseBody
    @GetMapping("/api/v1/board/{bdId}")
    public BoardResponseDto findById(@PathVariable Long bdId) {
        logger.info("게시글 상세보기");
        return boardService.findById(bdId); }

    @ResponseBody
    @RequestMapping(value = "/api/v2/board/{bdId}", method= { RequestMethod.PUT })
    public Long deleteState(@PathVariable Long bdId,
                            BoardUpdateRequestDto requestDto, Model model){
        logger.info("게시글 삭제값 주기");
        model.addAttribute("deleteState", boardService.deleteStatus(bdId, requestDto));
        return bdId;}
}

// DeleteMapping ver.
//    @ResponseBody
//    @DeleteMapping("/api/v1/board/{bdId}")
//    public Long delete(@PathVariable Long bdId) {
//        boardService.delete(bdId);
//        logger.info("게시글 삭제");
//        return bdId; }

