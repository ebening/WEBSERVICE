package com.uadec.core.cm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.ibm.mm.sdk.common.DKChildCollection;
import com.ibm.mm.sdk.common.DKConstant;
import com.ibm.mm.sdk.common.DKDDO;
import com.ibm.mm.sdk.common.DKException;
import com.ibm.mm.sdk.common.DKUsageError;
import com.ibm.mm.sdk.server.DKDatastoreICM;
import com.uadec.core.util.CoreUtil;

public abstract class BaseModelCm implements Modelable {

	private final static Logger log = Logger.getLogger(BaseModelCm.class);

	private Map<String, Object> attributesValues = new HashMap<String, Object>();
	private List<GroupAtributoCm> groupAttributesValues = new ArrayList<GroupAtributoCm>();

	private String pid;

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public void setValuesAttributes(DKDatastoreICM dsIcm, List<AtributoCm> atributos, DKDDO document) {
		mapAttributesValues(attributesValues, groupAttributesValues);
		Object value, correctValue;
		for (AtributoCm attr : atributos) {
			if (attributesValues.containsKey(attr.getName())) {
				value = attributesValues.get(attr.getName());
				correctValue = CoreUtil.convertToValue(attr.getName(), value, attr.getClazz());
				try {
					log.info("Setting value for attribute: " + attr.getName());
					document.setData(document.dataId(DKConstant.DK_CM_NAMESPACE_ATTR, attr.getName()), correctValue);
				} catch (DKUsageError e) {
					log.error("Error al establecer el valor del atributo: " + attr.getName() + " para el modelo "
							+ this.getModel(), e);
				}
			} else {
				log.info("El valor para el atributo: " + attr.getName() + " no ha sido establecido.");
			}

		}
		for (GroupAtributoCm group : groupAttributesValues) {
			try {
				short id = document.dataId(DKConstant.DK_CM_NAMESPACE_CHILD, group.getName());
				if (id != 0) {
					DKChildCollection children = (DKChildCollection) document.getData(id);
					if (children == null) {
						children = new DKChildCollection();
						document.setData(id, children);
					}
					for (List<AtributoCm> attrsValues : group.getListAttributesValues()) {
						DKDDO child = dsIcm.createChildDDO(this.getModel(), group.getName());
						children.addElement(child);
						for (AtributoCm attr : attrsValues) {
							child.setData(child.dataId(DKConstant.DK_CM_NAMESPACE_ATTR, attr.getName()),
									attr.getValor());

						}
					}
				}
			} catch (DKUsageError e) {
				log.error(e);
			} catch (DKException e) {
				log.error(e);
			} catch (Exception e) {
				log.error(e);
			}
		}
	}
}