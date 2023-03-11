package com.things.vuestart.service;


import com.things.vuestart.dto.BoardDto;

import java.util.List;

public interface BoardService {

    public List<BoardDto> getList();

    void createBoards(BoardDto dto);

    void updateBoards(BoardDto dto);
}
