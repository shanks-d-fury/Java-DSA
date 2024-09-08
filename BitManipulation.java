
public class BitManipulation {

    public static int Get_i_bit(int num, int i) {
        int bit = (num & (1 << i)) == 0 ? 0 : 1;
        return bit;
    }

    public static int Set_i_bit(int num, int i) {
        num = (num | (1 << i));
        return num;
    }

    public static int clear_i_bit(int num, int i) {
        num = (num & (~(1 << i)));
        return num;
    }

    public static int Update_i_bit(int num, int i, int val) {
        if (val == 0) {
            return clear_i_bit(num, i);
        } else {
            return Set_i_bit(num, i);
        }
    }

    public static int clear_last_i_bit(int num, int i) {
        return num & (-1 << i);
    }

    public static int clear_inRange_bits(int num, int i, int j) {
        int bitmask = (-1 << j + 1);
        bitmask = bitmask | (~(-1 << i));
        return num & bitmask;
    }

    public static boolean check_powerOf2(int num) {
        return (num & num - 1) == 0;
    }

    public static int count_setBit(int num) {
        int count = 0;
        while (num > 0) {
            if ((num & 1) == 1) {
                count++;
            }
            num = num >> 1;
        }
        return count;
    }

    public static void main(String[] args) {
        // if we NOT (+num) ==> {-(num+1)}
        // if we NOT (-num) ==> {+(num-1)}
        // System.out.println(~(101));

        //To get the actual value of the compliment we do 2's compliment 
        System.out.println(~(101) + 1);

        // // (i&2)==> pattern is 0,0,2,2 from i=0
        // // (i&3)==> pattern is 0,1,2,3 from i=0
        // // (i&4)==> pattern is 00004444 from i=0 
        // // (i&5)==> pattern is 01014545 from i=0 
        // // (i&6)==> pattern is 00224466 from i=0 
        // // (i&7)==> pattern is 01234567 from i=0 
        for (int i = 0; i < 0; i++) {
            System.out.println(i + " & 1 ==> " + (i & 1));
        }

        // (i&1)==> pattern is (i==even ? i+1 : i)
        for (int i = 0; i < 0; i++) {
            System.out.println(i + " | 2 ==> " + (i | 2));
        }

        // XOR binary operation
        for (int i = 0; i < 0; i++) {
            for (int j = 0; j < 0; j++) {
                System.out.println(i + " ^ " + j + " ==> " + (i | j));
            }
            System.out.println();
        }

        @SuppressWarnings("unused")
        String s = ((1 & 1) == 0) ? "even" : "odd";
        System.out.println(s);

        //Left shift {num << x} ==> {num * 2^x}
        System.out.println(100 << 1);
        for (int i = 0; i < 0; i++) {
            System.out.println(20 + " << " + i + " ==> " + (20 << i));
            System.out.println(20 + " << " + i + " ==> " + (int) (20 * Math.pow(2, i)));
        }

        //Right shift {num >> x} ==> {num * 0.5^x}
        System.out.println(10 >> 1);
        // it divides in half in every step
        for (int i = 0; i < 0; i++) {
            System.out.println(20 + " >> " + i + " ==> " + (20 >> i));
            System.out.println(20 + " >> " + i + " ==> " + (int) (20 * Math.pow(0.5, i)));
        }

        System.out.println(Integer.toBinaryString(4));
        System.out.println("Bit position of 4 of 2 ==> " + Get_i_bit(4, 1));

        //values for below functions
        int num = 10;
        int i_th = 3;
        int j_th = 7;
        int val = 1;
        //Set i'th bit
        System.out.println("Num: " + num + " i : " + i_th + "\n Binery ==> " + Integer.toBinaryString(num) + "\nSet_Bit_i : " + Set_i_bit(num, i_th) + " Binery ==> " + Integer.toBinaryString(Set_i_bit(num, i_th)));
        System.out.println();

        //clear i'th bit 
        System.out.println("Num: " + num + " i : " + i_th + "\n Binery ==> " + Integer.toBinaryString(num) + "\nclear_i_bit : " + clear_i_bit(num, i_th) + " Binery ==> " + Integer.toBinaryString(clear_i_bit(num, i_th)));
        System.out.println();

        //update ith bit 
        System.out.println("Num: " + num + " i : " + i_th + "\n Binery ==> " + Integer.toBinaryString(num) + "\nUpdate_i_bit : " + Update_i_bit(num, i_th, val) + " Binery ==> " + Integer.toBinaryString(Update_i_bit(num, i_th, val)));
        System.out.println();

        // System.out.println(Integer.toBinaryString(-1));
        //clear last i bits 
        System.out.println("Num: " + num + " i : " + i_th + "\n Binery ==> " + Integer.toBinaryString(num) + "\nclear_last_i_bit : " + clear_last_i_bit(num, i_th) + " Binery ==> " + Integer.toBinaryString(clear_last_i_bit(num, i_th)));
        System.out.println();

        //clear range  i,j bits 
        System.out.println("Num: " + num + " i : " + i_th + " j : " + j_th + "\n Binery ==> " + Integer.toBinaryString(num) + "\nclear_inRange_bits : " + clear_inRange_bits(num, i_th, j_th) + " Binery ==> " + Integer.toBinaryString(clear_inRange_bits(num, i_th, j_th)));
        System.out.println();

        //check the power of 2
        System.out.println("Num:" + num + " is of power of 2 " + check_powerOf2(num));
        System.out.println();

        //count set bit 
        System.out.println("Num: " + (num + 100202) + " Binery ==> " + Integer.toBinaryString((num + 100202)) + " count set bit: " + count_setBit((num + 100202)));
        System.out.println();
    }
}
