import java.util.*;

public class CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        String[] split1=version1.split("\\.");
        String[] split2=version2.split("\\.");
        int l1=split1.length;
        int l2=split2.length;
        int n=Math.max(l1,l2);
        for (int i = 0; i < n; i++) {
            int v1=i<l1?Integer.parseInt(split1[i]):0;
            int v2=i<l2?Integer.parseInt(split2[i]):0;
            if(v1<v2) return -1;
            else if(v1>v2) return 1;
        }

        return 0;
    }

    public static void main(String[] args) {
        CompareVersionNumbers obj = new CompareVersionNumbers();

        // Test case 1
        System.out.println(obj.compareVersion("1.2", "1.10"));
        // Expected: 0 (both represent version 1.1)

        // Test case 2
        System.out.println(obj.compareVersion("1.0", "1.0.0"));
        // Expected: 0 (trailing zeros don't matter)

        // Test case 3
        System.out.println(obj.compareVersion("0.1", "1.1"));
        // Expected: -1 (version1 < version2)
    }

}
