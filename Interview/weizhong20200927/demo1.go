package main

import (
	"fmt"
	"sort"
)

func main() {
	// 数组长度
	n := 0
	// 查询次数
	q := 0
	fmt.Scan(&n, &q)

	// 数组的输入
	arr := make([]int, n)
	for i := 0; i < n; i++ {
		fmt.Scan(&arr[i])
	}
	// 查询次数的输入
	arr2 := make([]int, q)
	for i := 0; i < q; i++ {
		fmt.Scan(&arr2[i])
	}

	result := make([]int, q)

	// 数组排序
	sort.Ints(arr)

	for i := 0; i < q; i++ {
		for j := 0; j < n; j++ {
			if arr2[i] == arr[j] || (arr2[i] < arr[j] && j == 0) {
				result[i] = arr[j]
				break
			}
			if arr2[i] < arr[j] && j > 0 {
				// 判断差值
				if arr2[i]-arr[j-1] > arr[j]-arr2[i] {
					result[i] = arr[j]
					break
				} else {
					result[i] = arr[j-1]
					break
				}
			}
			if j == n-1 && arr2[i] > arr[j] {
				result[i] = arr[n-1]
			}
		}
	}
	for _, value := range result {
		fmt.Println(value)
	}

}
