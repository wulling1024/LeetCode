package test

import (
	"fmt"
	"testing"
)

func Test_demo1(t *testing.T) {
	Main()
}

func Main() {
	result := []int{}
	// 第一行输入
	n1 := 0
	fmt.Scan(&n1)
	// 第二行输入
	arr1 := []int{}
	for i := 0; i < n1; i++ {
		tmp := 0
		fmt.Scan(&tmp)
		arr1 = append(arr1, tmp)
	}

	// 第三行
	n2 := 0
	fmt.Scan(&n2)
	// 第四行
	arr2 := []int{}
	for i := 0; i < n2; i++ {
		tmp := 0
		fmt.Scan(&tmp)
		arr2 = append(arr2, tmp)
	}

	i := 0
	j := 0
	for {
		if i >= len(arr1) || j >= len(arr2) {
			break
		}
		if arr1[i] == arr2[j] {
			result = append(result, arr1[i])
			i++
			j++
		}
		if arr1[i] > arr2[j] {
			i++
		}
		if arr1[i] < arr2[j] {
			j++
		}
	}
	for _, value := range result {
		fmt.Printf("%v ", value)
	}
}
