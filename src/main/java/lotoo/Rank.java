package lotoo;

public class Rank {


    public enum lottoRank {
        FIFTH(3, 5000),
        FOURTH(4, 50000),
        THIRD(5, 1500000),
        SECOND(5, 30000000),
        FIRST(6, 2000000000);

        private final int count;
        private final int value;

        public int getCount() {
            return count;
        }

        public int getValue() {
            return value;
        }

        lottoRank(int count, int value) {
            this.count = count;
            this.value = value;

        }
    }


}
