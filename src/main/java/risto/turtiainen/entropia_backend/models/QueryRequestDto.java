package risto.turtiainen.entropia_backend.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import risto.turtiainen.entropia_backend.enums.DamageTypeEnum;

import java.util.Map;


public record QueryRequestDto(
        @NotNull(message = "armorDamageTypesAndAmounts map must not be null")
        Map<DamageTypeEnum, Integer> armorDamageTypesAndAmounts,
        @NotNull(message = "damage field should not be null")
        Double damage,
        @NotNull(message = "preferredShotAmount field should not be null")
        int preferredShotAmount,
        @NotNull(message = "preferredDamageAmount field should not be null")
        int preferredDamageAmount
) {
}
