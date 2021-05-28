package kr.ac.green.a;

public class Doit {
	
	public static void main(String[] args) {
		Join join = new Join();
		join.doJoin();
		
		Join join2 = new Join("skdndnf", "±è¼ºÈÆ", "123qwe", "¶±¼ö", true);
		System.out.println(join2);
		
		Login login = new Login(join2, join2);
		System.out.println(login);
	}
}
