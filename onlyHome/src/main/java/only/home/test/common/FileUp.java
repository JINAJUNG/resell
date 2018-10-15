package only.home.test.common;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public class FileUp {
	private static final int THRESHOLD_SIZE = 1024 * 1024 * 5;// 5MB
	private static final File TEMP_REPOSITORY = new File(System.getProperty("java.io.tmpdir"));
	public static final String UP_PATH = "F:\\develop\\workspace\\onlyHome\\src\\main\\webapp\\resources\\img";

	public static Map<String,String> parseRequest(MultipartHttpServletRequest req) throws Exception{
		if(!ServletFileUpload.isMultipartContent(req)) {
			throw new ServletException("폼 인크립트가 파일업로드에 적합하지 않습니다.");
		}
		DiskFileItemFactory dfFactory = new DiskFileItemFactory(THRESHOLD_SIZE, TEMP_REPOSITORY);
		
		ServletFileUpload sfu = new ServletFileUpload(dfFactory);
		sfu.setHeaderEncoding("utf-8");
		List<FileItem> fList = sfu.parseRequest(req);
		Map<String,String> params = new HashMap<String,String>();
		for(FileItem fi:fList) {
			if(fi.isFormField()) {
				params.put(fi.getFieldName(), fi.getString("utf-8"));
				System.out.println(fi.getFieldName());
			}else {
				continue;/*
				String fName = File.separator + "upload" + File.separator + System.currentTimeMillis() + fi.getName().substring(fi.getName().lastIndexOf("."));
				params.put(fi.getFieldName(), fName);
				System.out.println(fi.getFieldName());
				fi.write(new File(UP_PATH + File.separator + fName));*/
			}
		}
		return params;
	}
}
