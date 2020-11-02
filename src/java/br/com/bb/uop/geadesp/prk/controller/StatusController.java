package br.com.bb.uop.geadesp.prk.controller;

import br.com.bb.uop.geadesp.prk.entities.Status;
import br.com.bb.uop.geadesp.prk.entities.Tags;
import java.util.Collection;
import br.com.bb.uop.geadesp.prk.facade.StatusFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "statusController")
@ViewScoped
public class StatusController extends AbstractController<Status> {

    // Flags to indicate if child collections are empty
    private boolean isTagsCollectionEmpty;

    public StatusController() {
        // Inform the Abstract parent controller of the concrete Status Entity
        super(Status.class);
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
        Status selected = this.getSelected();
        if (selected != null) {
            StatusFacade ejbFacade = (StatusFacade) this.getFacade();
            this.isTagsCollectionEmpty = ejbFacade.isTagsCollectionEmpty(selected);
        } else {
            this.isTagsCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Tags entities that are
     * retrieved from Status and returns the navigation outcome.
     *
     * @return navigation outcome for Tags page
     */
    public String navigateTagsCollection() {
        Status selected = this.getSelected();
        if (selected != null) {
            StatusFacade ejbFacade = (StatusFacade) this.getFacade();
            Collection<Tags> selectedTagsCollection = ejbFacade.findTagsCollection(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Tags_items", selectedTagsCollection);
        }
        return "/app/tags/index";
    }

}
