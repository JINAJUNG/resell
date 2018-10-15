package only.home.test.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import only.home.test.service.ResellService;
import only.home.test.vo.ResellInfo;

@Controller
public class ResellController {

	@Autowired
	private ResellService rs;

	@RequestMapping(value = "/resellList", method = RequestMethod.GET)
	@ResponseBody
	public List<ResellInfo> selectResellList(@ModelAttribute ResellInfo ri) {
		return rs.selectResellList(ri);
	}

	@RequestMapping(value = "/resellList/{pronum}", method = RequestMethod.GET)
	@ResponseBody
	public ResellInfo selectResell(@PathVariable Integer pronum) {
		return rs.selectResell(pronum);
	}

	@RequestMapping(value="/resellList",method=RequestMethod.POST)
	public @ResponseBody Integer insertResell(@ModelAttribute ResellInfo ri,BindingResult result, MultipartHttpServletRequest multi) throws IllegalStateException, IOException{
		MultipartFile mf = multi.getFile("prophoto");
		String path = "F:\\develop\\workspace\\onlyHome\\src\\main\\webapp\\resources\\img";
		if(!mf.isEmpty()){
			if(mf.getOriginalFilename().lastIndexOf(".png")!=-1 || mf.getOriginalFilename().lastIndexOf(".PNG")!=-1 ) {
				path = path+File.separator+System.currentTimeMillis()+mf.getOriginalFilename().substring(mf.getOriginalFilename().lastIndexOf("."));
				System.out.println(path);
				File file = new File(path);
				mf.transferTo(file);
				ri.setProphoto(path.substring(path.lastIndexOf("\\")+1));
			}else {
				return -1;
			}
		}
		return  rs.insertResell(ri);
	}

	@RequestMapping(value = "/resellList/{pronum}", method = RequestMethod.PUT)
	public @ResponseBody Integer updateResell(@PathVariable Integer pronum,@RequestBody ResellInfo ri) throws IllegalStateException, IOException {
		System.out.println(ri);
		ri.setPronum(pronum);

		return rs.updateResell(ri);
	}

	@RequestMapping(value = "/resellList/{pronum}", method = RequestMethod.DELETE)
	public @ResponseBody Integer deleteResell(@PathVariable Integer pronum) {
		return rs.deleteResell(pronum);
	}
}
