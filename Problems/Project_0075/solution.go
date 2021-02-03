package main

import "fmt"

/**
解决函数
 */

/**
解题思路：类似于"键索引计数法"
	1、扫描一遍 target ，赋值给新的数组，并统计不同颜色的数据量
	2、扫描新的数组，按照获取到的数据量值重新赋值给 target
 */
// todo 函数内的 []int 到底是切片类型，还是数组类型？有待验证
func sortColors(nums []int)  {
	// 过渡数组空间
	a := make([]int, len(nums))
	// 红色 0, 白色 1, 蓝色 2
	var l1,l2 int
	// var l3 int
	for index, value := range nums {
		a[index] = value
		switch value {
		case 0:
			l1++
			break
		case 1:
			l2++
			break
		//case 2:
		//	l3++
		//	break
		}
	}

	var tag int
	tag2 := l1 + l2
	for _, value := range a {
		switch value {
		case 0:
			nums[tag] = value
			tag++
			break
		case 1:
			nums[l1] = value
			l1++
			break
		case 2:
			nums[tag2] = value
			tag2++
			break
		}
	}

	fmt.Println(nums)
}