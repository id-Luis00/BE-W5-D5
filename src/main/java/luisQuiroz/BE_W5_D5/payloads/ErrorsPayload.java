package luisQuiroz.BE_W5_D5.payloads;

import java.time.LocalDateTime;

public record ErrorsPayload(
        String message,
        LocalDateTime timestamp
) {
}
