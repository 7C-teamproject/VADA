package vada.service;

public interface SoldOutService extends BoardService {
	
	public abstract int soldOut(String reserveid,int productnum) throws Exception;
}
