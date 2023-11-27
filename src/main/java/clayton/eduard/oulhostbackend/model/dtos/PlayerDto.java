package clayton.eduard.oulhostbackend.model.dtos;

import clayton.eduard.oulhostbackend.model.GroupType;

public record PlayerDto(
        String name,
        String email,
        String phoneNumber,
        GroupType groupType

) {
}