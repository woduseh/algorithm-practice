package practice.algorithm;

import static practice.modernjava.functional.Subsets.subsets;

import java.util.Arrays;
import java.util.stream.IntStream;

public class CalcTugOfWar {

    public static void main(String[] args) {
        CalcTugOfWar tugOfWar = new CalcTugOfWar();

        System.out.println(Arrays.toString(tugOfWar.solution(new int[]{90, 35, 55, 90})));
        System.out.println(Arrays.toString(tugOfWar.solution(new int[]{40, 40, 50, 50, 100, 100})));
    }

    /**
     * 문제 설명: 줄다리기를 진행해야 함.
     *
     * <p>줄다리기는 여러 사람을 두 편으로 배분하는데, 두 편의 몸무게 합은 일치해야 함.
     *
     * <p>주어진 입력에서 가장 많은 사람들이 줄다리기를 참가할 수 있는 수와 한 팀의 무게 합을 배열로 반환하라.
     *
     * <p>(가장 많은 사람들이 줄다리기를 참가할 수 있는 경우의 수가 여럿이라면 한 팀의 무게 합이 가장 높은 케이스를
     * 반환하라)
     *
     * @param weights - 줄다리기에 참가하는 사람들의 몸무게
     * @return int[] - 줄다리기에 참가하는 사람들의 숫자와 몸무게의 합이 가장 높은 케이스의 배열
     */
    public int[] solution(int[] weights) {
        var maxSum = 0;
        var maxNum = 0;

        var list = subsets(IntStream.of(weights)
                .boxed()
                .sorted()
                .toList());

        for (var l : list) {

            if (l.size() > 1) {
                var sum = l.stream().mapToInt(i -> i).sum();

                // 배열의 모든 부분합을 찾는다
                var newList = subsets(l);

                // 배열의 부분합이 sum / 2와 일치하는가 확인한다
                // 일치하는 경우, 부분합의 합을 저장한다
                var partialSum = newList.stream()
                        .filter(i -> i.stream().mapToInt(j -> j).sum() == sum / 2)
                        .mapToInt(i -> i.stream().mapToInt(j -> j).sum())
                        .max().orElse(0);

                // 부분합이 sum / 2와 일치할 경우, 가장 많은 사람이 줄다리기에 참가할 수 있는지 확인한다.
                // 기존 값을 갱신할 경우, 그대로 저장
                // 기존 값을 갱신하진 못하지만 일치할 경우 몸무게 합 확인하여 저장 여부 결정
                if (partialSum != 0 && (partialSum > maxSum || (partialSum == maxSum
                        && l.size() > maxNum))) {
                    maxSum = partialSum;
                    maxNum = l.size();
                }
            }
        }

        return new int[]{maxNum, maxSum};
    }
}
