package risto.turtiainen.entropia_backend.entity;

public enum DamageType {
    CUT("Cut"),
    STAB("Stab"),
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