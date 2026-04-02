package lotoo;

import java.util.List;

public class Result {

    // 당첨 등수 계산
    public int checkResult(List<Lotto> myLottos,List<Integer> readNumbers,int bonusNumber) {

        for (Lotto myLotto : myLottos) { // 로또 한장(한줄씩) 꺼내기
            int matchCount = 0;

            for (int num : myLotto.getNumbers()) { // 한장의 로또안에 숫자 하나씩 꺼내서 비교
                if (readNumbers.contains(num)) { // 입력한 6개숫자랑 비교해서 같으면 증가 ++
                    matchCount++;
                }
            }
            if (matchCount == 5) { // 2등 검증 > // 5개 + 보너스번호 맞춤
                boolean bonusMatch =myLotto.getNumbers().contains(bonusNumber);
                if (bonusMatch) {
                    return 7;
                }
            }
            if (matchCount ==3 | matchCount ==4 | matchCount == 5 |matchCount == 6) {
                return matchCount;
            }
        }
            return 0;
    }

    // 등수내역 출력
    public String calculateResult(List<Lotto> myLottos,List<Integer> readNumbers,int bonusNumber) {
        int matchCount = checkResult(myLottos,readNumbers,bonusNumber);

        if (matchCount == 6) {
             return "1등: 6개 번호 일치 / 2,000,000,000원 " ;
        } else if (matchCount == 7) {
            return "2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원 ";
        } else if (matchCount == 5) {
            return " 3등: 5개 번호 일치 / 1,500,000원 ";
        } else if (matchCount == 4) {
            return "4등: 4개 번호 일치 / 50,000원 ";
        } else if (matchCount == 3) {
            return "5등: 3개 번호 일치 / 5,000원 ";
        }

        return " 꽝! ";
    }

    // 수익률계산 >>  수익률(%) = (총 당첨금 / 총 구매금액) × 100
    public String calculateReturnRate(int money,List<Lotto> myLottos,List<Integer> readNumbers,int bonusNumber) {
        int matchCount = checkResult(myLottos,readNumbers,bonusNumber);
        double returnRate =0;

        if (matchCount == 6) {
            returnRate = (Rank.lottoRank.FIRST.getValue() / money) * 100;
        } else if (matchCount == 7) {
            returnRate = (Rank.lottoRank.SECOND.getValue() / money) * 100;
        } else if (matchCount == 5) {
            returnRate =  (Rank.lottoRank.THIRD.getValue() / money) * 100;
        } else if (matchCount == 4) {
            returnRate =  (Rank.lottoRank.FOURTH.getValue() / money) * 100;
        } else if (matchCount == 3) {
            returnRate = (Rank.lottoRank.FIFTH.getValue() / money) * 100;
        }


        return "총 수익률은 " + returnRate + "% 입니다.";
    }
}
