package marine;

import lombok.Getter;

import java.util.List;

@Getter
public class Submarine {
    private Position position;

    public Submarine(int horizontal, int depth) {
        this.position = new Position(horizontal, depth);
    }

    public void move(List<Instruction> instructions) {
        instructions.forEach(this::move);
    }

    private void move(Instruction instruction) {
        position = switch (instruction.getText()) {
            case "down" -> position.withDepth(position.getDepth() + instruction.getX());
            case "up" -> position.withDepth(position.getDepth() - instruction.getX());
            default -> position.withHorizontal(position.getHorizontal() + instruction.getX());
        };
    }
}