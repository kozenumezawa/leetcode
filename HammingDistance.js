// https://leetcode.com/problems/hamming-distance/
/**
 * @param {number} x
 * @param {number} y
 * @return {number}
 */
var hammingDistance = function(x, y) {
    let hamming = 0;
    for (let i = 0; i < 31; i++) {
        if (x % 2 !== y % 2) {
            hamming++;
        }
        x = Math.floor(x / 2);
        y = Math.floor(y / 2);

        if (x === 0 && y === 0) {
            break;
        }
    }
    return hamming;
};
