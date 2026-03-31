package lotoo;

import java.util.List;
import java.util.logging.Logger;
public class Application {
    // private static final Logger logger = Logger.getLogger(Application.class.getName());
    public static void main(String[] args) {
        // logger.info(" 게임시작 ");
    System.out.println("게임 시작!");

    InputView inputView = new InputView();
    Lottos lottos = new Lottos();
    Lotto lotto = new Lotto();

        inputView.readPurchaseAmount();
        List<Integer> print = inputView.readLottoNumbers();
        System.out.println(print.toString());
        int bonus = inputView.LottoBonusNumber();
        System.out.println("보너스 번호: " + bonus);

        inputView.outputTicketCount();
        int count = inputView.ticketCount();
        lottos.generateLottos(count);





    }
}
