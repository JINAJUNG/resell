package only.home.test.dao;

import java.util.List;

import only.home.test.vo.ResellInfo;

public interface ResellDAO {
	public List<ResellInfo> selectResellList(ResellInfo ri);
	public ResellInfo selectResell(Integer pronum);
	public Integer insertResell(ResellInfo ri);
	public Integer updateResell(ResellInfo ri);
	public Integer deleteResell(Integer pronum);
}
