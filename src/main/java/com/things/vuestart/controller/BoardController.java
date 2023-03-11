package com.things.vuestart.controller;

import com.things.vuestart.dto.BoardDto;
import com.things.vuestart.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {


    private final BoardService boardService;


    @GetMapping("/list")
    public List<BoardDto> getList(){

      return  boardService.getList();
    }

    @PostMapping
    public void createBoards(@RequestBody BoardDto dto){

        boardService.createBoards(dto);

    }

    public void updateBoards(@RequestBody BoardDto dto){

        boardService.updateBoards(dto);
    }


}
