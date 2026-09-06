class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five=0;
        int ten=0;

        for(int bill:bills){
            if(bill==5){
                five++;
            }else if(bill==10){
                if(five==0){
                    return false;
                }else{
                    five--;
                    ten++;
                }
            }else{
                if(five>=1 && ten>=1){
                    five--;
                    ten--;
                }else if(five>=3){
                    five=five-3;
                }else{
                    return false;
                }
            }
        }
        return true;
    }
}
/*
class Solution {
    public boolean lemonadeChange(int[] bills) {
        int n=bills.length;

        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(5,0);
        map.put(10,0);
        map.put(20,0);
        for(int num: bills){
            if(num==5){
                map.put(num,map.get(num)+1);
            }
            else if(num==10){
                map.put(num,map.get(num)+1);
                if(map.get(5)==0){
                    return false;
                }else{
                    map.put(5,map.get(5)-1);
                }
            }else{
                map.put(num,map.get(num)+1);
                if(map.get(10)>=1 && map.get(5)>=1){
                    map.put(10,map.get(10)-1);
                    map.put(5,map.get(5)-1);
                }else if(map.get(5)>=3){
                    map.put(5,map.get(5)-3);
                }else{
                    return false;
                }
            }
        }
        return true;
    }
}
*/