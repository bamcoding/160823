package net.uni.address;

import java.util.ArrayList;
import java.util.List;

public class AddressBook {

	private List<AddressInfo> addressList;
	
	public AddressBook() {
		addressList = new ArrayList<AddressInfo>();
	}
	
	public void add(AddressInfo addressInfo) {
		addressList.add(addressInfo);
	}
	
	public void modify(int index, AddressInfo addressInfo) {
		// index 에 있는 원소를 addressInfo로 바꾼다.
		addressList.set(index, addressInfo);
		
		// 지웠다가 추가하기
//		remove(index);
//		add(addressInfo);
	}
	
	public void remove(int index) {
		addressList.remove(index);
	}
	
	public List<AddressInfo> queryAllAddress() {
		return addressList;
	}
	
	public AddressInfo queryOneAddress(int index) {
		return addressList.get(index);
	}
	
}
