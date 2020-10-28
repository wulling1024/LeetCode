package main

import "math"

/**
二维数组处理
*/
func longestPalindromeSubseq_official(s string) int {
	// var dp  [len(s)][len(s)]int // 声明二维数组有错误，不允许使用变量
	// create a two-dimensional array
	dp := make([][]int, len(s))
	for index := range dp {
		dp[index] = make([]int, len(s))
	}

	arr := []byte(s)
	for i := len(s) - 1; i >= 0; i-- {
		dp[i][i] = 1
		for j := i + 1; j < len(s); j++ {
			if arr[i] == arr[j] {
				dp[i][j] += dp[i+1][j-1] + 2
			} else {
				dp[i][j] = int(math.Max(float64(dp[i+1][j]), float64(dp[i][j-1])))
			}
		}
	}
	return dp[0][len(s)-1]
}
