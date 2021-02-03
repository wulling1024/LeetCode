package main

/**
使用 map[int]int 计数处理
 */
func findRepeatNumber(nums []int) int {
	m := make(map[int]int, len(nums))
	for _,value := range nums {
		if _,ok := m[value]; ok {
			return value
		}
		m[value]++
	}
	return nums[0]
}
