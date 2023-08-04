package ItsSpring.main.team;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
@RequiredArgsConstructor
@Controller

public class TeamController {
    private final TeamService teamService;

    @GetMapping("/team/list")
    public String teamList(Model model){
        List<Team> tList = teamService.getList();
        model.addAttribute("tList", tList);
        return "team_list";
    }
    @GetMapping("/team/detail/{id}")
    public String teamDetail(Model model, @PathVariable("id") Integer id){
        Team team = teamService.getTeam(id);
        model.addAttribute("team", team);
        return "team_detail";
    }
    @GetMapping("/team/create")
    public String teamCreate() {
        return "add_form";
    }
    @PostMapping("/team/create")
    public String teamCreate(@RequestParam String name, @RequestParam String number, @RequestParam String stack, @RequestParam String profile) {
        teamService.create(name, number, stack, profile);
        return "redirect:/team/list"; // 질문 저장후 질문목록으로 이동
    }

}
