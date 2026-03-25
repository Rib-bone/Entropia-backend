package risto.turtiainen.entropia_backend.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum DamageTypeEnum {
    STAB("Stab"),
    CUT("Cut"),
    IMPACT("Impact"),
    PENETRATION("Penetration"),
    SHRAPNEL("Shrapnel"),
    BURN("Burn"),
    COLD("Cold"),
    ACID("Acid"),
    ELECTRIC("Electric");

    private final String text;

    DamageTypeEnum(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }

    @JsonCreator
    public static DamageTypeEnum fromString(String value) {
        return DamageTypeEnum.valueOf(value.trim().toUpperCase());
    }

    @JsonValue
    public String toJson() {
        return name();
    }

}