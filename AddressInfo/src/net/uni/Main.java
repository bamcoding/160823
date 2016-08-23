package net.uni;

import java.util.List;
import java.util.Scanner;

import net.uni.address.AddressBook;
import net.uni.address.AddressInfo;

public class Main {

	/**
	 * 주소록 추가
	 */
	private final int add = 1;
	
	/**
	 * 주소록 전체 조회
	 */
	private final int allQuery = 2;
	
	/**
	 * 주소록 상세 조회
	 */
	private final int oneQuery = 3;
	
	/**
	 * 주소록 수정
	 */
	private final int modify = 4;
	
	/**
	 * 주소록 삭제
	 */
	private final int remove = 5;
	
	/**
	 * 주소록 프로그램 종료
	 */
	private final int quit = 9;
	
	private AddressBook addressBook;
	private Scanner input;
	
	public Main() {
		addressBook = new AddressBook();
		input = new Scanner(System.in);
	}
	
	public void search() {
		hello();
		
		int selectedMenu = 0;
		while(true) {
			showMenu();
			selectedMenu = input.nextInt();
			
			// 정해진 메뉴가 아니라면 다시 선택하게 한다.
			if ( selectedMenu != add && selectedMenu != allQuery 
					&& selectedMenu != oneQuery && selectedMenu != modify
					&& selectedMenu != remove && selectedMenu != quit ) {
				System.out.println("잘못 입력했습니다.");
				continue;
			}
			
			if ( selectedMenu == quit ) {
				break;
			}
			
			exploreAddressBook(selectedMenu);
		}
	}
	
	private void hello() {
		System.out.println("주소록 프로그램입니다!!");
	}
	
	private void showMenu() {
		System.out.println("메뉴를 선택하세요.");
		System.out.println("1. 주소록 추가");
		System.out.println("2. 주소록 전체 조회");
		System.out.println("3. 주소록 상세 조회");
		System.out.println("4. 주소록 수정");
		System.out.println("5. 주소록 삭제");
		System.out.println("9. 주소록 프로그램 종료");
	}
	
	private void exploreAddressBook(int selectedMenu) {
		
		if ( selectedMenu == add ) {
			// 주소록 추가 작업...
			requestCreateAddress();
		}
		else if ( selectedMenu == allQuery ) {
			// 주소록 전체 가져와서 출력하는 작업...
			requestPrintAllAddress();
		}
		else if ( selectedMenu == oneQuery ) {
			// index 입력 받아서 하나만 출력하는 작업...
			requestPrintOneAddress();
		}
		else if ( selectedMenu == modify ) {
			// index 입력받고, 새로운 주소록을 만들어
			//       수정하는 작업...
			requestModifyAddress();
		}
		else if ( selectedMenu == remove ) {
			// index를 입력받아 주소록 삭제하는 작업
			requestRemoveAddress();
		}
		
	}
	
	/**
	 * AddressBook 에게 주소록의 생성을 요청함.
	 */
	private void requestCreateAddress() {
		System.out.println("주소록을 추가합니다. 아래 항목을 입력해 주세요.");
		System.out.print("이름 : ");
		String name = input.next();
		
		input.nextLine(); // 엔터 버그를 해소하기 위한 방법
		
		System.out.print("주소 : ");
		String address = input.nextLine(); // 띄어쓰기를 지원하는 nextLine();
		
		System.out.print("전화번호 : ");
		String phone = input.next();
		
		// 입력 받은 정보로 AddressInfo를 만든다.
		AddressInfo addressInfo = new AddressInfo();
		addressInfo.setName(name);
		addressInfo.setAddress(address);
		addressInfo.setPhone(phone);
		
		// AddressBook 에게 AddressInfo의 등록을 요청한다.
		addressBook.add(addressInfo);
	}
	
	private void requestPrintAllAddress() {
		
		// AddressBook 에서 모든 주소를 가져온다.
		List<AddressInfo> allAddress = addressBook.queryAllAddress();
		
		// 모든 주소를 출력한다.
		int allAddressSize = allAddress.size();
		
		AddressInfo address = null; // 리스트의 데이터를 가져올 임시 변수
		for(int i = 0; i < allAddressSize; i++) {
			address = allAddress.get(i);
			
			System.out.println("==============================");
			System.out.printf("%d 번째 주소 입니다.\n", i);
			System.out.printf("이름 : %s, 주소 : %s, 연락처 : %s\n",
					address.getName(), 
					address.getAddress(), address.getPhone());
			
		}
	}
	
	private void requestPrintOneAddress() {
		
		System.out.println("상세 조회 합니다. 보고싶은 주소의 번호를 입력하세요.");
		int index = input.nextInt();
		
		AddressInfo address = addressBook.queryOneAddress(index);
		System.out.println("==============================");
		System.out.printf("%d 번째 주소 입니다.\n", index);
		System.out.printf("이름 : %s, 주소 : %s, 연락처 : %s\n",
				address.getName(), 
				address.getAddress(), address.getPhone());
		
	}
	
	private void requestModifyAddress() {
		
		System.out.println("주소를 수정합니다. 원하시는 주소의 번호를 입력하세요.");
		int index = input.nextInt();
		
		AddressInfo oldAddress = addressBook.queryOneAddress(index);
		System.out.println("==============================");
		System.out.printf("%d 번째 원본 주소 입니다.", index);
		System.out.printf("이름 : %s, 주소 : %s, 연락처 : %s",
				oldAddress.getName(), 
				oldAddress.getAddress(), oldAddress.getPhone());
		
		System.out.println("새로운 주소를 입력하세요.");
		
		System.out.print("이름 : ");
		String name = input.next();
		
		input.nextLine(); // 엔터 버그를 해소하기 위한 방법
		
		System.out.print("주소 : ");
		String address = input.nextLine(); // 띄어쓰기를 지원하는 nextLine();
		
		System.out.print("전화번호 : ");
		String phone = input.next();
		
		// 입력 받은 정보로 AddressInfo를 만든다.
		AddressInfo addressInfo = new AddressInfo();
		addressInfo.setName(name);
		addressInfo.setAddress(address);
		addressInfo.setPhone(phone);
		
		addressBook.modify(index, addressInfo);
	}
	
	private void requestRemoveAddress() {
		
		System.out.println("주소를 삭제합니다. 삭제하고싶은 주소의 번호를 입력하세요.");
		int index = input.nextInt();
		addressBook.remove(index);
		
	}
	
	public static void main(String[] args) {
		new Main().search();
	}
	
}
