import * as fs from 'fs';
import { Instruction } from '../src/Instruction';
import { Submarine } from '../src/Submarine';

export function loadInstructions(): Array<Instruction> {
    return fs.readFileSync('./tests/submarine.txt', 'utf-8')
        .split(/\r?\n/)
        .map(line => Instruction.fromText(line));
}

export function calculateResult(submarine: Submarine): number {
    return submarine.currentPosition().depth * submarine.currentPosition().horizontal;
}