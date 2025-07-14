import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> listList= new ArrayList<>();
        List<Integer> list= new ArrayList<>();

        list.add(1);


        listList.add(list);
        if (numRows == 1) {

            return listList;
        }
        for(int i=0;i<numRows-1;i++){
            list= new ArrayList<>();
            list.add(1);
            for(int j=1;j<listList.get(i).size();j++){
                list.add(listList.get(i).get(j-1)+listList.get(i).get(j));
            }
            list.add(1);
            listList.add(list);
        }


        return listList;
    }

    public static void main(String[] args) {
        System.out.println(new PascalsTriangle().generate(5));
    }
}
