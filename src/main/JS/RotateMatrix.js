/**
1.7 Rotate Matrix

 * Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes,
 * write a method to rotate the image by 90 degrees. Can you do this in place?
 */

/**
[1,2,3]		[7, 4, 1]
[4,5,6] => 	[8, 5, 2]
[7,8,9]		[9, 6, 3]

if we want to rotate 90 degrees, the column index of each item needs to be swapped with the row index.

column = column.length -1 - row
row = column
1 = [0][0] => [0][2]
2 = [0][1] => [1][2]
3 = [0][2] => [2][2]
4 = [1][0] => [0][1]
5 = [1][1] => [1][1]
6 = [1][2] => [2][1]
7 = [2][0] => [0][0]
8 = [2][1] => [1][0]
9 = [2][2] => [2][0]

row = column.length - 1 - column
column = row

**/

//O(n) time and O(n) space where n is the number of elements in the 2d array

var rotateMatrix = function(matrix) {
	
	if (matrix == null || matrix.length <= 1) {
		console.log("Input is not a NxN Matrix");
		return matrix;
	}
	
	let rows = matrix.length;
	let columns = matrix[0].length; 
	if (rows != columns) {
		console.log("Input is not a NxN Matrix");
		return matrix;
	}
	
	var rotated = [...Array(rows)].map(e => Array(columns));
	for (let i = 0; i < rows; i++ ) {
		for (let j = 0; j < columns; j++) {
			rotated[i][j] = matrix[columns - 1 - (j)][i];
		}
		
	}
	return rotated;
	
};

// Constant Space solution
var rotateMatrixCS = function(matrix) {
	if (matrix == null || matrix.length <= 1) {
		console.log("Input is not a NxN Matrix");
		return matrix;
	}
	
	let rows = matrix.length;
	let columns = matrix[0].length; 
	if (rows != columns) {
		console.log("Input is not a NxN Matrix");
		return matrix;
	}
	
}

console.log("TEST 1:");
test = [[1,2,3],[4,5,6],[7,8,9]];
console.table(test);
console.table(rotateMatrix(test));


console.log("TEST 2:");
test = [];
console.table(test);
console.table(rotateMatrix(test));

console.log("TEST 3:");
test = [[1,2,3]];
console.table(test);
console.table(rotateMatrix(test));

console.log("TEST 4:");
test = [[1,2],[7,8]];
console.table(test);
console.table(rotateMatrix(test));

console.log("TEST 5:");
test = [[1,2,3],[7,8,9]];
console.table(test);
console.table(rotateMatrix(test));
