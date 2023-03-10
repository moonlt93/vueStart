package com.things.vuestart.dto;

import com.things.vuestart.entity.Board;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
public class BoardDto {



    private Long id;
    private String title;
    private String content;
    private String writer;



    public static List<BoardDto> entityMaker(List<Board> board){

        List<BoardDto> lists = new ArrayList<>();
        for (Board bo: board
             ) {
            BoardDto dto = BoardDto.builder()
                    .id(bo.getId())
                    .writer(bo.getWriter())
                    .title(bo.getTitle())
                    .content(bo.getContent())
                    .build();
            lists.add(dto);
        }

        return lists;
    }
}
