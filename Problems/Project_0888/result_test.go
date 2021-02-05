package main

import (
	"fmt"
	"testing"
)

func Test_fairCandySwap(t *testing.T) {
	A := []int{35, 17, 4, 24, 10}
	B := []int{63, 21}
	fmt.Println(fairCandySwap(A, B))
}