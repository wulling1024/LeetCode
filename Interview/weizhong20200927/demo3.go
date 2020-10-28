package main

import "fmt"

func main() {
	// 输入第一个数值n
	n := 0
	fmt.Scan(&n)
	// 数组值
	//arr := []int{2, 3, 5, 4, 3, 3}
	arr := make([]int, n)
	for i := 0; i < n; i++ {
		fmt.Scan(&arr[i])
	}
	result := 0

	for i := 0; i < n-2; i++ {
		for j := i + 1; j < n-1; j++ {
			if arr[i] > arr[j] {
				continue
			}
			for k := j + 1; k < n; k++ {
				if arr[j] > arr[k] {
					continue
				}
				result++
			}
		}
	}
	fmt.Println(result)
}
