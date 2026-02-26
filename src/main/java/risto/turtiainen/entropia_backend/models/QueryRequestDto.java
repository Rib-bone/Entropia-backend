package risto.turtiainen.entropia_backend.models;

import risto.turtiainen.entropia_backend.enums.DamageType;

import java.util.Set;

public record QueryRequestDto(
        Set<DamageType> armorDamageTypes,
        Double damage
){}
