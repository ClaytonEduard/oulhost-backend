package clayton.eduard.oulhostbackend.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import clayton.eduard.oulhostbackend.model.Player;
import clayton.eduard.oulhostbackend.model.dtos.PlayerDto;
import clayton.eduard.oulhostbackend.service.PlayerService;

@RestController
@RequestMapping("/players")
public class PlayerController {
    @Autowired
    private PlayerService service;

    // * metodo create
    @PostMapping
    public ResponseEntity<Player> createPlayer(@RequestBody @Valid PlayerDto dto) {
        Player newPlayer = service.createPlayer(dto);
        return new ResponseEntity<>(newPlayer, HttpStatus.CREATED);
    }

    // * Metodo listar
    @GetMapping
    public ResponseEntity<List<Player>> getAllPlayers() {
        return new ResponseEntity<>(service.getAllPlayers(), HttpStatus.OK);
    }

}
