import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class PermutationCombination {
    
	static char[] src;
		
	private static void swap(char[] src, int a, int b) {
		char temp = src[a];
		src[a] = src[b];
		src[b] = temp;
	}
  
	/**
	 * 
	 * @param r
	 * @param curr 현재 선택한 요소의 인덱스 (0 ~ r-1)
	 * @param temp 선택된 요소들이 저장될 배열
	 * @param selected 
	 */
	private static void makePermutation(int r, int curr, char[] temp, boolean[] selected) {
		if (curr == r) { // base case
			// ...
			return;
		}
		
		for (int i = 0; i < src.length; i++) {
			if (selected[i]) {
				selected[i] = true;
				temp[curr] = src[i];
				makePermutation(r, curr + 1, temp, selected);
				selected[i] = false;
			}
		}
	}
	
	private static void makePermutation(int r, int curr, char[] temp, int selected) {
		if (curr == r) { // base case
			// ...
			return;
		}
		
		for (int i = 0; i < src.length; i++) {
			if ((selected & 1 << i) == 0) {
				temp[curr] = src[i];
				makePermutation(r, curr + 1, temp, selected | (1 << i));
			}
		}
	}
	
	private static void makePermutation(int r, int depth) {
		if (depth == r) { // base case
			// ...
			return;
		}
		
		for (int i = depth; i < src.length; i++) {
				swap(src, depth, i);
				makePermutation(r, depth + 1);
				swap(src, depth, i);
			}
	}

	private static boolean nextPermutation() {
		int i = src.length - 2;
		for (; i >= 0; i--) {
			if (src[i] < src[i + 1])
				break;
		}
		
		if (i < 0) 
			return false;
		
		int j = src.length - i;
		for (; j > i; j--) {
			if (src[i] < src[j])
				break;
		}
		
		swap(src, i, j);
		for (int a = i + 1, b = src.length - 1; a < b; a++, b--)
			swap(src, a, b);
		
		return true;
	}
	
	private static void makeCombination(char[] src, int r, int i, char[] temp) {
		if (r == 0) {
			// ...
			return;
		} else if (i == src.length) {
			return;
		}
		
		temp[src.length - 1 - r] = src[i];
		makeCombination(src, r - 1, i + 1, temp); // select src[i]
		makeCombination(src, r, i + 1, temp); // not select src[i] (override)
	}
	
    public static void main(String[] args) throws NumberFormatException, IOException {
        
    }
}
