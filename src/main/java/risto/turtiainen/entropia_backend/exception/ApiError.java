package risto.turtiainen.entropia_backend.exception;

import java.time.LocalDateTime;

public record ApiError(LocalDateTime timestamp, int status, String errorMessage, String message, String path) {
}
