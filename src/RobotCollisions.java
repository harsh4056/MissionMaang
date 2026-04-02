import java.util.*;

public class RobotCollisions {

        public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
            Robot[] robots= new Robot[positions.length];
            for (int i = 0; i < positions.length; i++) {
                    robots[i]= new Robot(positions[i],healths[i],directions.charAt(i));
            }
            HashMap<Integer,Robot> map= new HashMap<>();


            Arrays.sort(robots,((a,b)->{
                return a.position-b.position;
            }));
            Stack<Robot> stack= new Stack<>();

            int i=0;
            while(i<robots.length){
                Robot curr=robots[i];
                if(stack.isEmpty() && curr.dir=='L'){
                    map.put(curr.position,curr);
                }
                else if(!stack.isEmpty() && robots[i].dir=='L'){

                    while(!stack.isEmpty() && curr!=null){
                        if(stack.peek().health>curr.health){
                            curr=null;
                            stack.peek().health--;
                        }
                        else if(stack.peek().health==curr.health){
                            curr=null;
                            stack.pop();
                        }
                        else if(stack.peek().health<curr.health){
                            stack.pop();
                            curr.health--;
                        }
                    }
                }
                else{
                    stack.push(curr);
                    curr=null;
                }
                if(curr!=null){
                    map.put(curr.position,curr);
                }
                i++;

            }



            List<Integer> answer= new ArrayList<>();
            for (Robot robot:stack){
                map.put(robot.position,robot);
            }
            for (int position : positions) {
                if(map.containsKey(position)){
                    answer.add(map.get(position).health);
                }
            }


            return answer;
        }
        class Robot{
            int position;
            int health;
            char dir;

            public Robot(int position, int health, char dir) {
                this.position = position;
                this.health = health;
                this.dir = dir;
            }
        }
    public static void main(String[] args) {
        RobotCollisions obj = new RobotCollisions();


        int[] positions5 = {34,50,42,2};
        int[] healths5 = {6,27,17,38};
        String directions5 = "LLRR";
        System.out.println(obj.survivedRobotsHealths(positions5, healths5, directions5)); // [6,27,17,38]



        int[] positions4 = {5,4,3,2,1};
        int[] healths4 = {2,17,9,15,10};
        String directions4 = "RRRRR";
        System.out.println(obj.survivedRobotsHealths(positions4, healths4, directions4)); // [2,17,9,15,10]



        int[] positions0 = {3,40};
        int[] healths0 = {49,11};
        String directions0 = "LL";
        System.out.println(obj.survivedRobotsHealths(positions0, healths0, directions0)); // [49,11]


        int[] positions1 = {1,40,41,42};
        int[] healths1 = {10,11,12,13};
        String directions1 = "RLRL";
        System.out.println(obj.survivedRobotsHealths(positions1, healths1, directions1)); // [10]


        int[] positions2 = {3,5,2,6};
        int[] healths2 = {10,10,15,12};
        String directions2 = "RLRL";
        System.out.println(obj.survivedRobotsHealths(positions2, healths2, directions2)); // [14]





        int[] positions3 = {1,2,5,6};
        int[] healths3 = {10,10,11,11};
        String directions3 = "RLRL";
        System.out.println(obj.survivedRobotsHealths(positions3, healths3, directions3)); // []
    }
}
