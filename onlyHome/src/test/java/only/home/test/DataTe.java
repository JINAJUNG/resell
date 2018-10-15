package only.home.test;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import only.home.test.common.DataConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {DataConfig.class})
public class DataTe {

	
	@Autowired
	SqlSession ss;

	@Test
	public void tete() {
		System.out.println(ss.selectOne("SQL.resell.selectResell"));
	}
}
