package br.com.bb.uop.geadesp.prk.controller;

import br.com.bb.uop.geadesp.prk.entities.UorPos;
import br.com.bb.uop.geadesp.prk.entities.Tags;
import br.com.bb.uop.geadesp.prk.entities.Tags;
import java.util.Collection;
import br.com.bb.uop.geadesp.prk.facade.UorPosFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "uorPosController")
@ViewScoped
public class UorPosController extends AbstractController<UorPos> {

    @Inject
    private PermissoesAcessoController idPermissaoAcessoController;

    // Flags to indicate if child collections are empty
    private boolean isTagsCollectionEmpty;
    private boolean isTagsCollection1Empty;

    public UorPosController() {
        // Inform the Abstract parent controller of the concrete UorPos Entity
        super(UorPos.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idPermissaoAcessoController.setSelected(null);
    }

    /**
     * Set the "is[ChildCollection]Empty" property for OneToMany fields.
     */
    @Override
    protected void setChildrenEmptyFlags() {
        this.setIsTagsCollectionEmpty();
        this.setIsTagsCollection1Empty();
    }

    /**
     * Sets the "selected" attribute of the PermissoesAcesso controller in order
     * to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdPermissaoAcesso(ActionEvent event) {
        UorPos selected = this.getSelected();
        if (selected != null && idPermissaoAcessoController.getSelected() == null) {
            idPermissaoAcessoController.setSelected(selected.getIdPermissaoAcesso());
        }
    }

    public boolean getIsTagsCollectionEmpty() {
        return this.isTagsCollectionEmpty;
    }

    private void setIsTagsCollectionEmpty() {
        UorPos selected = this.getSelected();
        if (selected != null) {
            UorPosFacade ejbFacade = (UorPosFacade) this.getFacade();
            this.isTagsCollectionEmpty = ejbFacade.isTagsCollectionEmpty(selected);
        } else {
            this.isTagsCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Tags entities that are
     * retrieved from UorPos and returns the navigation outcome.
     *
     * @return navigation outcome for Tags page
     */
    public String navigateTagsCollection() {
        UorPos selected = this.getSelected();
        if (selected != null) {
            UorPosFacade ejbFacade = (UorPosFacade) this.getFacade();
            Collection<Tags> selectedTagsCollection = ejbFacade.findTagsCollection(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Tags_items", selectedTagsCollection);
        }
        return "/app/tags/index";
    }

    public boolean getIsTagsCollection1Empty() {
        return this.isTagsCollection1Empty;
    }

    private void setIsTagsCollection1Empty() {
        UorPos selected = this.getSelected();
        if (selected != null) {
            UorPosFacade ejbFacade = (UorPosFacade) this.getFacade();
            this.isTagsCollection1Empty = ejbFacade.isTagsCollection1Empty(selected);
        } else {
            this.isTagsCollection1Empty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Tags entities that are
     * retrieved from UorPos and returns the navigation outcome.
     *
     * @return navigation outcome for Tags page
     */
    public String navigateTagsCollection1() {
        UorPos selected = this.getSelected();
        if (selected != null) {
            UorPosFacade ejbFacade = (UorPosFacade) this.getFacade();
            Collection<Tags> selectedTagsCollection1 = ejbFacade.findTagsCollection1(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Tags_items", selectedTagsCollection1);
        }
        return "/app/tags/index";
    }

}
