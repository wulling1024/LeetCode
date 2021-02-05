package main

import (
	"fmt"
	"sort"
)

func Test_main4() {

	// 第一行输入
	n := 0
	fmt.Scan(&n)
	// 第二行输入
	arr := []int{}
	for i := 0; i < n; i++ {
		tmp := 0
		fmt.Scan(&tmp)
		arr = append(arr, tmp)
	}
	sort.Ints(arr)
	for i := range arr {
		result := []int{}
		for j := range arr {
			if i == j {
				continue
			}
			result = append(result, arr[j])
		}
		sort.Ints(result)
		fmt.Println(result[len(result)/2])
	}
}
