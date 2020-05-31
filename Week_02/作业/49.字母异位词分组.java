import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=49 lang=java
 *
 * [49] 字母异位词分组
 */

// @lc code=start
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
    if(strs == null || strs.length <=0){
        return new ArrayList();
    }
    Map<String,List> map = new HashMap<>();
    for (String s : strs) {
      char[] ss=  s.toCharArray();
      Arrays.sort(ss);
      String key = String.valueOf(ss);
      if(!map.containsKey(key)){
          map.put(key, new ArrayList());
      }
      map.get(key).add(s);
    }
    return new ArrayList(map.values());
    }
}
// @lc code=end

