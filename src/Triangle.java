import java.util.List;

public class Triangle {

    public int minimumTotal(List<List<Integer>> triangle) {

        if(triangle.size()==1){
            return triangle.getFirst().getFirst();
        }
        for (int i = triangle.size()-2; i >=0 ; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                triangle.get(i).set(j,triangle.get(i).get(j)+Math.min(triangle.get(i+1).get(j),triangle.get(i+1).get(j+1)));
            }

        }
        return triangle.getFirst().getFirst();
    }

}
