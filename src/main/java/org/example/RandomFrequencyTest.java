package org.example;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class RandomFrequencyTest {
    public static void main(String[] args) {
        // 필요한 횟수와 숫자 범위 설정
        int iterations = 200000;
        int min = 1;
        int max = 45;
        int count = 6;

        // 각 숫자의 출현 빈도를 기록할 배열 초기화
        int[] frequency = new int[max];

        // Randoms.pickUniqueNumbersInRange을 200,000번 실행하여 결과를 기록
        for (int i = 0; i < iterations; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(min, max, count);
            for (Integer number : numbers) {
                frequency[number - 1]++; // 1부터 시작하므로 인덱스 조정
            }
        }

        // 출현 빈도 출력
        for (int i = 0; i < frequency.length; i++) {
            System.out.println("숫자 " + (i + 1) + ": " + frequency[i] + " 번뽑힘");
        }

        // 평균 빈도와 편차 계산
        int totalSum = 0;
        for (int freq : frequency) {
            totalSum += freq;
        }
        double average = (double) totalSum / max;

        double deviationSum = 0;
        for (int freq : frequency) {
            double deviation = freq - average;
            deviationSum += deviation * deviation;
        }
        double standardDeviation = Math.sqrt(deviationSum / max);

        System.out.println("평균 값: " + average);
        System.out.println("Standard deviation: " + standardDeviation);
    }
}