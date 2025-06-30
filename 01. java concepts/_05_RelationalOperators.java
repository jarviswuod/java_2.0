public class _05_RelationalOperators {
    public static void main(String args[]) {
        // < > <= >= == !=
        int firstBro = 24;
        int firstSiz = 30;
        int secondBro = 20;
        int thirdBro = 14;

        System.out.println("firstBro is older than firstSiz : " + (firstBro > firstSiz));
        System.out.println("thirdBro is same as firstSiz : " + (thirdBro == firstSiz));
        System.out.println("firstSiz is younger than secondBro : " + (firstSiz < secondBro));
        System.out.println("thirdBro is older than firstSiz : " + (thirdBro >= firstSiz));
        System.out.println("firstSiz is older than secondBro : " + (firstSiz <= secondBro));
        System.out.println("thirdBro is not the same age firstSiz : " + (thirdBro != firstSiz));
    }
}
