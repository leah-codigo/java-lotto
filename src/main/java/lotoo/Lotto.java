package lotoo;

import java.util.*;

public class Lotto {
    //1-45까지 로또번호 범위
    //1개 > 6개 출력 , 중복불가
    // 보너스 번호 한개 출력 , 중복불가

    private static final int minNumber = 1 ;
    private static final int maxNumber = 45 ;
    private static final int lottoNumberCount = 6;

    @Override
    public String toString() {
        List<Integer> sorted = new ArrayList<>(numbers);
        Collections.sort(sorted);
        return sorted.toString();
    }

    private final Set<Integer> numbers = new HashSet<>();
    private final Random random = new Random();

    public Set generateLottoNumbers() { // 6개 로또 번호 생성
        numbers.clear();
        while (numbers.size() < lottoNumberCount) {
            int num = random.nextInt(maxNumber)+minNumber;
            numbers.add(num);
        }
        return numbers;
    }

    public int generateBonusNumber() { //보너스 번호 1개 생성
        int bonus = random.nextInt(maxNumber) + minNumber;
        while (numbers.contains(bonus)) {
            bonus = random.nextInt(maxNumber)+minNumber;
        }
        numbers.add(bonus);
        return bonus;
    }
}
