package lotoo;

import java.util.List;

public class Result {

    // 당첨 등수 계산
    public int[] checkResult(List<Lotto> myLottos,List<Integer> readNumbers,int bonusNumber) {
        int[] rankArray = new int[6]; //1-5등까지 저장

        for (Lotto myLotto : myLottos) { // 로또 한장(한줄씩) 꺼내기
            int matchCount = 0;

            for (int num : myLotto.getNumbers()) { // 한장의 로또안에 숫자 하나씩 꺼내서 비교
                if (readNumbers.contains(num)) { // 입력한 6개숫자랑 비교해서 같으면 증가 ++
                    matchCount++;
                }
            }

            if(matchCount == 6) { // 1등값 저장
                rankArray[1]++;
            } else if (matchCount == 5 && myLotto.getNumbers().contains(bonusNumber)) { //2등값 저장
                rankArray[2]++;
            } else if (matchCount == 5) { //3등값 저장
                rankArray[3]++;
            } else if (matchCount == 4) { //4등값 저장
                rankArray[4]++;
            } else if (matchCount == 3) { //5등값 저장
                rankArray[5]++;
            }
        }
        return rankArray;
    }

    // 등수 계산내역 출력
    public String calculateResult(List<Lotto> myLottos,List<Integer> readNumbers,int bonusNumber) {
        int[] rankArray = checkResult(myLottos,readNumbers,bonusNumber);

        return "1등: 6개 번호 일치 / 2,000,000,000원 - " + rankArray[1] + "개\n" +
                "2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원 - " + rankArray[2] + "개\n" +
                "3등: 5개 번호 일치 / 1,500,000원 - " + rankArray[3] + "개\n" +
                "4등: 4개 번호 일치 / 50,000원 - " + rankArray[4] + "개\n" +
                "5등: 3개 번호 일치 / 5,000원 - " + rankArray[5] + "개";



    }

    // 수익률계산 >>  수익률(%) = (총 당첨금 / 총 구매금액) × 100
    public String calculateReturnRate(int money,List<Lotto> myLottos,List<Integer> readNumbers,int bonusNumber) {
        int[] rankArray = checkResult(myLottos,readNumbers,bonusNumber);

        int total = 0;
        // 총당첨금
        total += rankArray[1] * Rank.lottoRank.FIRST.getValue();
        total += rankArray[2] * Rank.lottoRank.SECOND.getValue();
        total += rankArray[3] * Rank.lottoRank.THIRD.getValue();
        total += rankArray[4] * Rank.lottoRank.FOURTH.getValue();
        total += rankArray[5] * Rank.lottoRank.FIFTH.getValue();

        double returnRate = (double) total / money * 100;
        return "총 수익률은 " + returnRate + "% 입니다.";
    }
}
