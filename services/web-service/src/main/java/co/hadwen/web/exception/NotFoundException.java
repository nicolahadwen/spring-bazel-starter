package co.hadwen.web.exception;

import lombok.NonNull;

public class NotFoundException extends RuntimeException {
    private static final String MESSAGE_FORMAT = "%s not found matching query: %s";

    public NotFoundException(@NonNull Entity entity, @NonNull String query) {
        super(String.format(MESSAGE_FORMAT, entity.name(), query));
    }

    public enum Entity {
        USER
    }
}
