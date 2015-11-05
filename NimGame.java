public class Solution {
    int[] winTable;
    public boolean canWinNim(int n) {
        
        winTable = new int[n+1];
        try {
            if(canWinNim2(n) == 1)
                return true;
            else
                return false;
        } catch(Exception e){
            return false;
        }
    }
    
    public int canWinNim2(int n) {
        if(winTable[n] == 0) {
            if(n == 1){
                winTable[1] = 1;
                return 1;
            } else if(n == 2){
                winTable[2] = 1;
                return 1;
            } else if(n == 3){
                winTable[3] = 1;
                return 1;
            } else if(canWinNim2(n-1) == 1 && canWinNim2(n-2) == 1 && canWinNim2(n-3) == 1){
                winTable[n] = -1;
                return winTable[n];
            } else {
                winTable[n] = 1;
                return winTable[n];
            }
        }else {
            return winTable[n];
        }
    }
}