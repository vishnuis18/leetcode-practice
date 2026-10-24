class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int[] months={31,28,31,30,31,30,31,31,30,31,30,31};

        int n=arriveAlice.length();

        int malicestart=0;
        int maliceend=0;

        int mbobstart=0;
        int mbobend=0;

        int dalicestart=0;
        int daliceend=0;

        int dbobstart=0;
        int dbobend=0;

        for(int i=0;i<n;i++){
            if(i<2){
               malicestart=(malicestart*10)+(arriveAlice.charAt(i)-'0');
               maliceend=(maliceend*10)+(leaveAlice.charAt(i)-'0');
               mbobstart=(mbobstart*10)+(arriveBob.charAt(i)-'0');
               mbobend=(mbobend*10)+(leaveBob.charAt(i)-'0');
            }else if(i>2){
               dalicestart=(dalicestart*10)+(arriveAlice.charAt(i)-'0');
               daliceend=(daliceend*10)+(leaveAlice.charAt(i)-'0');
               dbobstart=(dbobstart*10)+(arriveBob.charAt(i)-'0');
               dbobend=(dbobend*10)+(leaveBob.charAt(i)-'0');
            }
        }
        for(int i=0;i<malicestart-1;i++){
            dalicestart+=months[i];
        }

        for(int i=0;i<maliceend-1;i++){
            daliceend+=months[i];
        }

        for(int i=0;i<mbobstart-1;i++){
            dbobstart+=months[i];
        }

        for(int i=0;i<mbobend-1;i++){
            dbobend+=months[i];
        }

        return Math.max(0, Math.min(daliceend,dbobend)-Math.max(dalicestart,dbobstart)+1);
    }
}
