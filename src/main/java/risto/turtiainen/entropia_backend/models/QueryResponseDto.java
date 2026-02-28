package risto.turtiainen.entropia_backend.models;

import risto.turtiainen.entropia_backend.entities.Maturity;

import java.util.List;

public record QueryResponseDto(List<Maturity> maturities) {
}
