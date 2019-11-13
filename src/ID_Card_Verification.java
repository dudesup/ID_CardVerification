import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class ID_Card_Verification {

    public boolean verification(String ID_Number) {
        boolean correcIDNumber = false;

        Map<Character, Integer> code = new LinkedHashMap<>();
        code.put('A', 10);
        code.put('B', 11);
        code.put('C', 12);
        code.put('D', 13);
        code.put('E', 14);
        code.put('F', 15);
        code.put('G', 16);
        code.put('H', 17);
        code.put('I', 18);
        code.put('J', 19);
        code.put('K', 20);
        code.put('L', 21);
        code.put('M', 22);
        code.put('N', 23);
        code.put('O', 24);
        code.put('P', 25);
        code.put('Q', 26);
        code.put('R', 27);
        code.put('S', 28);
        code.put('T', 29);
        code.put('U', 30);
        code.put('V', 31);
        code.put('W', 32);
        code.put('X', 33);
        code.put('Y', 34);
        code.put('Z', 35);

        int[] weight = new int[]{7, 3, 1, 9, 7, 3, 1, 7, 3};
        int[] number = new int[9];
        for (int i = 0; i < ID_Number.length(); i++) {
            if (i < 3) {
                if (code.get(ID_Number.charAt(i)) != null) {
                    number[i] = code.get(ID_Number.charAt(i));
                    System.out.println(number[i]);
                }
            } else {
                number[i] = Character.getNumericValue(ID_Number.charAt(i));
                System.out.println(number[i]);
            }
        }

        Arrays.setAll(number, operand -> number[operand] *= weight[operand]);
        int sum = IntStream.of(number).sum();
        if (sum % 10 == 0) {
            correcIDNumber = true;
        }
        return correcIDNumber;
    }

    public static void main(String[] args) {
        ID_Card_Verification verify = new ID_Card_Verification();
        System.out.println(verify.verification("AWR236893"));
    }
}
