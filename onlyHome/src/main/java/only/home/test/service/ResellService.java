package only.home.test.service;

import java.util.List;

import only.home.test.vo.ResellInfo;

public interface ResellService {
	public List<ResellInfo> selectResellList(ResellInfo ri);
	public ResellInfo selectResell(Integer pronum);
	public Integer insertResell(ResellInfo ri);
	public Integer updateResell(ResellInfo ri);
	public Integer deleteResell(Integer pronum);
	
}
