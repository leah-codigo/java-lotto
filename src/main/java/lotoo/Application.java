package lotoo;

import java.util.List;

public class Application {

    public static void main(String[] args) {

        InputView inputView = new InputView();
        Lottos lottos = new Lottos();
        Result result = new Result();

        System.out.println("게임 시작!");
        int money = inputView.readPurchaseAmount(); // 구매 원하는 금액 받기

        List<Integer> readNumbers = inputView.readLottoNumbers(); // 원하는 로또 번호 6개 입력
        System.out.println(readNumbers.toString());

        int bonusNumber = inputView.LottoBonusNumber(); // 보너스번호 입력
        System.out.println("보너스 번호: " + bonusNumber);

        inputView.outputTicketCount(); // 로또 구매 수량 [금액/1,000원]
        int count = inputView.ticketCount();
        System.out.println(" ");

        List<Lotto> myLottos= lottos.generateLottos(count); // 로또 구매 수량 만큼 로또 생성
        System.out.println(" ");

        System.out.println(result.calculateResult(myLottos, readNumbers, bonusNumber)); // 당첨내역 출력
        System.out.println(" ");

        System.out.println(result.calculateReturnRate(money,myLottos,readNumbers,bonusNumber)); // 수익률
    }

    }

