/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

/**
 *
 * @author Bahul
 */
public class HouseRobber {
    int[] money;
    public int rob(int nums[]) {
        money = new int[nums.length];
        for(int i=0;i<money.length;i++) {
            money[i] = -1;
        }
        int i1 = robb(nums,0);
        int i2 = robb(nums,1);
        return (i1>i2)?i1:i2;
    }
    
    public int robb(int nums[], int i) {
        if(i >= nums.length) {
            return 0;
        } else {
            if(money[i]==-1){
                int i2 = robb(nums,i+2);
                int i3 = robb(nums,i+3);
                if(i2 > i3) {
                    money[i] = i2+nums[i];
                    return money[i];
                } else {
                    money[i] = i3+nums[i];
                    return money[i];
                }
            } else {
                return money[i];
            }
        }
    }
}
