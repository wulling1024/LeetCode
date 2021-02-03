package main

import "fmt"

func main() {
	arr := []int{0,1,2,3,4,8,9,11}
	fmt.Println(canCross(arr))
}

func canCross(stones []int) bool {
	nums := len(stones)
	// 组建可跳步数的集合
	tmp := make([][]int, nums)
	// 可达性状态
	result := make([]bool, nums)
	result[0] = true
	tmp[0] = append(tmp[0], 0, 1)
	for i := 1; i < nums; i++ {
		for j := i-1; j >= 0; j-- {
			tag := stones[i] - stones[j]
			if result[j] && contain(tmp[j], tag){
				tmp[i] = append(tmp[i], tag - 1, tag, tag + 1)
				result[i] = true
			}

		}
	}
	return result[nums-1]
}
// 判断数组中是否含有m
func contain(arr []int, m int) bool {
	for _, value := range arr {
		if m == value {
			return true
		}
	}
	return false
}
