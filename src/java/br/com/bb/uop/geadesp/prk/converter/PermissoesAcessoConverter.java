package br.com.bb.uop.geadesp.prk.converter;

import br.com.bb.uop.geadesp.prk.entities.PermissoesAcesso;
import br.com.bb.uop.geadesp.prk.facade.PermissoesAcessoFacade;
import br.com.bb.uop.geadesp.prk.controller.util.JsfUtil;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.convert.FacesConverter;
import javax.enterprise.inject.spi.CDI;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

@FacesConverter(value = "permissoesAcessoConverter")
public class PermissoesAcessoConverter implements Converter {

    private PermissoesAcessoFacade ejbFacade;

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
        if (value == null || value.length() == 0 || JsfUtil.isDummySelectItem(component, value)) {
            return null;
        }
        return this.getEjbFacade().find(getKey(value));
    }

    java.lang.Integer getKey(String value) {
        java.lang.Integer key;
        key = Integer.valueOf(value);
        return key;
    }

    String getStringKey(java.lang.Integer value) {
        StringBuffer sb = new StringBuffer();
        sb.append(value);
        return sb.toString();
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
        if (object == null
                || (object instanceof String && ((String) object).length() == 0)) {
            return null;
        }
        if (object instanceof PermissoesAcesso) {
            PermissoesAcesso o = (PermissoesAcesso) object;
            return getStringKey(o.getIdPermissaoAcesso());
        } else {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), PermissoesAcesso.class.getName()});
            return null;
        }
    }

    private PermissoesAcessoFacade getEjbFacade() {
        this.ejbFacade = CDI.current().select(PermissoesAcessoFacade.class).get();
        return this.ejbFacade;
    }
}
