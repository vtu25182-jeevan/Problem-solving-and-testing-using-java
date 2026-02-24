class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> ans = new ArrayList<>();

        int[] pFreq = new int[256];
        int[] sFreq = new int[256];

        int left = 0, len;
        for (int i = 0; i < p.length(); i++) {
            pFreq[p.charAt(i) - 'a']++;
        }
        for (int right = 0; right < s.length(); right++) {
            sFreq[s.charAt(right) - 'a']++;

            len = right - left + 1;
            while (len > p.length()) {
                sFreq[s.charAt(left) - 'a']--;
                left++;
                len = right - left + 1;
            }

            if (isAnagrams(sFreq, pFreq)) {
                ans.add(left);
            }
        }

        return ans;
    }

    private boolean isAnagrams(int[] sFreq, int[] pFreq) {
        for (int i = 0; i < 256; i++) {
            if (sFreq[i] != pFreq[i]) return false;
        }
        return true;
    }
}