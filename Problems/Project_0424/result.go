package main

/**

 */
func characterReplacement(s string, k int) int {
	var result int
	// 字符串转化为字符切片
	arr := []byte(s)
	for i,v1 := range arr {
		var tag int
		j := i+1
		for ; j<len(arr); j++ {
			if v1 == arr[j] {
				continue
			}else {
				if tag >= k {
					break
				}
				tag++
			}
		}
		if j == len(arr) && tag < k {
			var tag2 int
			for m := i-1; m >= 0; m-- {
				if v1 == arr[m] {
					i = m
					continue
				}else {
					if tag2 + tag >= k {
						break
					}
					tag2++
					i = m
				}
			}
		}
		if result >= (j-i) {
			continue
		}else {
			result = j-i
		}
	}
	return result
}
