class Solution {
    public int bitwiseComplement(int n) {
        String binary = Integer.toBinaryString(n);
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<binary.length();i++){
            if(binary.charAt(i) == '1') sb.append('0');
            else sb.append('1');
        }
        String s = sb.toString();
        int number = Integer.parseInt(s,2);
        return number;
    }
}