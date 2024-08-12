import java.util.Scanner;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.StringTokenizer;
import java.util.LinkedList;
import java.util.Deque;

public class Main {
	public static final Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		Deque<Node> mydeque = new LinkedList<>();
		
		for (int i = 0; i < n; i++) {
			int now = Integer.parseInt(st.nextToken());
			
			while (!mydeque.isEmpty() && mydeque.getLast().value > now) {
				mydeque.removeLast();
			}
			
			mydeque.addLast(new Node(now, i));
			
			if (mydeque.getFirst().index <= i - l) {
				mydeque.removeFirst();
			}
			
			bw.write(mydeque.getFirst().value + " ");
		}
		bw.flush();
		bw.close();
	}
	
	static class Node {
		public int value;
		public int index;
		
		Node(int value, int index) {
			this.value = value;
			this.index = index;
		}
	}
}