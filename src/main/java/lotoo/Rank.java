package lotoo;

public class Rank {


    public enum lottoRank {
        FIFTH(3, 5000,false), //5등
        FOURTH(4, 50000,false), //4등
        THIRD(5, 1500000,false), //3등
        SECOND(5, 30000000,true), //2등
        FIRST(6, 2000000000,false); //1등

        private final int count;
        private final int value;
        private final boolean isBonus;

        public int getCount() {
            return count;
        }

        public int getValue() {
            return value;
        }

        public boolean isBonus() {
            return isBonus;
        }

        lottoRank(int count, int value, boolean isBonus) {
            this.count = count;
            this.value = value;
            this.isBonus = isBonus;

        }
    }


}
