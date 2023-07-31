package net.tecno360.gamecc.services.interfaces;

import net.tecno360.gamecc.dto.GameDTO;
import net.tecno360.gamecc.dto.GameMinDTO;

import java.util.List;
import java.util.Optional;

public interface IGameService {
    List<GameMinDTO> findAllGames();
    Optional<GameDTO>  findGameById(Long id);
    List<GameMinDTO> findGameByClassification(Long classificationId);
}
