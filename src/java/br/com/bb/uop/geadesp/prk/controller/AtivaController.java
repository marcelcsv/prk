package br.com.bb.uop.geadesp.prk.controller;

import br.com.bb.uop.geadesp.prk.entities.Ativa;
import br.com.bb.uop.geadesp.prk.entities.Tags;
import java.util.Collection;
import br.com.bb.uop.geadesp.prk.facade.AtivaFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "ativaController")
@ViewScoped
public class AtivaController extends AbstractController<Ativa> {

    // Flags to indicate if child collections are empty
    private boolean isTagsCollectionEmpty;

    public AtivaController() {
        // Inform the Abstract parent controller of the concrete Ativa Entity
        super(Ativa.class);
    }

    /**
     * Set the "is[ChildCollection]Empty" property for OneToMany fields.
     */
    @Override
    protected void setChildrenEmptyFlags() {
        this.setIsTagsCollectionEmpty();
    }

    public boolean getIsTagsCollectionEmpty() {
        return this.isTagsCollectionEmpty;
    }

    private void setIsTagsCollectionEmpty() {
        Ativa selected = this.getSelected();
        if (selected != null) {
            AtivaFacade ejbFacade = (AtivaFacade) this.getFacade();
            this.isTagsCollectionEmpty = ejbFacade.isTagsCollectionEmpty(selected);
        } else {
            this.isTagsCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Tags entities that are
     * retrieved from Ativa and returns the navigation outcome.
     *
     * @return navigation outcome for Tags page
     */
    public String navigateTagsCollection() {
        Ativa selected = this.getSelected();
        if (selected != null) {
            AtivaFacade ejbFacade = (AtivaFacade) this.getFacade();
            Collection<Tags> selectedTagsCollection = ejbFacade.findTagsCollection(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Tags_items", selectedTagsCollection);
        }
        return "/app/tags/index";
    }

}
