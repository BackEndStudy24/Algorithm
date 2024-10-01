package week01;

import java.util.LinkedList;
import java.util.Scanner;

public class BOJ_1021 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        LinkedList<Integer> list = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            list.add(i);
        }

        //System.out.println("list : " + list);

        LinkedList<Integer> selectList = new LinkedList<>();

        for (int i = 0; i < M; i++) {
            int num = sc.nextInt();
            selectList.add(num);
        }

        //System.out.println("selectList : " + selectList);

        //sc.close();


        int count = 0;

        for (int i = 0; i < selectList.size(); i++) {

            int index = list.indexOf(selectList.get(i));

            int linePoint;

            if (list.size() % 2 == 0) {
                linePoint = list.size() / 2 - 1;
            } else {
                linePoint = list.size() / 2;
            }

            if (index <= linePoint) {
                for (int j = 0; j < index; j++) {
                    //System.out.println("2번 방식 실행");

                    list.addLast(list.pollFirst());
                    count++;
                }
            } else {
                //System.out.println("index : " + index);
                for(int j = list.size(); j > index; j--) {
                    //System.out.println("3번 방식 실행");

                    list.addFirst(list.pollLast());
                    count++;
                }
            }
            list.removeFirst();
            //System.out.println(list + " / " + count);
        }
        System.out.println(count);
    }
}