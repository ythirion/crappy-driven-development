import { Submarine } from '../src/Submarine';
import { loadInstructions, calculateResult } from '.';

// Advent of code instructions available here : https://adventofcode.com/2021/day/2
describe('submarine should move', function () {
    test('on given text instructions', () => {
        const submarine = new Submarine(0, 0);
        submarine.move(loadInstructions());

        expect(calculateResult(submarine)).toBe(1690020);
    })
})
