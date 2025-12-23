import java.util.*;

public class CountMentionsPerUser {

    /*
    ["MESSAGE", "timestampi", "mentions_stringi"]
    id<number>
    ALL: mentions all users.
    HERE: mentions all online users.

    ["OFFLINE", "timestampi", "idi"]


    All users are initially online, and if a user goes offline or comes back online,
    their status change is processed before handling any message event that occurs at the same timestamp.
    Note that a user can be mentioned multiple times in a single message event,
    and each mention should be counted separately.

    */

    public void decipher(int[]mentions,int[]offline,List<String > event){
        boolean offlineMessage= event.getFirst().equals("OFFLINE");
        int timeStamp= Integer.parseInt(event.get(1));
        for (int i = 0; i < offline.length; i++) {
           if(offline[i]!=-1){
               int diff=timeStamp-offline[i];
               if(diff>=60){
                   offline[i]=-1;
               }
           }

        }
        if(offlineMessage){
            int id=Integer.parseInt(event.get(2));
            offline[id]=timeStamp;
        }
        else{
            String mentionInEvent=event.get(2);
            if(mentionInEvent.equals("ALL")){
                for (int i = 0; i < mentions.length; i++) {
                     mentions[i]++;
                }
            }
            else if(mentionInEvent.equals("HERE")){
                for (int i = 0; i < mentions.length; i++) {
                    if(offline[i]==-1){
                        mentions[i]++;
                    }
                }
            }
            else{
                String[] ids= mentionInEvent.split(" ");
                for (String id : ids) {
                    String cleanId= id.substring(2);
                    int integerID= Integer.parseInt(cleanId);
                    mentions[integerID]++;
                }
            }
        }
    }
    public int[] countMentions(int numberOfUsers, List<List<String>> events) {
        int[] mentions= new int[numberOfUsers];
        int[] offline= new int[numberOfUsers];
        Arrays.fill(offline,-1);

        events.sort((a, b) -> {
            int at = Integer.parseInt(a.get(1));
            int bt = Integer.parseInt(b.get(1));

            if (at == bt) {
                String aEvent = a.getFirst();
                String bEvent = b.getFirst();

                // OFFLINE should come before MESSAGE
                if (aEvent.equals(bEvent)) return 0;
                if (aEvent.equals("OFFLINE")) return -1;
                return 1; // bEvent must be OFFLINE
            }
            return at - bt;
        });


        for (List<String> event : events) {
            decipher(mentions,offline,event);
        }
        return mentions;
    }

    public static void main(String[] args) {
        CountMentionsPerUser sol = new CountMentionsPerUser();

        // Test case 1
        List<List<String>> events1 = new ArrayList<>();
        events1.add(Arrays.asList("MESSAGE","2","HERE"));
        events1.add(Arrays.asList("OFFLINE","2","1"));
        events1.add(Arrays.asList("OFFLINE","1","0"));
        events1.add(Arrays.asList("MESSAGE","61","HERE"));
        System.out.println(Arrays.toString(sol.countMentions(3, events1)));
        // Expected: [1, 0, 2]

        // Additional Test 2
        List<List<String>> events2 = new ArrayList<>();
        events2.add(Arrays.asList("MESSAGE","5","id0 id2"));
        events2.add(Arrays.asList("OFFLINE","6","2"));
        events2.add(Arrays.asList("MESSAGE","65","HERE"));
        System.out.println(Arrays.toString(sol.countMentions(3, events2)));
        // Expected: [2,1,1]

        // Additional Test 3
        List<List<String>> events3 = new ArrayList<>();
        events3.add(Arrays.asList("OFFLINE","10","1"));
        events3.add(Arrays.asList("MESSAGE","20","ALL"));
        events3.add(Arrays.asList("MESSAGE","80","HERE"));
        System.out.println(Arrays.toString(sol.countMentions(3, events3)));
        // Expected: [2,2,2]
    }




}
