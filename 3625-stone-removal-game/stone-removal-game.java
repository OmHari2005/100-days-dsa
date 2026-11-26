class Solution {
    public boolean canAliceWin(int n) {
        if(n<10){
            return false;
        }
        if(n>=10 && n<19){
            return true;
        }
        if(n>=19 && n<=26){
            return false;
        }
        if(n>26 && n<=33){
            return true;
        }
        if(n>33 && n<=39){
            return false;
        }
        if(n>=40 && n<45){
            return true;
        }
        if(n>=45 && n<49){
            return false;
        }
        if(n==49){
            return true;
        }
        if(n==50){
            return true;
        }
        return true;
    }
}