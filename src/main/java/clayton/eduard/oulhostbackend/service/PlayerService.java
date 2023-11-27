package clayton.eduard.oulhostbackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import clayton.eduard.oulhostbackend.infra.CodiNameHandler;
import clayton.eduard.oulhostbackend.model.GroupType;
import clayton.eduard.oulhostbackend.model.Player;
import clayton.eduard.oulhostbackend.model.dtos.PlayerDto;
import clayton.eduard.oulhostbackend.repositories.PlayerRepository;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private CodiNameHandler codiNameHandler;

    public Player createPlayer(PlayerDto dto) {
        Player newPlayer = new Player(dto);
        String codiName = getCodiName(dto.groupType());
        newPlayer.setCodiName(codiName);
        return playerRepository.save(newPlayer);
    }

    private String getCodiName(GroupType groupType) {
        return codiNameHandler.findCodiname(groupType);
    }

    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

}
