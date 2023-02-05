const rmap = {
    1000 : "M"  ,
    900  : "CM" ,
    500  : "D"  ,
    400  : "CD" ,
    100  : "C"  ,
    90   : "XC" ,
    50   : "L"  ,
    40   : "XL" ,
    10   : "X"  ,
    9    : "IX" ,
    5    : "V"  ,
    4    : "IV" ,
    1    : "I"  ,
};

function convertToRoman(number) {
    if (number <= 0)
        throw new RangeError("must be an integer greater than zero");

    const closestKey = parseInt(Object.keys(rmap).filter(key => key <= number).pop());
    if (closestKey == number)
        return rmap[closestKey];
    else
        return rmap[closestKey] + convertToRoman(number - closestKey);
}

module.exports = { convertToRoman };
