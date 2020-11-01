package com.example.demo.service;

import com.example.demo.database.board.Board;
import com.example.demo.database.board.BoardRepository;

import java.time.LocalDateTime;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
@RequiredArgsConstructor
public class BoardService {


    private final BoardRepository boardRepository;

    public Board createBoard(Board board) {
        if(!StringUtils.isEmpty(board.getId())){
            Optional<Board> boardOptional = boardRepository.findById(board.getId());
            if (boardOptional.isPresent()) {
                Board board1 = boardOptional.get();
                board1.setTitle(board.getTitle());
                board1.setContent(board.getContent());
                board1.setInsertTime(LocalDateTime.now());
                return boardRepository.save(board1);
            } else {
                return boardRepository.save(board);
            }
        }
        return boardRepository.save(board);
    }


    public Board getBoard(Long id) {
        return boardRepository.findById(id).orElseGet(Board::new);
    }


    public List<Board> getBoardList() {
        return boardRepository.findAll(Sort.by(Sort.Order.desc("id")));
    }
}
