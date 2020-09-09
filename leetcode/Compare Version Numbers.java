class Solution {
    public int compareVersion(String version1, String version2) {
        String[] s1 = version1.split("\\.");
        String[] s2 = version2.split("\\.");
        
        int len1 = s1.length;
        int len2 = s2.length;
        
        return calc(s1, s2, Math.max(len1, len2));
    }
    public int calc(String[] s1, String[] s2, int len){
        int len1 = s1.length;
        int len2 = s2.length;
        
        for(int i = 0; i < len; i++){
            int num1 = i >= len1 ? 0 : Integer.parseInt(s1[i]);
            int num2 = i >= len2 ? 0 : Integer.parseInt(s2[i]);
            
            if(num1 == num2) continue;
            if(num1 > num2)
                return 1;
            else
                return -1;
        }
        return 0;
    }
}
