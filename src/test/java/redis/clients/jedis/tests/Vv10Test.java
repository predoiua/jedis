package redis.clients.jedis.tests;


import java.util.List;

import redis.clients.jedis.Jedis;

public class Vv10Test {
	private Jedis jedis;
	private String res;
	private List<String> rl;
	private int nr;
    
	public Vv10Test(){
		jedis = new Jedis("127.0.0.1", 6379);
	}
	private void print_rl(){
	    nr = 0;
	    if ( rl == null )
	    	System.out.println("Empty");
	    else
		    for(String r:rl) {
		    	System.out.println( (++nr) + " :" + r);
		    }
	}
	public void test1(){

	    
	    res = jedis.get("k");
	    System.out.println("Res get:" + res);
	    res = jedis.set("k", "val");
	    System.out.println("Res set:" + res);
	    res = jedis.get("k");
	    System.out.println("Res get:" + res);
	    rl = jedis.mget( new String[] {"k","k1"} );
	    print_rl();
	}
	
	public void test_plan1(){
		rl = jedis.vvget("c1", "1","2","3");
		print_rl();
		rl = jedis.vvset("c1",10., "1","2","3");
		print_rl();
		System.out.println("=== set same value ===");
		rl = jedis.vvset("c1",10., "1","2","3");
		print_rl();
	}
	
	public static void main(String[] args) {
		
		Vv10Test m = new Vv10Test();
		m.test1();
		m.test_plan1();
		System.out.println("ok");
		
		
	}
}
