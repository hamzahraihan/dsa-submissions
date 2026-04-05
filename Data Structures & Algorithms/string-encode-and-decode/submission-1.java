class Solution {
    
    public String encode(List<String> strs) {
        StringBuilder res = new StringBuilder();
        for(String s: strs){
            res.append(s.length()).append('#').append(s);
        }
        System.out.println(res);
        return res.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int i = 0;
        while(i < str.length()){
            int j = i; // find '#'
            while(str.charAt(j) != '#'){
                j++; // skip #
            }
            // in the first loop;
            // i is 0;
            // j should be 1 because str char 1 is '#';
            int length = Integer.parseInt(str.substring(i,j)); // get the number and parse it to integer;
            System.out.println(length);
            i = j + 1; // skip #
            j = i + length; 
            System.out.println("index i and j: "+ i + "," + j);
            res.add(str.substring(i,j));
            i = j;
            System.out.println("swapped i to j " + i);
        }
        return res;
    }
}
