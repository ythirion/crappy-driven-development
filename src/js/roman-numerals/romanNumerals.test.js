const { convertToRoman } = require ('./romanNumerals');

describe("RomanNumerals", () => {
    const testCases = {
        1    : "I"      ,
        3    : "III"    ,
        4    : "IV"     ,
        5    : "V"      ,
        6    : "VI"     ,
        10   : "X"      ,
        42   : "XLII"   ,
        58   : "LVIII"  ,
        101  : "CI"     ,
        2022 : "MMXXII" ,
    };

    it.each(Object.entries(testCases))('convert int should return its roman representation', (number, expected) => {
        expect(convertToRoman(parseInt(number)))
            .toBe(expected);
    });
});
