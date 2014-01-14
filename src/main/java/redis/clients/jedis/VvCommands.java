package redis.clients.jedis;

import java.util.List;

public interface VvCommands {
	// Allocate memory for cube 
	Long vvcube(String cube, String... nr_di_per_dim );
	
	// Set a value
	List<String> vvset (String cube, double val, String... idx);
	//List<String> 
	List<String> vvget (String cube, String... idx);
}
