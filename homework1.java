/**
 * Domaci ukol c. 1 z predmetu DSA - Merge Sort
 * ¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨
 * V pripade zjisteni plagiatu bych rad upozornil, ze jsem pouzil verzi ze sveho
 * prvniho ukolu, ktery jsem odevzdaval pred dvemi roky, kdy jsem predmet DSA
 * studoval poprve. Jak prednasejicim (panem Richtou), tak i cvicicim (panem
 * Drchalem) mi bylo pouziti meho minuleho ukolu dovoleno.
 * 
 * @author lunakmar
 */

class Homework1 implements Mergesort{

    @Override
    public int[] getFirstHalfOf(int[] array) {
        /* Pokud uvazujeme pole s lichou velikosti,
         * vracime metodou getFirstHalfOf o 1 vic, nez getSecondHalfOf.
         */
        int newArrayLength = (int) Math.round(((double) array.length)/2);
        int[] newArray = new int[newArrayLength];
        System.arraycopy(array, 0, newArray, 0, newArrayLength);
        return newArray;
    }

    @Override
    public int[] getSecondHalfOf(int[] array) {
        /* Pokud uvazujeme pole s lichou velikosti,
         * bude FirstHalf o 1 vetsi, nez SecondHalf.
         * Podle toho se musi prizpusobit pocatecni index kopirovani.
         */
        int newArrayLength = array.length/2;
        int[] newArray = new int[newArrayLength];
        if((array.length%2) !=0 ) newArrayLength++; // kopírujeme od jedné navíc
        System.arraycopy(array, newArrayLength, newArray, 0, newArray.length);
        return newArray;
    }

    @Override
    public int[] merge(int[] firstHalf, int[] secondHalf) {
        int[] newArray = new int[firstHalf.length + secondHalf.length];
        int pos = 0;
        for (; firstHalf.length > 0 && secondHalf.length > 0; pos++) {
            if(firstHalf[0] < secondHalf[0]) {
                newArray[pos] = firstHalf[0];
                int[] newFirstHalf = new int[firstHalf.length-1];
                System.arraycopy(firstHalf, 1, newFirstHalf, 0, newFirstHalf.length);
                firstHalf = newFirstHalf;
            } else {
                newArray[pos] = secondHalf[0];
                int[] newSecondHalf = new int[secondHalf.length-1];
                System.arraycopy(secondHalf, 1, newSecondHalf, 0, newSecondHalf.length);
                secondHalf = newSecondHalf;
            }
        }
        if(firstHalf.length > 0) {
            for (int i = 0; i < firstHalf.length; i++) {
                newArray[pos] = firstHalf[i];
                pos++;
            }
        }
        if(secondHalf.length > 0) {
            for (int i = 0; i < secondHalf.length; i++) {
                newArray[pos] = secondHalf[i];
                pos++;
            }
        }
        return newArray;
    }

    @Override
    public int[] mergesort(int[] array) {
        if(array.length == 1) return array;
        return merge(mergesort(getFirstHalfOf(array)), mergesort(getSecondHalfOf(array)));
    }

    public void toString(int[] array) {
        for(int num : array) {
            System.out.print(num);
            if(num == array[array.length-1]) System.out.println(";");
            else System.out.print(", ");
        }
    }
}