package com.prjj.service;


import com.prjj.domain.Board;
import com.prjj.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class BoardService {
    private final BoardMapper mapper;

    public void add(Board board) {
        mapper.insert(board);
    }

    public Board get(Integer id) {
        return mapper.selectByid(id);
    }

    public List<Board> list() {
        return mapper.selectAll();

    }

    public void remove(Integer id) {
        mapper.deleteById(id);
    }


    public void modify(Board board) {
        mapper.update(board);
    }
}
