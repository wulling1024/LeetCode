package main

import "fmt"

func Test_main() {
	N:=0
	M:=0
	for {
		n, _ := fmt.Scan(&N,&M)
		if n == 2 {
			break
		}
	}
	if N%2 == 0 {
		result := make([]int, N)
		for i := 0; i < N; i++ {
			_, _ = fmt.Scan(&result[i])
		}
		for i := 0; i < M; i++ {
			result = solve(result)
		}
		for _, value := range result {
			fmt.Printf("%v ", value)
		}
	}
}

func solve(arr []int) []int {
	result := make([]int, len(arr))
	arr1 := make([]int,0)
	for i := len(arr)/2; i<len(arr); i++ {
		arr1 = append(arr1, arr[i])
	}
	tag := 0
	for i:= 0; i<len(arr)/2; i++ {
		result[tag] = arr1[i]
		tag++
		result[tag] = arr[i]
		tag++
	}
	return result
}

