package lotoo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottos {

    private List<Lotto> lottos = new ArrayList<>();


    // 구매가능한 수량만큼 로또 생성
    public List<Lotto> generateLottos(int count) {

        for (int i = 0; i < count; i++) {
            Lotto lotto = new Lotto();
            lotto.generateLottoNumbers();
            lottos.add(lotto);
        }
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
        return lottos;
    }


}
