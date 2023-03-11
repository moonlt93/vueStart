package com.things.vuestart.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String title;
    private String content;
    private String writer;


    public void update(Board update){
        this.title = update.getTitle();
        this.writer = update.getWriter();
        this.content = update.getContent();
    }


}
