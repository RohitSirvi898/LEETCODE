class Solution {
    public String reverseVowels(String s) {
        char[] sb = s.toCharArray();
        int i = 0;
        int j = s.length()-1;
        while(i<j){
            while(i<j && !(sb[i]=='a' || sb[i]=='e' || sb[i]=='i' || sb[i]=='o' || sb[i]=='u' || sb[i]=='A' || sb[i]=='E' || sb[i]=='I' || sb[i]=='O' || sb[i]=='U')){
                i++;
            }
            while(i<j && !(sb[j]=='a' || sb[j]=='e' || sb[j]=='i' || sb[j]=='o' || sb[j]=='u' || sb[j]=='A' || sb[j]=='E' || sb[j]=='I' || sb[j]=='O' || sb[j]=='U')){
                j--;
            }
            char temp = sb[i];
            sb[i]=sb[j];
            sb[j]=temp;
            i++;
            j--;
        }
        return new String(sb);
    }
}