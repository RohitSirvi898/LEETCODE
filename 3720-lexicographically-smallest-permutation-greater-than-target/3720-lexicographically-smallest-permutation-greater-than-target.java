class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int[] freq = new int[26];
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        int l = 0;
        while (l < target.length() && l < s.length()) {
            int idx = target.charAt(l) - 'a';
            if (freq[idx] > 0) {
                freq[idx]--;
                l++;
            } else {
                break;
            }
        }

        for (int i = l; i >= 0; i--) {
            char minReq = (i < target.length()) ? target.charAt(i) : (char) ('a' - 1);

            for (int j = (minReq - 'a' + 1); j < 26; j++) {
                if (j >= 0 && freq[j] > 0) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(target.substring(0, i));
                    sb.append((char) (j + 'a'));
                    freq[j]--;

                    for (int k = 0; k < 26; k++) {
                        while (freq[k] > 0) {
                            sb.append((char) (k + 'a'));
                            freq[k]--;
                        }
                    }
                    return sb.toString();
                }
            }

            if (i > 0) {
                freq[target.charAt(i - 1) - 'a']++;
            }
        }

        return "";
    }
}