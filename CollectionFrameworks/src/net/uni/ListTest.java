package net.uni;

import java.util.ArrayList;
import java.util.List;

public class ListTest {

	public static void main(String[] args) {
		
		// TODO 1. String Type의 List 선언하기
		List<String> titles = new ArrayList<String>();
		// List<Type> 변수명 = new ArrayList<Type>();
		
		// TODO 2. List 데이터 5개 넣기
		titles.add("상하이버거");  // 0
		titles.add("갈릭스테이크버거"); // 1
		titles.add("콰트로치즈와퍼"); // 2
		titles.add("더블치즈타워버거"); // 3
		titles.add("데리버거"); //4
		
		// TODO 3. for 를 이용해서 데이터 출력하기
		int titleSize = titles.size(); // 리스트 원소 개수 구해오기
		
		// 리스트의 원소를 임시로 저장할 수 있는 변수를 만든다.
		String buggerName = null;
		for (int i = 0; i < titleSize; i++) {
			buggerName = titles.get(i);
			System.out.println(buggerName);
		}
		
		// TODO 4. List의 데이터 지워보기
		// 4-1. 인덱스로 지우기
		titles.remove(4); // 데리버거 지우기
		
		// 4-2. 데이터로 지우기
		titles.remove("갈릭스테이크버거");
		
		// TODO 5. 향상된 for를 이용해서 데이터 출력하기
		System.out.println("---------------------------------");
		for (String bugger : titles) {
			System.out.println(bugger);
		}
		
		// TODO 6. List의 contains를 이용해 데이터의 존재 여부를 확인하기
		// 상하이 버거가 있다면 true, 없다면 false를 리턴한다.
		boolean isExistSanghiBugger = titles.contains("상하이버거");
		if ( isExistSanghiBugger ) {
			System.out.println("상하이 버거는 맥도날드에서 판매합니다~");
		}
		
		// TODO 7. List의 indexOf를 이용해 데이터의 인덱스 알아보기
		// 콰트로치즈와퍼가 존재한다면 0 이상을 리턴하고,
		// 그렇지 않다면 -1을 리턴한다.
		int index = titles.indexOf("콰트로치즈와퍼");
		System.out.printf("콰트로 치즈와퍼는 %d에 있습니다.\n", index);
		
		// TODO 8. index로 List의 원소 출력하기
		String bugger = titles.get(index);
		System.out.printf("%d 에는 %s 가 있습니다.\n", index, bugger);
		
		// TODO 9. List의 원소를 모두 지우고, size() 확인하기
		titles.clear(); // 모두 지우기
		
		titleSize = titles.size();
		System.out.println(titleSize);
		
		// Window - Show View - Other - General - Tasks 클릭
		
	}

}
