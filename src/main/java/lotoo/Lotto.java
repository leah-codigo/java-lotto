package lotoo;

import java.util.*;

public class Lotto {
    //1-45까지 로또번호 범위
    //1개 > 6개 출력 , 중복불가
    // 보너스 번호 한개 출력 , 중복불가

    private static final int minNumber = 1 ;
    private static final int maxNumber = 45 ;
    private static final int lottoNumberCount = 6;
    private static final int bonusNumber = 1 ;

    private final Set<Integer> numbers = new HashSet<>();
    private final Random random = new Random();

    public void generateLottoNumbers() { // 6개 로또 번호 생성
        while (numbers.size() < lottoNumberCount) {
            int num = random.nextInt(maxNumber)+minNumber;
            numbers.add(num);
        }
        Collections.sort(new ArrayList<>(numbers));
        System.out.println(numbers);
    }

    public void generateBonusNumber() { //보너스 번호 1개 생성
        int bonus = random.nextInt(maxNumber) + minNumber;
        while (numbers.contains(bonus)) {
            bonus = random.nextInt(maxNumber)+minNumber;
        }
        numbers.add(bonus);
        System.out.println(bonus);
    }
}
