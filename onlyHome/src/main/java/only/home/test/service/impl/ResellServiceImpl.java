package only.home.test.service.impl;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import only.home.test.dao.ResellDAO;
import only.home.test.service.ResellService;
import only.home.test.vo.ResellInfo;

@Service
public class ResellServiceImpl implements ResellService {

	@Autowired
	private ResellDAO rdao;
	
	@Override
	public List<ResellInfo> selectResellList(ResellInfo ri) {
		// TODO Auto-generated method stub
		return rdao.selectResellList(ri);
	}

	@Override
	public ResellInfo selectResell(Integer pronum) {
		// TODO Auto-generated method stub
		return rdao.selectResell(pronum);
	}

	@Override
	public Integer insertResell(ResellInfo ri) {
		// TODO Auto-generated method stub
		return rdao.insertResell(ri);
	}

	@Override
	public Integer updateResell(ResellInfo ri) {
		// TODO Auto-generated method stub
		if(ri.getOutdate()!=null) {
			ri.setOutdate(ri.getOutdate().replace("-", ""));
		}
		System.out.println(ri);
		return rdao.updateResell(ri);
	}

	@Override
	public Integer deleteResell(Integer pronum) {
		// TODO Auto-generated method stub
		String path = "F:\\develop\\workspace\\onlyHome\\src\\main\\webapp\\resources\\img";
		ResellInfo ri = rdao.selectResell(pronum);
		File f = new File(path, ri.getProphoto());
		f.delete();
		return rdao.deleteResell(pronum);
	}

}
