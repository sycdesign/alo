//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
//复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 3000 
// -105 <= nums[i] <= 105 
// 
// Related Topics 数组 双指针 
// 👍 3207 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ThreeSum {
    public static void main(String[] args) {
        Solution solution = new ThreeSum().new Solution();
        solution.threeSum(null);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

class Person{

   private String name;
   private Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<Person> personList = new ArrayList<>();
        Person p1 = new Person("A",1);
        Person p2 = new Person("B",2);
        Person p3 = new Person("C",2);
        personList.add(p1);
        personList.add(p2);
        personList.add(p3);

        Map<String,Integer> personMap = personList.stream().collect(Collectors.toMap(Person::getName,Person::getAge));

        System.out.println(personMap);

        return null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}