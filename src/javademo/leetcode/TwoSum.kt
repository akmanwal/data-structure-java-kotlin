package javademo.leetcode


fun main() {

    val nums = intArrayOf(2, 7, 10, 15, 16, 18, 20)
    print(twoSum(nums, 18).contentToString())
}

fun twoSum(nums: IntArray, target: Int): Array<Int> {

    var left = 0
    var right = 1


    while (left < nums.size - 1) {

        if (nums[left] + nums[right] == target) {
            return (arrayOf(left, right))
        }

        if (right == nums.size - 1) {
            left++
            right = left + 1
        } else {
            right++
        }
    }

    return arrayOf(left, right)
}
