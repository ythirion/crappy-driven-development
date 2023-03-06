import { Position } from "./Position";
import { Instruction } from "./Instruction";

export class Submarine {
    private position: Position;
    private moveTo: Map<string, Function> = new Map([
        ["down", (instruction: Instruction) => this.position.withDepth(this.position.depth + instruction.x)],
        ["up", (instruction: Instruction) => this.position.withDepth(this.position.depth - instruction.x)]
    ]);

    constructor(horizontal: number, depth: number) {
        this.position = new Position(horizontal, depth);
    }

    private newPosition(instruction: Instruction): Position {
        if(this.moveTo.has(instruction.text)) {
            return this.moveTo
                        .get(instruction.text)
                        ?.call(this, instruction);
        }
        return this.position.withHorizontal(this.position.horizontal + instruction.x);
    }

    move(instructions: Array<Instruction>): void {
        instructions.forEach(i => this.position = this.newPosition(i));
    }

    currentPosition(): Position {
        return this.position;
    }
}