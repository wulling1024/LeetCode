package main

import "sort"

/**

 */
func fairCandySwap(A []int, B []int) []int {
	var result []int

	// 保证切片内部元素的有序
	sort.Ints(A)
	sort.Ints(B)
	// 计算数组内部元素的总和
	temp1 := 0
	for _,value := range A {
		temp1 += value
	}
	temp2 := 0
	for _, value := range B {
		temp2 += value
	}
	// 计算平均值
	tag := (temp1 + temp2) / 2

	for i := len(A)-1; i < len(A); i-- {
		tmp := tag - temp1
		index := sort.SearchInts(B, tmp + A[i])
		if index < len(B) && B[index] == tmp + A[i]{
			result = append(result, A[i], tmp + A[i])
			break
		}
	}
	return result
}
