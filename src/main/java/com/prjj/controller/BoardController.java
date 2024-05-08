package com.prjj.controller;

import com.prjj.domain.Board;
import com.prjj.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
public class BoardController {

    private final BoardService service;

    @GetMapping("/add")
    public String add() {

        return "board/add";
    }

    @PostMapping("/add")
    public String addPost(Board board, RedirectAttributes rttr) {

        service.add(board);

        rttr.addAttribute("id", board.getId());
        return "redirect:/board";
    }


    // /board?id=3
    @GetMapping("/board")
    public String view(Integer id, Model model) {

        Board board = service.get(id);


        model.addAttribute("board", board);
        return "board/view";
    }

    @GetMapping("/")
    public String home(Model model) {
        //게시물 목록 조회 (select)

        model.addAttribute("boardList", service.


                list());

        return "board/home";
    }

    @PostMapping("delete")
    public String delete(Integer id) {
        service.remove(id);

        return "redirect:/";
    }

    @GetMapping("/modify")
    public String modify(Integer id, Model model) {

        model.addAttribute("board", service.get(id));

        return "board/modify";
    }

    @PostMapping("/modify")
    public String modifyPost(Board board, RedirectAttributes rttr) {
        service.modify(board);
        rttr.addAttribute("id", board.getId());
        return "redirect:/board";
    }
}
