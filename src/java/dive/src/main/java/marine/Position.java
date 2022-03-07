package marine;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.With;

@AllArgsConstructor
@With
@Getter
public class Position {
    private final int horizontal;
    private final int depth;
}