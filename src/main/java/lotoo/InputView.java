package lotoo;

import java.util.Scanner;

public class InputView {

    public int getInputAmount() {
        return inputAmount;
    }

    public void setInputAmount(int inputAmount) {
        this.inputAmount = inputAmount;
    }

    private int inputAmount = 0 ; // 유저가 입력한 금액
    private static final int lottoPrice = 1000; // 로또 한개 금액 , 고정값
    private static String exceptionMessage = "[ERROR]";
    private Scanner scanner = new Scanner(System.in);

    // 금액받기
    public void readPurchaseAmount() {
        System.out.print("구매 원하시는 금액을 입력 해주세요(1장 - 1,000원): ");
        inputAmount = scanner.nextInt();
        if (inputAmount < 0) { // 예외처리 : 음수인 경우
            throw new IllegalArgumentException(exceptionMessage + " 구매 불가합니다.");
        } else if (inputAmount % 1000 != 0) { // 예외처리: 금액 천원단위 안떨어질때
            throw new IllegalArgumentException(exceptionMessage + " 1,000원 단위로 입력해주세요.");
        }
    }


    // 로또 번호 6개 받기 / 중복없이 / 범위: 1-45까지
    
    // 보너스 번호 받기/ 중복없이
    //음수 입력 시 예외처리


}
