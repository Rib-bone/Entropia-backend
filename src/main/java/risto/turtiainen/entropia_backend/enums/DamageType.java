package risto.turtiainen.entropia_backend.enums;

public enum DamageType {
    STAB("Stab"),
    CUT("Cut"),
    IMPACT("Impact"),
    PENETRATION("Penetration"),
    SHARPNEL("Shrapnel"),
    BURN("Burn"),
    COLD("Cold"),
    ACID("Acid"),
    ELECTRIC("Electric");

    private final String text;

    DamageType(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }

}