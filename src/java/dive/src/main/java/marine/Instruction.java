package marine;

import lombok.AllArgsConstructor;
import lombok.Getter;

import static java.lang.Integer.*;

@AllArgsConstructor
@Getter
public class Instruction {
    private final String text;
    private final int x;

    public static Instruction fromText(String text) {
        var split = text.split(" ");
        return new Instruction(split[0], parseInt(split[1].trim()));
    }
}