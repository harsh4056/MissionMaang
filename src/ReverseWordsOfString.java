import java.util.ArrayList;
import java.util.List;

public class ReverseWordsOfString {

    public String reverseWords(String s) {

        StringBuilder temp = new StringBuilder();
        List<String> stringList= new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)!=' '){
                temp.append(s.charAt(i));
            }
            else{
                if(!temp.isEmpty()){
                    stringList.add(temp.toString());
                    temp= new StringBuilder();
                    System.gc();
                }
            }

        }
        if(!temp.isEmpty()){
            stringList.add(temp.toString());
            System.gc();
        }
        StringBuilder answer = new StringBuilder();
        for (int i = stringList.size()-1; i >=0; i--) {
            answer.append(stringList.get(i));
            answer.append(' ');

        }
        answer.deleteCharAt(answer.length()-1);
        return answer.toString();

    }

    public static void main(String[] args) {
        ReverseWordsOfString rev = new ReverseWordsOfString();

        System.out.println(rev.reverseWords("2FxAilQcB      B  TtncBPbP4g ZZoV    mNeb       tw  nSROWXI     wTVo   H3xt29kHX4   8  RxdoSJ8C  yJgf    2Qc     3Kx1h 46cho6       Bz48HT  HTr6F2pDVj    GZTAaq  FzQb3lxxx    KTjD   JCWLLLb9su       rZ9BaPz6zo    Wkuq9       sTNF   CvvNvMCI 4kuZ31sJ     qConO 2EQBo8A       YuV    xA0wDsiA  unR 1aU4e2Wejp       d8iMYK   m  J3CUTgI 9ac s     NvdSB2yyK   qhs94MbJP y   XmRmi7gV    37l2d4N  0gP4LLjaW     CQ      jSTO2jp      6FyMG6zJ attE2O     kTbDwt     rD   18csB       E9V5DV   uGLG8m23l   nsxfl6KH Xy  NEo7qO4       ZpuvDVcK    VEmFS7d      5Oh4diCu32   QA   VYjg0Db    ARMFYRgTy     hcDoxDkMSk     kGz5hl     STHJ       N9GcS  GbUrq      LFDsAn6JcV       d4XNa  D6LpCUiJl      3  8bno4    f      kC     y0rLHvRG7       n5      2d0Z1   XoNPwQ    UEfDuh6mBt   saH9pBaG       kL5Dh     5kc9fSba     36GGGRv     20Rfi  WiMCv2QHqk   CgZ2v5axa     pcj8C22    B9Iup     YYUIeUY       IM     pF84bIQd  iY3Xu20IN     pD9e4x  Dy2O    Kp   LFeoiI       7czYbRG  2ChkUQz   PKL8T0Iga    xXPMP19F5       m7U3J ZnGpUan       RnPprL47RP    qOayZH  a57F       nVz1qNW459     tQMQ23R8      62Ku    GSDWli  t   JXyfB7c    xWpWEF  4Da3 vGAXHquWZj  WpEKvWs0S   XVR0 4GKCXY      E9L       tgHxoveIiV    KttKQ    savj5qF     c8v   xoDC6C  Y4KDPr       rMLEPZdO    9kqpKlSD5 hTeiwU      jYASh7FxAO       qBBb iPbP       mk1bP6tT TUcTk7WUo      OQQ59J       WQuK6Iw1    wbvJ2  XjA       4NvMyeHo5     hKS  oYuYd33OvN  odlU4XVx   zNG   fIfSIyvp3c  JeRC  Ik9n    03bvgn  HXZeL UszXaJ")); // "world hello"
        System.out.println(rev.reverseWords("a good   example")); // "example good a"
        System.out.println(rev.reverseWords("  Bob    Loves  Alice   ")); // "Alice Loves Bob"
    }


    // Helper function to reverse a portion of the array
    private void reverse(char[] chars, int left, int right) {
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
    }
}
