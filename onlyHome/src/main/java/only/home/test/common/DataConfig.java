package only.home.test.common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import net.sf.log4jdbc.Log4jdbcProxyDataSource;
import net.sf.log4jdbc.tools.Log4JdbcCustomFormatter;
import net.sf.log4jdbc.tools.LoggingType;

@Configuration
public class DataConfig {
	
	@Bean
	public HikariConfig hikariCon() {
		HikariConfig hikariConfig =null;
		try {
			//아래처럼 파일경로 읽어올것!--
			InputStream is = DataConfig.class.getResourceAsStream("/config/db.properties");
			Properties prop = new Properties();
			prop.load(is);
			hikariConfig = new HikariConfig();
			hikariConfig.setJdbcUrl(prop.getProperty("db.jdbcUrl"));
			hikariConfig.setUsername(prop.getProperty("db.username"));
			hikariConfig.setPassword(prop.getProperty("db.password"));
			hikariConfig.setDriverClassName(prop.getProperty("db.driverClassName"));
			hikariConfig.setAutoCommit(prop.getProperty("db.autoCommit").equals("false"));
			hikariConfig.setMinimumIdle(Integer.parseInt(prop.getProperty("db.minimumIdle")));
			hikariConfig.setMaximumPoolSize(Integer.parseInt(prop.getProperty("db.maximumPoolSize")));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return hikariConfig;
	}
	
	@Bean
	public HikariDataSource hikariDataSource() {
		return new HikariDataSource(hikariCon());
	}
	
	@Bean
	public Log4jdbcProxyDataSource dataSourceProxy() {
		Log4jdbcProxyDataSource dsp = new Log4jdbcProxyDataSource(hikariDataSource());
		Log4JdbcCustomFormatter logFormatter = new Log4JdbcCustomFormatter();
		logFormatter.setLoggingType(LoggingType.SINGLE_LINE);
		logFormatter.setSqlPrefix("CUSTOM SQL LOG : ========>");
		dsp.setLogFormatter(logFormatter);
		return dsp;
	}
	
	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean ssfb = new SqlSessionFactoryBean();
		PathMatchingResourcePatternResolver pmrpr = new PathMatchingResourcePatternResolver();
		ssfb.setDataSource(dataSourceProxy());
		ssfb.setMapperLocations(pmrpr.getResources("classpath:mapper/*.xml"));
		ssfb.setConfigLocation(pmrpr.getResource("classpath:config/mybatis.xml"));
		return (SqlSessionFactory) ssfb.getObject();
	}
	
	@Bean
	public SqlSession sqlSession() throws Exception {
		SqlSessionFactory ssf = sqlSessionFactory();
		return ssf.openSession();
	}
	

}
