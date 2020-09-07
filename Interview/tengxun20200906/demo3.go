package main

func main() {

}

// 获取重复值
func fun(str []string) map[string]int {
	result := make(map[string]int, 0)
	for i := range str {
		for j := i; j < len(str); j++ {
			if result[str[j]] != 0 {
				continue
			}
			result[str[j]]++
		}
	}
	return nil
}
