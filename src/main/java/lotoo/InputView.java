package lotoo;

import java.util.*;

public class InputView {

    private int inputAmount; // 유저가 입력한 금액
    private static final int lottoPrice = 1000; // 로또 한개 금액 , 고정값
    private static String exceptionMessage = "[ERROR]";
    private Scanner scanner = new Scanner(System.in);
    private List<Integer> inputLottoNumbers = new ArrayList<>();

    private static final int maxNumber = 45 ;
    private static final int lottoNumberCount = 6;


    // 금액받기
    public int readPurchaseAmount() {
            System.out.print("구매금액을 입력해 주세요. (1장 - 1,000원): ");
            inputAmount = scanner.nextInt();
            scanner.nextLine();

            if (inputAmount <= 0) { // 예외처리 : 음수인 경우
                throw new IllegalArgumentException(exceptionMessage + "금액은 0보다 커야 합니다.");
            }
            if (inputAmount % lottoPrice != 0) { // 예외처리: 1000원으로 안나눠지는 경우
                throw new IllegalArgumentException(exceptionMessage + " 1,000원 단위로 입력해주세요.");
            }

            return inputAmount;
    }

    public int ticketCount() { // 구매 가능 티켓 수량
        return inputAmount / lottoPrice;
    }

    public void outputTicketCount() {
        System.out.println(ticketCount() + "개를 구매했습니다.");
    }

    // 로또 번호 6개 받기 / 중복없이 / 범위: 1-45까지
    // 보너스 번호
    public List<Integer> readLottoNumbers() {
        inputLottoNumbers.clear();

            System.out.println("당첨번호를 입력해 주세요 ( , 구분) : ");
            String lottoNumbers = scanner.nextLine();
            String[] numbers = lottoNumbers.split(",");
            if (numbers.length != lottoNumberCount) { // 예외처리: 로또 번호가 6개가 아닌 경우
                throw new IllegalArgumentException(exceptionMessage + " 6개의 번호를 입력해주세요.");
            }

            for (int i = 0; i < numbers.length; i++) {
                    int num = Integer.parseInt(numbers[i]);

                    if (num <= 0 || num > maxNumber) { //예외처리: 음수 또는 45이상인 경우
                        throw new IllegalArgumentException(exceptionMessage + " 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
                    }
                    if (inputLottoNumbers.contains(num)) { // 예외처리: 번호 중복인 경우
                        throw new IllegalArgumentException(exceptionMessage + " 중복되는 번호가 있습니다.");
                    }
                    inputLottoNumbers.add(num);
                    Collections.sort(inputLottoNumbers);
            }

        return inputLottoNumbers;
    }

    public int LottoBonusNumber() {
        int bonusNumber;
        bonusNumber = 0;

            System.out.println("보너스 번호를 입력해 주세요 (중복불가) : ");
            bonusNumber = scanner.nextInt();
            scanner.nextLine();
             if (bonusNumber <= 0 ||bonusNumber > maxNumber) { // 예외처리: 음수 또는 45이상인 경우
                 throw new IllegalArgumentException(exceptionMessage + " 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
             }
             if (inputLottoNumbers.contains(bonusNumber)) { // 예외처리: 번호 중복인 경우
                 throw new IllegalArgumentException(exceptionMessage + " 중복 불가 합니다.");
             }

        return bonusNumber;
    }


}
