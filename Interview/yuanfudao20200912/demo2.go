package main

import (
	"fmt"
)

func main() {
	T:=0
	fmt.Scan(&T)
	result := make([]interface{}, T)
	for i := 0; i<len(result); i++ {
		_, _ = fmt.Scan(&result[i])
	}


}
