package com.things.vuestart.service.impl;

import com.things.vuestart.dto.BoardDto;
import com.things.vuestart.entity.Board;
import com.things.vuestart.repository.BoardRepository;
import com.things.vuestart.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Slf4j
public class BoardServiceImpl implements BoardService {


    private final BoardRepository repository;


    @Override
    public List<BoardDto> getList() {

        List<Board> list = repository.findAll(Sort.by(Sort.Direction.DESC,"id"));

        return BoardDto.entityMaker(list);
    }

    @Override
    public void createBoards(BoardDto dto) {

        log.info("여기 도착");
        Board board = Board.builder()
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

    @Override
    public void deleteBoard(long id) {

        Optional<Board> optionalBoard  = repository.findById(id);
        if(optionalBoard.isPresent()){
           Board board= optionalBoard.get();
           repository.delete(board);
           log.info("delete finish");
        }

    }

    @Override
    public BoardDto getDetails(Long id) {
        Board entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("게시글을 찾을 수 없습니다."));

        return BoardDto.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .writer(entity.getWriter())
                .content(entity.getContent())
                .build();
    }

}
