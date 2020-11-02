package br.com.bb.uop.geadesp.prk.controller;

import br.com.bb.uop.geadesp.prk.entities.PermissoesAcesso;
import br.com.bb.uop.geadesp.prk.entities.UorPos;
import java.util.Collection;
import br.com.bb.uop.geadesp.prk.facade.PermissoesAcessoFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "permissoesAcessoController")
@ViewScoped
public class PermissoesAcessoController extends AbstractController<PermissoesAcesso> {

    // Flags to indicate if child collections are empty
    private boolean isUorPosCollectionEmpty;

    public PermissoesAcessoController() {
        // Inform the Abstract parent controller of the concrete PermissoesAcesso Entity
        super(PermissoesAcesso.class);
    }

    /**
     * Set the "is[ChildCollection]Empty" property for OneToMany fields.
     */
    @Override
    protected void setChildrenEmptyFlags() {
        this.setIsUorPosCollectionEmpty();
    }

    public boolean getIsUorPosCollectionEmpty() {
        return this.isUorPosCollectionEmpty;
    }

    private void setIsUorPosCollectionEmpty() {
        PermissoesAcesso selected = this.getSelected();
        if (selected != null) {
            PermissoesAcessoFacade ejbFacade = (PermissoesAcessoFacade) this.getFacade();
            this.isUorPosCollectionEmpty = ejbFacade.isUorPosCollectionEmpty(selected);
        } else {
            this.isUorPosCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of UorPos entities that are
     * retrieved from PermissoesAcesso and returns the navigation outcome.
     *
     * @return navigation outcome for UorPos page
     */
    public String navigateUorPosCollection() {
        PermissoesAcesso selected = this.getSelected();
        if (selected != null) {
            PermissoesAcessoFacade ejbFacade = (PermissoesAcessoFacade) this.getFacade();
            Collection<UorPos> selectedUorPosCollection = ejbFacade.findUorPosCollection(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("UorPos_items", selectedUorPosCollection);
        }
        return "/app/uorPos/index";
    }

}
