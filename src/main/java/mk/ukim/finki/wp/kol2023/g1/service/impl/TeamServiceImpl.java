package mk.ukim.finki.wp.kol2023.g1.service.impl;

import mk.ukim.finki.wp.kol2023.g1.model.Team;
import mk.ukim.finki.wp.kol2023.g1.model.exceptions.InvalidPlayerIdException;
import mk.ukim.finki.wp.kol2023.g1.model.exceptions.InvalidTeamIdException;
import mk.ukim.finki.wp.kol2023.g1.repository.TeamRepository;
import mk.ukim.finki.wp.kol2023.g1.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamServiceImpl implements TeamService
{
    @Autowired
    private TeamRepository teamRepository;

    @Override
    public Team findById(Long id) {
        return teamRepository.findById(id).orElseThrow(InvalidTeamIdException::new);
    }

    @Override
    public List<Team> listAll() {
        return teamRepository.findAll();
    }

    @Override
    public Team create(String name) {
        Team team = new Team(name);
        return teamRepository.save(team);
    }
}
