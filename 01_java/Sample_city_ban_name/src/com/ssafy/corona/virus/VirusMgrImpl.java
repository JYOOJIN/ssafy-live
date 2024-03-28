package com.ssafy.corona.virus;

import java.util.ArrayList;

public class VirusMgrImpl implements VirusMgr {
	//private Virus[] virus;
	private ArrayList<Virus> virus;
	private int index;
	private static VirusMgr instance;
	
	public VirusMgrImpl() {
		//virus=new Virus[100];
		virus = new ArrayList<>();
	}
	
	public static VirusMgr getInstance() {
		if(instance == null) {
			instance = new VirusMgrImpl();
		}
		
		return instance;
	}
	
	@Override
	public void add(Virus v) throws DuplicatedException{
		try {
			search(v.getName());
			
			throw new DuplicatedException(v.getName() + ": 등록된 바이러스입니다.");
		} catch (NotFoundException e) {
			//virus[index++]=v;
			 virus.add(v);
			 index++;
		}
	}
	@Override
	public Virus[] search() {
		//return virus;
		// return Arrays.copyOf(virus, index);
		 return virus.toArray(new Virus[0]);
	}
	@Override
	public Virus search(String name) throws NotFoundException{
//		for(int i=0; i< index; i++) {
//			// virus.length를 사용해서 nullpointerException 발생, index를 대신 사용해서 존재하는 virus만 검색하도록 함
//			if(virus[i].getName().equals(name)) return virus[i];
//		}
		for(int i = 0; i < virus.size(); i++) {
			if(virus.get(i).getName().equals(name)) return virus.get(i);
		}
		throw new NotFoundException(name+": 미등록 바이러스입니다.");
	}
}