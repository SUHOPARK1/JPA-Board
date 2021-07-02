package com.myelinsoft.board.springboot.web;

import com.myelinsoft.board.springboot.service.BoardService;
import com.myelinsoft.board.springboot.web.dto.BoardResponseDto;

import lombok.RequiredArgsConstructor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RequiredArgsConstructor
@Controller
public class IndexController {
    Logger logger = LoggerFactory.getLogger(getClass());
    private final BoardService boardService;

    @GetMapping("/")
    public String index(){
        logger.info("홈 진입");
        return "index";}

    @GetMapping("/board")
    public String boardMain(Model model){
        model.addAttribute("board", boardService.findAllDesc());
        logger.info("게시판 진입");
        return "board-main";}

    @GetMapping("/board/save")
    public String boardSave(){
        logger.info("게시판 저장 진입");
        return "board-save";}

    @GetMapping("/board/detail/{bdId}")
    public String boardDetail(@PathVariable Long bdId, Model model) {
        BoardResponseDto dto = boardService.findById(bdId);
        model.addAttribute("view", boardService.viewCount(bdId));
        model.addAttribute("brd", dto);
        logger.info("게시글 상세보기 진입");
        return "board-detail";}

    @GetMapping("/board/update/{bdId}")
    public String boardUpdate(@PathVariable Long bdId, Model model) {
        BoardResponseDto dto = boardService.findById(bdId);
        model.addAttribute("view", boardService.viewCount(bdId));
        model.addAttribute("brd", dto);
        logger.info("게시글 수정하기 진입");
        return "board-update";}


}