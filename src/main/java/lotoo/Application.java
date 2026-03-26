package lotoo;

import java.util.logging.Logger;
public class Application {
    private static final Logger logger = Logger.getLogger(Application.class.getName());
    public static void main(String[] args) {
        logger.info(" 게임시작 ");
        System.out.println("게임 시작!");

    Lotto lotto = new Lottos();
    lotto.generateLottoNumbers();
    lotto.generateBonusNumber();
    }
}
