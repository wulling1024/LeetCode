package main

import "fmt"

func main() {
	arr := []int{-2, 1, -3, 4, -1, 2, 1, -5, 4}
	fmt.Println(maxSubArray(arr))
}

func maxSubArray(nums []int) int {
	result := make([]int, len(nums))
	result[0] = nums[0]
	for i := 1; i < len(nums); i++ {
		if result[i-1] <= 0 {
			result[i] = nums[i]
		} else {
			result[i] = result[i-1] + nums[i]
		}
	}
	max := result[0]
	for _, value := range result {
		if value > max {
			max = value
		}
	}
	return max
}
