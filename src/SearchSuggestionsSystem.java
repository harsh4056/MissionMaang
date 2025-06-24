import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SearchSuggestionsSystem {

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Trie trie = new Trie();
        Arrays.sort(products);
        for (String product : products) {
            trie.insert(product);
        }
        List<List<String>> answer= new ArrayList<>();
        char []searchWordArr= searchWord.toCharArray();
        StringBuilder dataBuilder= new StringBuilder();
        for (char c : searchWordArr) {
            List<String> list = new ArrayList<>();
            if (trie.tries[c - 'a'] != null) {
                trie = trie.tries[c - 'a'];
                dataBuilder.append(c);
                recursiveSearch(list, dataBuilder, trie);
            } else {
                trie = new Trie(); // dead path to avoid suggestions for rest of prefix
            }
            answer.add(list); // always add the list, empty or not
        }


        return answer;

    }

    public void recursiveSearch(List<String > result,StringBuilder dataBuilder ,Trie root){
        if(root==null){
            return;
        }
        if(result.size()==3){
            return;
        }

        if(root.present){
            result.add(dataBuilder.toString());
        }
        if(result.size()<3) {
            for (int j = 0; j < 26; j++) {
                if (root.tries[j] != null && result.size() < 3) {
                    dataBuilder.append((char) ('a' + j));
                    recursiveSearch(result, dataBuilder, root.tries[j]);
                    dataBuilder.deleteCharAt(dataBuilder.length() - 1);
                }
            }
        }

    }



    public class Trie {
        Boolean present = false;

        Trie[] tries;
        Trie root;


        public Trie(Boolean present) {
            this.present = present;
            tries = new Trie[26];

        }


        public Trie() {
            root = this;
            tries = new Trie[26];
        }

        public void insert(String word) {
            Trie current = root;
            for (char c : word.toCharArray()) {
                if (current.tries[c - 'a'] == null)
                    current.tries[c - 'a'] = new Trie(false);
                current = current.tries[c - 'a'];
            }
            current.present = true;

        }

    }

    public static void main(String[] args) {
        SearchSuggestionsSystem sss = new SearchSuggestionsSystem();

       /* String[] products1 = {"mobile", "mouse", "moneypot", "monitor", "mousepad"};
        String searchWord1 = "mouse";
        System.out.println(sss.suggestedProducts(products1, searchWord1));
        // Expected: [["mobile","moneypot","monitor"],["mobile","moneypot","monitor"],["mouse","mousepad"],["mouse","mousepad"],["mouse","mousepad"]]

        String[] products2 = {"havana"};
        String searchWord2 = "havana";
        System.out.println(sss.suggestedProducts(products2, searchWord2));
        // Expected: [["havana"],["havana"],["havana"],["havana"],["havana"],["havana"]]

        String[] products3 = {"bags","baggage","banner","box","cloths"};
        String searchWord3 = "bags";
        System.out.println(sss.suggestedProducts(products3, searchWord3));
        // Expected: [["baggage","bags","banner"],["baggage","bags","banner"],["baggage","bags"],["bags"]]*/


        String[] products4 = {"oqjrtcokaagakchrwrdbrlpnqivwcpzwuxbdkpkhndevouwyrtmbokxolhbvrencthmyplqixnhnokbhtbstmslfbinsypubqjckiqujvmknxuomdwqkfudgiqmpzkvnshrmnoeonzyfaipdcfdwhekrazfkdlfluyvoevahsyhvqjfcizxjhucbpqdjgmqqalqnvfyrtfkyrxlavfbagxkdloetaiedqbrmtzxwwrpyewrcbntsnrdzurzlfokcxolkltouozdobqvtoldjuincumspqpujynxxetbflfnkrscxgrvennmczurjvnoalxcfcrnddfckavedjrvewmawxazviumzpudgolofsxllhgsdrnvjbipcsqsdoosfdkhavhicsfbyavwyxziefmycknhzqujqkbqhacuaebwqpkfnkovxchczohhirczixikuoktkaamchcghynclonujiyzkcghjjjtzckjxmpssfqjirnfvrddvoqvdeteegupzevydcywjsoybsflpgpzkcoztcayffscwxkofwibguysdjtmddgevjhbxrfiqliqyiczdunhosdctrvlagcugpsskpvlsdhcbpdtdwjbhchymlptjrmzmezwljxemgzecptluxbwtgoyvqwrvxkartgrebdegyqdibemnficwpgsywlzczvwujmykkyhkkxhvrtmjxcyidawfxjcagsgutndplixpepddiosflfoujxndtgxsbzarlwacjtydorlrtukbyibaktiphojmrcbwjppnuwwihuerqswjpmyblrdslnwpdnzovpslsrfbzhjywbimwdiqhxmdssjovufgbqqykozfjbylihfwanzjdtgeoimwowocykeskvivwuybdrowolstbrbenioagkgwednhymqisdvjuycjvtrurzqssxrisozysizxeoyelhglnppsjzggjunmyabzptlfktzphlmhvpoqlnrwgxauepumssyecjpwfozhxhvodsasomhtgbasijrpphbijnxcyrajypogighdxacjxqyxagfuenwrdajqsuzrjtrqjebjnbmdzbqdgmbuqofbyegnxvgsegbaqxsdjjffdxiqgqtlgclqtmjqfmbrsccnoidkugbwscamrqfqmpbfuvvoxrodoccusixfehzetsbiflonazsmacvwilarpgpwjkexykqkmklqcuhdrhhgrzofbsjvzwdaghqxajgwqmuhyyervscyiyggbqyhpvotnmaubapigegatgtqeazgcytubsuhjzipbyxnkyqveeetgecxwinwdjuawpzdieizlzqplzajafeernecfkpiilnuqdjnipjybqishinomemdxfwabhemxecuyailbogehxwwtzvaueonxkjmdvojpjjxaftvnbbsfcjjyzwartrbmxgktbhrqeynwoziddoh","kfnyprlqjosvbkvfvanhqsxpfezfafuzxchbwsdagvgtmtwdjsgnodkahyfkpyfmrbrcineichemlomrgaydmjnzbqxhzpciwkwbcsrpeafwkitjibviipnhvcqntjuwnccylnqdwxmirvnggcdwfbldnhxsjjhfqcxlggcpldamlyttzibadxzcpwecjjxekeoucanprljnsgvhpxjydazzlxofypaxcnwhhkhrtwbecouqvoxnzsitdzyrxokhdtynjgygqarnhyaqsdrgdqdmpfwdhlayltvrjalfxxctwgqtmuwgdwzxyuiictaul","kfnwqytfhroyewirkaofdwdjtzyaeamrqkbdzganjfqfykfwizgtxjhrbvnmbwyfivwrbbjralxuptonwhlvztgefnggltqekduxdhznowjsayyaieacjvewhfookivjuwmwmhlobrgummkvjwclbipmkwrpbwqlbthbokenmcaupqbtuglgqtpuognhfachuscdsztjbuffgdzajlzhmnmksdnyrhahnnhilwnqohxyjsiatzshinquevymllusyqzkjwovmgtwwfztpbcpvyjdkqcdkscpimchxdjdrxvropgbgrrccfqnatlqjlojfczeggnanpuqtebjcyezdqpxsfkegxqfeplcmfxyqmlruapeywuftbbosmpegfpcepukcsvpgmfundbvbzazwqnefmbnnxntixtormwfbnuwheahzddwksodogedymeujvxacdbguthxhlcmmblfwjrnurpfuawoghyakqkccxcgxzdraasdivjgvtjrulhgktdxjuzpdyewckrpmjrttusqubhwntpchscprcdddsbyxrqrnplgazwjvojrtxogqdvqarcspvkfljlswpktqxlndidtnhzryohyyujfncunynxkblsdpjlaifdzsjxpuapwjzwzeahrnfkgtaehwjqsligfjnmsivinygzoeaejagsvzkyicbsyfxhqaotexdsvtxuexnmqsjhmojexevbgozlkbmuuexgpklnsetscrceuvtfhrxwvloiucqbzpxwtodopesljmisfxqmxhjlehpyaodfwqbnfvjtplauiyiyrddbjdpkvznmvpbzxgemfhgpwligjwznbztyaenziwooceebfwppfpgmzczoenqtmqcjdgvdlhjpwwlqcyjmaqnjicyrocrvxxrnrhpsqvrndurviilufvwbsswtjlmefydjechqrgeqjucsjyaaudocxgpvtbfekgynmnywltxvqddtjdaunvfqjclrjsohfenjxqjpvcklfdjoaavgoukzqjijycwqipkzpcvaqzqwgwnolrqudrcqqymlhelskpvrlobsjxlgsunkdlvqdgpnnrhcgdxasbdmrcrauswiticdiwkhdvpkduqgqpujcyjkrksmhjswvqccpxfacszfdsdvoxjnlphqawjlxryprgoexjqxryuxadviwdebxjyzolpqerfkxhklgpeffahclnfyfnwudwnjjqbcazsuzekwfsprbiwztqsxtxpiemfucwgcamdowvoymuwkstyqggmtknzezacoklmiaanvsttqknedeoayakomzzzntfmyfaunsnvimvkboqcfprizsofhauflvmetrwfoigjcxjavspnaqwpagfwslxolbjgglknrcacqntfcizfkmcrdbdidvojdritvnvgnsvrhjcutojfvjaspzdodnisyuirklwcxjitakdpxaclthbxgooxmqslftctxopfencxtzktckpkpkhlkboueylshbztlvkbtkpjdcxakldxmnjnqjyscgvydlmnpfnaxaicylivtesvtoqimovynmntiijxnwinlirbmiubpwlmwdscynsywgswsklxaxjwoculminicuphgtepjxmlhaolzzxuqqawjmvlniknniwexrelrvxagbtcqnzhdmiqfkyvwnsfuzskzlcvcyluzjtesuvzdknipreueyqgzvgbeqtmcnzwtfdgmihuzwtsdxahawfiwnpzzwpnzawfzyobyriuxbnlojvkfycwprgngluhgyirhutknuvdyebwrmaarbelkhzoqpilrneitzzuysmlpczdepdngeuwcpylcysafnmzulcrzlkaskbiexjikebbrwlbcpgvmiumsafuzqcuxnpwtjgqmlmnbeauljmyrxykugovjfazsrkzsyonecfejokeiwtxvdjawbkgvlqegxcoxwhldzoblzvhydopqpatwxllccdnlmxjypjiimtczqhubuloozyiwjmcsooqvufuamaopwxsexaaohazzctezrqahkdsnkqspkjqcvocnqirwzxocbxibrwrlrhzcuxlfqsgwoqyagkmcrdedasvrzjgugbrvvbsjtmjfbdxhchbkfomefrfrwdiyhhskrqstnnwrclsphqfrbwjvlitjmwtlmx","kfnyprlqjosvbkvfvanhqsxpfezfafuzxchbwsdagvgtmtwdjsgnodkahyfkpyfmrbrcineichemlomrgaydmjnzbqxhzpciwkwbcsrpeafwkitjibviipnhvcqntjuwnccylnqdwxmirvnggcdwfbldnhxsjjhfqcxlggcpldamlyttzibadxzcpwecjjxekeoucanprljnsgvhpxjydazzlxofypaxcnwhhkhrtwbecouqvoxnzsitdzyuoyzfkyseiohccpdtnjhqlrkgpcifvatradjfurxmwfssmbpbvxeoialjeyxujpgqdunhrthidhizzqddvuqzmoenmjzunulkrjyxfugrpvkwoiwyxwgrweakhbswllbyziranhxkleggegegdailjgyteaghdqnjqdjfhyrapqmckvxgxmasnweej"};
        String searchWord4 = "kfnyprlqjosvbkvfvanhqsxpfezfafuzxchbwsdagvgtmtwdjsgnodkahyfkpyfmrbrcineichemlomrgaydmjnzbqxhzpciwkwbcsrpeafwkitjibviipnhvcqntjuwnccylnqdwxmirvnggcdwfbldnhxsjjhfqcxlggcpldamlyttzibadxzcpwecjjxekeoucanprljnsgvhpxjydazzlxofypaxcnwhhkhrtwbecouqvoxnzsitdzyuoyzfkyseiohccpdtnjhqlrkgpcifvatradjfurxmwfssmbpbvxeoialjeyxujpgqdunhrthidhizzqddvuqzmoyrnqunojmtporeofgldjntqvlngobvtpbhmmdrkosxlkvmivonldjr";
        System.out.println(sss.suggestedProducts(products4, searchWord4));
    }

    public List<List<String>> suggestedProducts2(String[] products, String searchWord) {
        Arrays.sort(products); // sort products lexicographically
        List<List<String>> result = new ArrayList<>();
        int start = 0, n = products.length;
        String prefix = "";

        for (char c : searchWord.toCharArray()) {
            prefix += c;

            // Binary search to find first string ≥ prefix
            start = lowerBound(products, prefix, start);
            List<String> suggestions = new ArrayList<>();

            // Collect up to 3 matching products
            for (int i = start; i < Math.min(start + 3, n); i++) {
                if (products[i].startsWith(prefix)) {
                    suggestions.add(products[i]);
                } else {
                    break;
                }
            }
            result.add(suggestions);
        }

        return result;
    }

    // Custom lower bound: find first index ≥ prefix
    private int lowerBound(String[] products, String prefix, int start) {
        int low = start, high = products.length;
        while (low < high) {
            int mid = (low + high) / 2;
            if (products[mid].compareTo(prefix) < 0) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
