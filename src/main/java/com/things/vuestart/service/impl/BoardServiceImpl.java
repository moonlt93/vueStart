package com.things.vuestart.service.impl;

import com.things.vuestart.dto.BoardDto;
import com.things.vuestart.entity.Board;
import com.things.vuestart.repository.BoardRepository;
import com.things.vuestart.service.BoardService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

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

    @Transactional
    @Override
    public void updateBoards(BoardDto dto) {

    Optional<Board> optionalBoard  = repository.findById(dto.getId());

    if(optionalBoard.isPresent()){

       Board newBoards = Board.builder()
               .id(dto.getId())
               .title(dto.getTitle())
               .content(dto.getContent())
               .writer(dto.getWriter())
               .build();

     Board board = optionalBoard.get();

     board.update(newBoards);
    }



    }
}
