package ItsSpring.main.team;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class TeamService {
    private final TeamRepository teamRepository;
    public List<Team> getList(){
        List<Team> tList = teamRepository.findAll();
        return tList;
    }

    public Team getTeam(Integer id){
        Optional<Team> t_id = teamRepository.findById(id);
        t_id.isPresent();
        Team t = t_id.get();
        return t;

    }

    public void create(String name, String number, String stack , String profile) {
        Team t = new Team();
        t.setName(name);
        t.setNumber(number);
        t.setStack(stack);
        t.setProfile(profile);
        t.setCreateDate(LocalDateTime.now());
        this.teamRepository.save(t);
    }
}
