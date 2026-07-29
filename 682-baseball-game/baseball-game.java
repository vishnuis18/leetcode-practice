class Solution {
    public int calPoints(String[] operations) {
        int n=operations.length;
        ArrayList<Integer> no=new ArrayList<>();
        int sum=0;
        for(String s : operations){
            if(!s.equals("C") && !s.equals("D") && !s.equals("+") ){
                no.add(Integer.parseInt(s));
            }
            else if(s.equals("C")){
                no.remove(no.size()-1);
            }
            else if(s.equals("D")){
                int d=no.get(no.size()-1);
                d=d*2;
                no.add(d);
            }else{
                int size=no.size();
                int l=no.get(size-1);
                int sl=no.get(size-2);
                int ans=l+sl;
                no.add(ans);

            }
        }
        for(int x : no){
            sum+=x;
        }
        return sum;
    }
}