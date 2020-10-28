package main

import "fmt"

func main() {
	arr := "bbbab"
	fmt.Println(longestPalindromeSubseq(arr))
}

/**
一维数组处理，目前还未解决
*/
func longestPalindromeSubseq(s string) int {
	arr := []byte(s)
	if len(arr) < 2 {
		return len(arr)
	} else {
		dp := make([]int, len(s))
		dp[0] = 0
		for index, value := range arr {
			for j := 0; j < index; j++ {
				if dp[j] > dp[index] {
					dp[index] = dp[j]
				}
			}
			if index > 0 && solve(s[0:index], value)%2 == 1 {
				dp[index] += 2
			}
		}
		if dp[len(s)-1] == 0 {
			return 1
		}
		return dp[len(s)-1]
	}
}

/**
判定字符 target 在字符串 des 中的出现次数
*/
func solve(des string, target byte) int {
	result := 0
	for _, value := range []byte(des) {
		if target == value {
			result++
		}
	}
	return result
}
