
public class BitManipulation {

    public static int Get_i_bit(int num, int i) {
        int bit = (num & (1 << i)) == 0 ? 0 : 1;
        return bit;
    }

    public static int Set_i_bit(int num, int i) {
        num = (num | (1 << i));
        return num;
    }

    public static void main(String[] args) {
        // if we NOT (+num) ==> {-(num+1)}
        // if we NOT (-num) ==> {+(num-1)}
        // System.out.println(~(101));

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
        System.out.println(10 << 1);
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

        // System.out.println(Integer.toBinaryString(1000));
        System.out.println("Bit position of 4 of 2 ==> " + Get_i_bit(1000, 3));

        //Set i'th bit 
        int num = 10;
        int i_th = 10;
        System.out.println("Num: " + num + " Binery ==> " + Integer.toBinaryString(num) + "\nSet_Bit_i : " + Set_i_bit(num, i_th) + " Binery ==> " + Integer.toBinaryString(Set_i_bit(num, i_th)));
    }
}
