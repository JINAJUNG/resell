package only.home.test.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import only.home.test.dao.ResellDAO;
import only.home.test.vo.ResellInfo;

@Repository
public class ResellDAOImpl implements ResellDAO {

	
	@Autowired
	public SqlSession ss;

	@Override
	public List<ResellInfo> selectResellList(ResellInfo ri) {
		// TODO Auto-generated method stub
		return ss.selectList("SQL.resell.selectResell", ri);
	}

	@Override
	public ResellInfo selectResell(Integer pronum) {
		// TODO Auto-generated method stub
		ResellInfo ri = new ResellInfo();
		ri.setPronum(pronum);
		return ss.selectOne("SQL.resell.selectResell", ri);
	}

	@Override
	public Integer insertResell(ResellInfo ri) {
		// TODO Auto-generated method stub
		return ss.insert("SQL.resell.insertResell", ri);
	}

	@Override
	public Integer updateResell(ResellInfo ri) {
		// TODO Auto-generated method stub
		return ss.update("SQL.resell.updateResell", ri);
	}

	@Override
	public Integer deleteResell(Integer pronum) {
		// TODO Auto-generated method stub
		return ss.delete("SQL.resell.deleteResell", pronum);
	}
}
