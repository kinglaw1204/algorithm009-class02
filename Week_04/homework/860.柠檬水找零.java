/*
 * @lc app=leetcode.cn id=860 lang=java
 *
 * [860] 柠檬水找零
 */

// @lc code=start
class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five=0,ten =0;

        for (int i = 0; i < bills.length; i++) {
            switch(bills[i]){
                case 5:
                    five++; continue;
                case 10:
                    if(five <=0){
                        return false;
                    }
                    five--;
                    ten++; continue;
                case 20:
                     if(five>0 && ten > 0){
                         ten--;
                         five--;
                         continue;
                     }else if(five >=3){
                        five -=3; continue;
                     }
                     return false;
                default:return false;

            }
        }
        return true;
    }
}
// @lc code=end

