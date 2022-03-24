package site.metacoding.searchproject01.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;
import site.metacoding.searchproject01.domain.boardTbl.BoardTbl;
import site.metacoding.searchproject01.domain.boardTbl.BoardTblRepository;

@RequiredArgsConstructor
@Controller
public class BoardController {

    private final BoardTblRepository boardTblRepository;

    @GetMapping("/search")
    public String search(@RequestParam(defaultValue = "") String keyword, Model model) {

        // if (keyword == null) {
        // System.out.println("키워드 null");
        // }
        // if (keyword.equals("")) {
        // System.out.println("키워드 공백");
        // }

        List<BoardTbl> boards = boardTblRepository.mSearch(keyword);
        System.out.println("크기 :" + boards.size());
        model.addAttribute("boards", boards);

        return "home";
    }
}
