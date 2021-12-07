public class SubstringDifferByOne {
    public int countSubstrings(String s, String t) {
        int count = 0;
        for(int i=0;i<s.length();i++) {
            for(int j=0;j<t.length();j++) {
                int x = i;
                int y = j;
                int d = 0;
                while(x<s.length() && y<t.length()) {
                    if(s.charAt(x) != t.charAt(y)) {
                        d++;
                    }
                    if(d == 1) {
                        count++;
                    }
                    else if(d == 2) {
                        break;
                    }
                    x++;
                    y++;
                }
            }
        }
        return count;
    }

}
