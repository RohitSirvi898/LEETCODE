class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder str = new StringBuilder();
        int n1 = num1.length();
        int n2 = num2.length();
        int j = n2-1;
        int carry = 0;
        for(int i=n1-1;i>=0;i--){
            int a = num1.charAt(i)-'0';
            int b = j>=0?num2.charAt(j)-'0':0;
            int c = a+b+carry;
            carry = c/10;
            str.append(c%10);
            j--;
        }
        while(j>=0){
            int c = num2.charAt(j)-'0';
            c+=carry;
            carry = c/10;
            str.append(c%10);
            j--;
        }
        if(carry==1) str.append('1');

        return str.reverse().toString();
    }
}