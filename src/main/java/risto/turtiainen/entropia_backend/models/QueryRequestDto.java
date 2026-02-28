package risto.turtiainen.entropia_backend.models;

import jakarta.validation.constraints.NotNull;
import risto.turtiainen.entropia_backend.enums.DamageType;

import java.util.Set;

public record QueryRequestDto(
        @NotNull(message = "armorDamageTypes list must not be null") Set<DamageType> armorDamageTypes,
        @NotNull(message = "damage field should not be null") Double damage,
        @NotNull(message = "preferredShotAmount field should not be null") int preferredShotAmount
){}
