package main

import "fmt"

func main() {
	arr := []int{3,5,6,2,5,4,19,5,6,7,12}
	fmt.Println(lengthOfLIS_official(arr))
}

func lengthOfLIS(nums []int) int {
	if len(nums) == 0{
		return 0
	}
	result := make([]int, len(nums))
	tmp := make([]int,0)

	result[0] = 1
	tmp = append(tmp, nums[0])
	for i := 1; i < len(nums); i++ {
		if len(tmp) == 1 && nums[i] < tmp[0] {
			tmp[0] = nums[i]
			result[i] = result[i-1]
		} else if len(tmp) == 1 && nums[i] > tmp[0]{
			tmp = append(tmp, nums[i])
			result[i] = result[i-1] + 1
		} else if len(tmp) > 1 && nums[i] > tmp[len(tmp)-1] {
			tmp = append(tmp, nums[i])
			result[i] = result[i-1] + 1
		} else if len(tmp) > 1 && nums[i] == tmp[len(tmp) -1] {
			result[i] = result[i-1]
		} else if len(tmp) > 1 && nums[i] < tmp[len(tmp) -1] {
			if nums[i] > tmp[len(tmp) - 2] {
				tmp[len(tmp) - 1] = nums[i]
			}
			result[i] = result[i-1]
		} else {
			result[i] = result[i-1]
		}
	}
	// 循环判断
	tag := 0
	arr2 := make([]int, 0)
	for index, value := range nums {
		if value < tmp[0] {
			for i := index; i < len(nums); i++ {
				arr2 = append(arr2, nums[i])
			}
		}
	}
	if len(arr2) > 0 {
		tag = lengthOfLIS(arr2)
	}

	if tag > result[len(nums) -1] {
		return tag
	} else {
		return result[len(nums)-1]
	}
}
