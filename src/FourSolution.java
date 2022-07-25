import java.util.*;

public class FourSolution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        List<Integer> list = new ArrayList<>();
        int firstSum = 0;
        int lastSum = 0;
        int answer = 0;
        for (int i = 0; i < n; i++){
            list.add(scanner.nextInt());
            firstSum += list.get(i);
        }
        list.sort(Comparator.reverseOrder());
        List<Integer> minList = new ArrayList<>();
        Collections.min(list);
        for (int i = 0; i < k; i++){
            if (n > 1){
                minList.add(Collections.min(list));
                list.remove(Collections.min(list));
            }
        }
        while (k > 0) {
            if (n == 1){
                break;
            }
            for (int i = 0; i < minList.size(); i++) {
                if (minList.get(i) < 9 && minList.get(i) >= 0) {
                    minList.set(i, 9);
                } else if (minList.get(i) < 100 && minList.get(i) > 9) {
                    minList.set(i, 99);
                } else if (minList.get(i) <= 999 && minList.get(i) > 99) {
                minList.set(i, 999);
                }
                k--;
            }
        }
        minList.addAll(list);
        for (int i =0; i< minList.size();i++){
            lastSum += minList.get(i);
        }
        answer = lastSum - firstSum;
        System.out.println(answer);
    }
}