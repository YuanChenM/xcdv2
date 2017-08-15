package com.bms.slpd.bean;

import java.io.Serializable;

/**
 * <p>指定需要修改的字段，true：修改，false：不修改。</p>
 */
public class BaseTarget implements Serializable {
	protected static final long serialVersionUID = 1L;

	/** delFlg字段 */
	private boolean delFlgFlg;
	/** updId字段 */
	private boolean updIdFlg;
	/** updTime字段 */
	private boolean updTimeFlg;
	/** version字段 */
	private boolean versionFlg;

	public boolean isDelFlgFlg() {
		return delFlgFlg;
	}
	
	public void setDelFlgFlg(boolean delFlgFlg) {
		this.delFlgFlg = delFlgFlg;
	}

	public boolean isUpdIdFlg() {
		return updIdFlg;
	}

	public void setUpdIdFlg(boolean updIdFlg) {
		this.updIdFlg = updIdFlg;
	}

	public boolean isUpdTimeFlg() {
		return updTimeFlg;
	}

	public void setUpdTimeFlg(boolean updTimeFlg) {
		this.updTimeFlg = updTimeFlg;
	}

	public boolean isVersionFlg() {
		return versionFlg;
	}

	public void setVersionFlg(boolean versionFlg) {
		this.versionFlg = versionFlg;
	}
}
