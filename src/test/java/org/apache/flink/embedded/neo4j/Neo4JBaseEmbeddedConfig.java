package org.apache.flink.embedded.neo4j;

import java.util.HashMap;
import java.util.Map;
import org.apache.flink.streaming.connectors.neo4j.Neo4JDriverWrapper;
import org.junit.Before;
import org.junit.ClassRule;
import org.neo4j.harness.junit.Neo4jRule;

/**
 * @author Alberto De Lazzari
 */
public class Neo4JBaseEmbeddedConfig {

	public static final String DEFAULT_URL = "bolt://localhost:7687";

	public static final String DEFAULT_USERNAME = "walt";

	public static final String DEFAULT_PASSWORD = "neo4j";

	@ClassRule
	public static Neo4jRule neo4jRule;

	public static Neo4JDriverWrapper driverWrapper;

	public static Map<String, String> neo4JConfig;

	static {
		neo4jRule = new Neo4jRule().withFixture("CREATE (i:Item {description:'an item'})");
	}

	@Before
	public void init() {
		neo4JConfig = new HashMap<String, String>();
		neo4JConfig.put(Neo4JDriverWrapper.URL, DEFAULT_URL);
		neo4JConfig.put(Neo4JDriverWrapper.USERNAME_PARAM, DEFAULT_USERNAME);
		neo4JConfig.put(Neo4JDriverWrapper.PASSWORD_PARAM, DEFAULT_PASSWORD);
//		neo4JConfig.put(Neo4JDriverWrapper.SESSION_LIVENESS_TIMEOUT, "40000");

		driverWrapper = new Neo4JDriverWrapper(neo4JConfig);
	}
}
