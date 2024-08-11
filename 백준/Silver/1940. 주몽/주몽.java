import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		int[] array = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(array);
		int result = 0;
		int start = 0;
		int end = n - 1;
		while (start < end) {
			if (array[start] + array[end] < m) {
				start++;
			} else if (array[start] + array[end] > m) {
				end--;
			} else {
				result++;
				start++;
				end--;
			}
		}
		System.out.println(result);
		br.close();
	}
}