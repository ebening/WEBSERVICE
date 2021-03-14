package com.uadec.core.cm;

import com.ibm.mm.sdk.common.DKConstant;

public abstract class BaseDocumentoCm extends BaseModelCm implements Modelable {

	private String url;
	private FileCm file;

	protected BaseDocumentoCm(String url, FileCm file) {
		super();
		this.url = url;
		this.file = file;
	}

	/**
	 * @return La url del documento.
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url
	 *            - La url para asignar.
	 */
	public void setUrl(String url) {
		if (url != null && !url.isEmpty()) {
			this.url = url;
		}
	}

	public FileCm getFile() {
		return file;
	}

	public void setFile(FileCm file) {
		this.file = file;
	}
	@Override
	public short getType() {
		return DKConstant.DK_CM_DOCUMENT;
	}
}