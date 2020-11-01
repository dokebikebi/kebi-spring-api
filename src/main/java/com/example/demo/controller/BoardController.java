package com.example.demo.controller;

import com.azure.core.annotation.Post;
import com.example.demo.database.board.Board;
import com.example.demo.database.user.Users;
import com.example.demo.service.BoardService;
import com.example.demo.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("")
@RequiredArgsConstructor
@CrossOrigin("*")
public class BoardController {

    private final BoardService boardService;


    @GetMapping("/board")
    public Map<String, Object> getBoard(Board board) {
        Map<String, Object> map = new HashMap<>();
        Board result = boardService.getBoard(board.getId());
        if (StringUtils.isEmpty(result.getId())) {
            map.put("result", "fail");
        } else {
            map.put("result", result);
        }
        return map;
    }

    @PostMapping("/board")
    public Map<String, Object> createBoard(Board board) {
        Map<String, Object> map = new HashMap<>();
        map.put("result", boardService.createBoard(board));
        return map;
    }

    @GetMapping("/board_list")
    public Map<String, Object> getBoardList() {
        Map<String, Object> map = new HashMap<>();
        map.put("result", boardService.getBoardList());
        return map;
    }


}