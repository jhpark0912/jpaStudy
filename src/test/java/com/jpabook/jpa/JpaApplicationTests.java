package com.jpabook.jpa;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class JpaApplicationTests {

	public int[] solution(int n, int[][] edges) {
		int[] answer = new int[2];
		int[] cnt = new int[n];
		List<Integer> candidate = new ArrayList<>();
		List<Integer> candidateSec = new ArrayList<>();
		int maxCnt = -1;
		for(int[] edge: edges) {
			cnt[edge[0]] += 1;
			cnt[edge[1]] += 1;
			int tempCnt = Math.max( cnt[edge[0]], cnt[edge[1]]);
			maxCnt = Math.max(maxCnt, tempCnt);
		}

		for(int i = 0; i < n; i++) {
			int temp = cnt[i];
			if (maxCnt == temp) {
				candidate.add(i);
			} else if (maxCnt -1 == temp) {
				candidateSec.add(i);
			}
		}
		int idx = 0;
		for(int i = 0 ; i < edges.length; i++) {
			int a = edges[i][0];
			int b = edges[i][1];

			if(candidate.contains(a) && candidateSec.contains(b)) {
				candidate.remove(a);
				candidateSec.remove(b);

				answer[idx++] = i;
			} else if(candidate.contains(b) && candidateSec.contains(a)) {
				candidate.remove(b);
				candidateSec.remove(a);

				answer[idx++] = i;
			}

			if (idx == 2) {
				break;
			}

		}

		return answer;
	}

	@Test
	void contextLoads() {
		int [][] data = {{0,2},{2,1},{2,4},{3,5},{5,4},{5,7},{7,6},{6,8}};
		System.out.println(solution(9, data).toString());
	}

}
