package main

import (
	"fmt"
	"math"
)

func main() {
	arr := []int{2, 5, 7}
	amount := 27
	fmt.Println(coinChange(arr, amount))
}

func coinChange(coins []int, amount int) int {
	result := make([]int, amount+1)
	result[0] = 0

	for index, _ := range result {
		if index == 0 {
			continue
		}
		result[index] = math.MaxInt8 - 1
		for _, v := range coins {
			if index >= v {
				result[index] = int(math.Min(float64(result[index]), float64(result[index-v])))
			}
		}
		result[index]++
	}
	if result[amount] == math.MaxInt8 {
		return  -1
	}
	return result[amount]
}
