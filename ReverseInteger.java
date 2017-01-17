// https://leetcode.com/problems/reverse-integer/
public class ReverseInteger {
  public int reverse(int x) {
    if(x == Integer.MIN_VALUE) {
        return 0;
    }

    int number = (x > 0) ? x : -x;
    long answer = 0;

    do {
        answer *= 10;
        answer += number % 10;
        number /= 10;
    }while (number != 0);

    long min = (Integer.MIN_VALUE);
    if (x > 0 && answer > Integer.MAX_VALUE) {
        return 0;
    } else if (x < 0 && answer > -min) {
        return 0;
    }

    int answer_int = (x > 0) ? (int)answer : -(int)answer;
    return answer_int;
}
}
