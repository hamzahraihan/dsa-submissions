class Solution {
    public int reverse(int x) {
        long res = 0;
        while(x != 0){
            res = res * 10 + x % 10;
            x = x / 10;
        }
        System.out.println(res);

        if(res > Integer.MAX_VALUE || res < Integer.MIN_VALUE){
            return 0;
        }

        return (int) res;
    }
}

// intuisi
/*
kita bisa memanfaatkan perkalian dan pembagian pada permasalahan ini
coba 
 */