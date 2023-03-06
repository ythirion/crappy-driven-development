export class Position {
    constructor(public readonly horizontal: number, public readonly depth: number){}
    
    withHorizontal(newHorizontal: number): Position {
        return new Position(newHorizontal, this.depth);
    }

    withDepth(newDepth: number): Position {
        return new Position(this.horizontal, newDepth);
    }
}