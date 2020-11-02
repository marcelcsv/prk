package br.com.bb.uop.geadesp.prk.converter;

import br.com.bb.uop.geadesp.prk.entities.Jurisdicionadas;
import br.com.bb.uop.geadesp.prk.facade.JurisdicionadasFacade;
import br.com.bb.uop.geadesp.prk.controller.util.JsfUtil;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.convert.FacesConverter;
import javax.enterprise.inject.spi.CDI;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

@FacesConverter(value = "jurisdicionadasConverter")
public class JurisdicionadasConverter implements Converter {

    private JurisdicionadasFacade ejbFacade;

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
        if (object instanceof Jurisdicionadas) {
            Jurisdicionadas o = (Jurisdicionadas) object;
            return getStringKey(o.getIdJurisdicionada());
        } else {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Jurisdicionadas.class.getName()});
            return null;
        }
    }

    private JurisdicionadasFacade getEjbFacade() {
        this.ejbFacade = CDI.current().select(JurisdicionadasFacade.class).get();
        return this.ejbFacade;
    }
}
