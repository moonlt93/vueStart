package com.things.vuestart.service.impl;

import com.things.vuestart.dto.BoardDto;
import com.things.vuestart.entity.Board;
import com.things.vuestart.repository.BoardRepository;
import com.things.vuestart.service.BoardService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements BoardService {


    private final BoardRepository repository;


    @Override
    public List<BoardDto> getList() {

        List<Board> list = repository.findAll();

        return BoardDto.entityMaker(list);
    }

    @Override
    public void createBoards(BoardDto dto) {

        Board board = Board.builder()
                    .id(dto.getId())
                    .title(dto.getTitle())
                    .content(dto.getContent())
                    .writer(dto.getWriter())
                            .build();

        repository.save(board);

    }
}
