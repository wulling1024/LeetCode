package main

import (
	"fmt"
	"math"
)

func main() {
	arr := [][]int{{1, 2, 5},{3, 2, 1}}
	fmt.Println(minPathSum(arr))
}

func minPathSum(grid [][]int) int {
	// 行数
	x := len(grid)
	// 列数
	y := len(grid[0])
	// 结果值
	result := make([][]int, x)
	result[0] = append(result[0], grid[0][0])
	for i := 1; i < x; i++ {
		result[i] = append(result[i], result[i-1][0] + grid[i][0])
	}
	for i := 1; i < y; i++ {
		result[0] = append(result[0], result[0][i-1] + grid[0][i])
	}
	for i := 1; i < x; i++ {
		for j := 1; j < y; j++ {
			result[i] = append(result[i], grid[i][j] + int(math.Min(float64(result[i][j-1]), float64(result[i-1][j]))))
		}
	}
	return result[x-1][y-1]
}
