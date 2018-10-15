package only.home.test.vo;

import org.apache.ibatis.type.Alias;

@Alias("ri")
public class ResellInfo {
	private Integer pronum; 
	private String procategory; 
	private String proname; 
	private String indate;
	private Integer inpay; 
	private String outdate; 
	private Integer outpay; 
	private String prodesc; 
	private String prophoto;
	
	public ResellInfo() {
		
	}
	public ResellInfo(Integer pronum, String procategory, String proname, String indate, Integer inpay, String outdate,
			Integer outpay, String prodesc, String prophoto) {
		super();
		this.pronum = pronum;
		this.procategory = procategory;
		this.proname = proname;
		this.indate = indate;
		this.inpay = inpay;
		this.outdate = outdate;
		this.outpay = outpay;
		this.prodesc = prodesc;
		this.prophoto = prophoto;
	}
	public Integer getPronum() {
		return pronum;
	}
	public void setPronum(Integer pronum) {
		this.pronum = pronum;
	}
	public String getProcategory() {
		return procategory;
	}
	public void setProcategory(String procategory) {
		this.procategory = procategory;
	}
	public String getProname() {
		return proname;
	}
	public void setProname(String proname) {
		this.proname = proname;
	}
	public String getIndate() {
		return indate;
	}
	public void setIndate(String indate) {
		this.indate = indate;
	}
	public Integer getInpay() {
		return inpay;
	}
	public void setInpay(Integer inpay) {
		this.inpay = inpay;
	}
	public String getOutdate() {
		return outdate;
	}
	public void setOutdate(String outdate) {
		this.outdate = outdate;
	}
	public Integer getOutpay() {
		return outpay;
	}
	public void setOutpay(Integer outpay) {
		this.outpay = outpay;
	}
	public String getProdesc() {
		return prodesc;
	}
	public void setProdesc(String prodesc) {
		this.prodesc = prodesc;
	}
	public String getProphoto() {
		return prophoto;
	}
	public void setProphoto(String prophoto) {
		this.prophoto = prophoto;
	}
	@Override
	public String toString() {
		return "ResellInfo [pronum=" + pronum + ", procategory=" + procategory + ", proname=" + proname + ", indate="
				+ indate + ", inpay=" + inpay + ", outdate=" + outdate + ", outpay=" + outpay + ", prodesc=" + prodesc
				+ ", prophoto=" + prophoto + "]";
	} 
	
	
}
