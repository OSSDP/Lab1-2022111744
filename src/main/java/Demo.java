import io.shardingsphere.shardingjdbc.api.yaml.YamlShardingDataSourceFactory;
import javax.sql.DataSource;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo {
    public static void main(String[] args) throws SQLException, IOException {
        File conf = new File("./src/main/resources/conf.yml");
        DataSource dataSource = YamlShardingDataSourceFactory.createDataSource(conf);
        Connection conn = dataSource.getConnection();
        Statement stmt = conn.createStatement();

        System.out.println(stmt.executeUpdate("insert into users(id, name) values(1, 'zhangsan')"));
        System.out.println(stmt.executeUpdate("insert into item(id, value) values(1, 100)"));
        System.out.println(stmt.executeUpdate("insert into item(id, value) values(2, 200)"));
        //first 
    }
}
