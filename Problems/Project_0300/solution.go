package main

import "math"

func lengthOfLIS_official(nums []int) int {
	dp := make([]int, len(nums))

	for i := range nums {
		dp[i] = 1
		for j := 0; j<i; j++ {
			if nums[i] > nums[j] {
				dp[i] = int(math.Max(float64(dp[i]), float64(dp[j]+1)))
			}
		}
	}
	result := 1
	for _, value := range dp {
		if result < value {
			result = value
		}
	}
	return result
}
